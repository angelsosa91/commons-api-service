package py.com.solar.commonsapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);
    public static void main(String[] args) {
        logger.info("<=== Iniciando {} ... ===>", Application.class.getName());
        SpringApplication.run(Application.class, args);
        logger.info("<=== {} Iniciado correctamente ===>", Application.class.getName());
    }

}
