package dio.aula.model.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDto {

    private Integer id;
    private String name;
    private LocalDate birthDay;
    private String email;
    private String password;

}
