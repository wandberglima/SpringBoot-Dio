package dio.dio.spring.security.jwt.service;

import dio.dio.spring.security.jwt.models.User;
import dio.dio.spring.security.jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        String pass = user.getPassword();
//        user.setPassword(passwordEncoder.encode(pass));
        userRepository.save(user);
    }

}
