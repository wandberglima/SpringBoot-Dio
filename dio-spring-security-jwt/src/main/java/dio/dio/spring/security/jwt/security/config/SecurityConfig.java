package dio.dio.spring.security.jwt.security.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@ConfigurationProperties(prefix = "security.config")
@Getter
@Setter
public class SecurityConfig {

    @Value("${security.config.prefix}")
    public static String PREFIX;

    @Value("${security.config.key}")
    public static String KEY;

    @Value("${security.config.expiration}")
    public static Long EXPIRATION;

    public void setPREFIX(String prefix) {
        PREFIX = prefix;
    }

    public void setKEY(String key) {
        KEY = key;
    }
    public void setEXPIRATION(Long expiration) {
        EXPIRATION = expiration;
    }

}
