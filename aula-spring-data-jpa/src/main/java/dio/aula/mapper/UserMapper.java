package dio.aula.mapper;

import dio.aula.model.UserModel;
import dio.aula.model.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserMapper {

    @Mapping(target = "code", source = "id")
    @Mapping(target = "username", source = "name")
    @Mapping(target = "birthday", source = "birthDay")
    UserModel toModel(final UserDto dto);

    @Mapping(target = "id", source = "code")
    @Mapping(target = "name", source = "username")
    @Mapping(target = "birthDay", source = "birthday")
    UserDto toDTO(final UserModel model);

}
