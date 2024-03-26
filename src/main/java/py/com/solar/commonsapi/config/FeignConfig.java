package py.com.solar.commonsapi.config;

import feign.Logger;
import feign.okhttp.OkHttpClient;
import feign.RequestInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import py.com.solar.commonsapi.utils.AuthenticationUtils;

@Configuration
@RequiredArgsConstructor
@EnableFeignClients(basePackages = "py.com.solar.commonsapi.client")
public class FeignConfig {

    @Bean
    public OkHttpClient client() {
        return new OkHttpClient();
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header(AuthenticationUtils.AUTHORIZATION_HEADER, AuthenticationUtils.getBearerTokenHeader());
            requestTemplate.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
            requestTemplate.header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        };
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    /*@Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
    private static final String TOKEN_ROUTE = "/realms/master/protocol/openid-connect/token";

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            if (StringUtils.isNotBlank(requestTemplate.url()) && !requestTemplate.url().contains(TOKEN_ROUTE)) {
                requestTemplate.header(AuthenticationUtils.AUTHORIZATION_HEADER, AuthenticationUtils.getBearerTokenHeader());
                requestTemplate.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
                requestTemplate.header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
            }
        };
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
    */
}