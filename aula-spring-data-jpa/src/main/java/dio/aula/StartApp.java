//package dio.aula;
//
//import dio.aula.mapper.UserMapper;
//import dio.aula.model.UserModel;
//import dio.aula.model.dto.UserDto;
//import dio.aula.repository.UserRepository;
//import org.mapstruct.factory.Mappers;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDate;
//import java.util.Date;
//import java.util.List;
//
//@Component
//public class StartApp implements CommandLineRunner {
//
//    @Autowired
//    private UserRepository userRepository;
//
//
//
//
//
////    public void run(String... args) throws Exception {
////        List<UserModel> users = userRepository.filtrarPorNome("wandberg");
////        for (UserModel u : users) {
////            System.out.println(u);
////        }
////    }
//
//    public void run(String... args) throws Exception {
//        List<UserModel> userModels = userRepository.findAll();
//        for (UserModel u : userModels) {
//            System.out.println(u);
//        }
//    }
//
//    private void insertUser(){
//
//        var userModel = new UserModel();
//        userModel.setCode(1);
//        userModel.setUsername("wandberg");
//        userModel.setEmail("wandberg@teste.com");
//        userModel.setBirthday(LocalDate.now().minusYears(18));
//        userModel.setPassword("teste123456");
//        System.out.println(mapper.toDTO(userModel));
//
//        var userDto = new UserDto();
//        userDto.setId(2);
//        userDto.setName("jessica");
//        userDto.setEmail("jessica@gmail.com");
//        userDto.setBirthDay(LocalDate.now().minusYears(20));
//        userDto.setPassword("abc123");
//        System.out.println(mapper.toModel(userDto));
//
//
//
//        userRepository.save(userModel);
//
//        for (UserModel u : userRepository.findAll()) {
//            System.out.println(u);
//        }
//    }
//}
