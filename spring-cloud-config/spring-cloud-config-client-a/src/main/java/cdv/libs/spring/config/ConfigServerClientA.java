package cdv.libs.spring.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

/**
 * Config server client that uses shared and application specific properties
 * from both default and "dev" profiles
 *
 * @author Dmitry Kulga
 *         11.03.2018 18:13
 */
@SpringBootApplication
public class ConfigServerClientA {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerClientA.class, args);
    }

    private final Logger log = LoggerFactory.getLogger(ConfigServerClientA.class);

    @Value("${shared.non-env.property}")
    private String sharedNonEnvProperty;

    @Value("${shared.env.property}")
    private String sharedEnvProperty;

    @Value("${client-a.non-env.property}")
    private String clientNonEnvProperty;

    @Value("${client-a.env.property}")
    private String clientEnvProperty;

    @PostConstruct
    public void init() {
        log.info(">>> Shared non env property is: " + sharedNonEnvProperty);
        log.info(">>> Shared env property is: " + sharedEnvProperty);
        log.info(">>> Client non env property is: " + clientNonEnvProperty);
        log.info(">>> Client env property is: " + clientEnvProperty);
    }

}
