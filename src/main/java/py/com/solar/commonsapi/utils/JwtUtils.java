package py.com.solar.commonsapi.utils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtUtils {

    private final JwtDecoder jwtDecoder;

    public String getUsername() {
        var token = AuthenticationUtils.getToken();
        var jwt = jwtDecoder.decode(token);

        return jwt.getClaim("preferred_username");
    }

}
