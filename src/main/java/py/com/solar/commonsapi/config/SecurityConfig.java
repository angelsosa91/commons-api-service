package py.com.solar.commonsapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import py.com.solar.commonsapi.utils.BaseAPI;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

@Configuration
@Profile("!test")
@Order(SecurityProperties.BASIC_AUTH_ORDER - 10)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${spring.security.oauth2.client.provider.keycloak.jwk-set-uri}")
    private String jwtUriCert;

    private static final String BEARER_ = "Bearer";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().authorizeRequests().antMatchers("/swagger-ui/*").permitAll()
                .and().cors()
                .and().authorizeRequests(authorizeRequests -> authorizeRequests
                        .antMatchers(HttpMethod.OPTIONS, BaseAPI.BASE_PATH.concat("/**")).permitAll()
                        .antMatchers(BaseAPI.BASE_PATH.concat("/**"))
                        .authenticated()
                        .anyRequest()
                        .permitAll()).oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
        ;
    }

    @Bean
    JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withJwkSetUri(jwtUriCert).build();
    }

    @Bean
    CorsFilter corsFilter() {
        var source = new UrlBasedCorsConfigurationSource();
        var corsConfiguration = new CorsConfiguration();

        corsConfiguration.setAllowedOrigins(List.of("*"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS", "PATCH"));
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.setMaxAge(Duration.ofMinutes(10));
        source.registerCorsConfiguration("/**", corsConfiguration);

        return new CorsFilter(source);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}