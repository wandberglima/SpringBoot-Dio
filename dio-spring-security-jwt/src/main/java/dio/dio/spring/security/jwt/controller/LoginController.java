package dio.dio.spring.security.jwt.controller;

import dio.dio.spring.security.jwt.models.User;
import dio.dio.spring.security.jwt.models.dtos.Login;
import dio.dio.spring.security.jwt.models.dtos.Sessao;
import dio.dio.spring.security.jwt.repository.UserRepository;
import dio.dio.spring.security.jwt.security.JWTCreator;
import dio.dio.spring.security.jwt.security.JWTObject;
import dio.dio.spring.security.jwt.security.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping
public class LoginController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SecurityConfig securityConfig;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public Sessao logar(@RequestBody Login login) {
        // Busca o usuário no banco de dados
        User user = userRepository.findByUsername(login.getUsername());

        if (user != null) {
            // Verifica se a senha informada está correta
            boolean verificado = passwordEncoder.matches(login.getPassword(), user.getPassword());

            if (!verificado) {
                throw new RuntimeException("Senha inválida para o login: " + login.getUsername());
            }

            // Cria o objeto de sessão para retornar o login e o token
            Sessao sessao = new Sessao();
            sessao.setLogin(user.getUsername());

            // Criação do JWTObject contendo as informações para o token
            JWTObject jwtObject = new JWTObject();
            jwtObject.setIssuedAt(new Date(System.currentTimeMillis()));
            jwtObject.setExpiration(new Date(System.currentTimeMillis() + SecurityConfig.EXPIRATION));

            // Passa os papéis (roles) do usuário
            jwtObject.setRoles(user.getRoles());

            // Gera o token JWT
            String token = JWTCreator.createJWT(SecurityConfig.PREFIX, SecurityConfig.KEY, jwtObject);

            // Adiciona o token à sessão
            sessao.setToken(token);

            // Retorna a sessão com o login e o token
            return sessao;
        } else {
            throw new RuntimeException("Erro ao tentar fazer login. Usuário não encontrado.");
        }
    }
}