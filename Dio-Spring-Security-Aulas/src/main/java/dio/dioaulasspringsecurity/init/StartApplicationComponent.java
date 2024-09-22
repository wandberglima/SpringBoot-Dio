package dio.dioaulasspringsecurity.init;

import dio.dioaulasspringsecurity.entities.User;
import dio.dioaulasspringsecurity.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class StartApplicationComponent implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(StartApplicationComponent.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        User user = userRepository.findByUsername("admin");
        if (user == null) {
            user = new User();
            user.setName("admins");
            user.setUsername("admin");
            user.setPassword(passwordEncoder.encode("admin123"));
            user.getRoles().add("MANAGERS");
            userRepository.save(user);
            logger.info("User ADMIN created: " + user);
        }
        user = userRepository.findByUsername("user");
        if (user == null) {
            user = new User();
            user.setName("users");
            user.setUsername("user");
            user.setPassword(passwordEncoder.encode("user123"));
            user.getRoles().add("USERS");
            userRepository.save(user);
            logger.info("User USER created: " + user);
        }
    }
}
