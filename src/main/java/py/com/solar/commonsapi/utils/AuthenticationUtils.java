package py.com.solar.commonsapi.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Objects;

public abstract class AuthenticationUtils {

    private static final String BEARER_ = "Bearer ";
    public static final String AUTHORIZATION_HEADER = "Authorization";

    public static String getBearerTokenHeader() {
        var requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (Objects.isNull(requestAttributes)) {
            return "";
        }

        return requestAttributes.getRequest().getHeader(AUTHORIZATION_HEADER);
    }

    public static String getToken() {
        return getBearerTokenHeader().replace(BEARER_, "");
    }

    public static String getBearerString(String token) {
        return BEARER_.concat(token);
    }
}
