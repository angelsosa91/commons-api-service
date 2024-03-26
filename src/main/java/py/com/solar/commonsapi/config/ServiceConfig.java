package py.com.solar.commonsapi.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class ServiceConfig {
    @Value("${spring.datasource.session}")
    private String userSession;
}