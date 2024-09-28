package dio.myfirstwebapi.controller;

import dio.myfirstwebapi.model.Usuario;
import dio.myfirstwebapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsuarioController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<Usuario> getUsers(){
        return userRepository.findAll();
    }
    @GetMapping("/{id}")
    public Usuario getUserById(@PathVariable("id") Integer id){
        return userRepository.findById(id);
    }

    @GetMapping("/{login}")
    public Usuario getUserByUserName(@PathVariable("login") String login){
        return userRepository.findByUserName(login);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        userRepository.deleteById(id);
    }

    @PostMapping
    public void postUsuario(@RequestBody Usuario usuario){
    userRepository.save(usuario);
    }





}
