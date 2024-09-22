package dio.dio.spring.security.jwt.models.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Login {

    private String username;
    private String password;

}
