package dio.aula;

import dio.aula.mapper.UserMapper;
import dio.aula.model.UserModel;
import dio.aula.model.dto.UserDto;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class AulaSpringDataJpaApplication {
	private static UserMapper mapper = Mappers.getMapper(UserMapper.class);

	public static void main(String[] args) {
		SpringApplication.run(AulaSpringDataJpaApplication.class, args);

		var userModel = new UserModel();
		userModel.setCode(1);
		userModel.setUsername("wandberg");
		userModel.setEmail("wandberg@teste.com");
		userModel.setBirthday(LocalDate.now().minusYears(18));
		userModel.setPassword("teste123456");
		System.out.println(mapper.toDTO(userModel));

		var userDto = new UserDto();
		userDto.setId(2);
		userDto.setName("jessica");
		userDto.setEmail("jessica@gmail.com");
		userDto.setBirthDay(LocalDate.now().minusYears(20));
		userDto.setPassword("abc123");
		System.out.println(mapper.toModel(userDto));
	}

}
