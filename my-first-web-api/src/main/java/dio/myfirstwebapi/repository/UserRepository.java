package dio.myfirstwebapi.repository;

import dio.myfirstwebapi.config.handler.BusinessException;
import dio.myfirstwebapi.config.handler.CampoObrigatorioException;
import dio.myfirstwebapi.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    public void save(Usuario usuario) {
//        if (usuario.getLogin() == null)
//            throw new BusinessException("O Campo Login é Obrigatório");
//        if (usuario.getPassword() == null)
//            throw new BusinessException("O Campo Password é Obrigatório");
//
        if (usuario.getLogin() == null) throw new CampoObrigatorioException("Login");
        if (usuario.getPassword() == null) throw new CampoObrigatorioException("Password");

        if (usuario.getId() == null) {
            System.out.println("SAVE - Recebendo o usu´áio rna camada de repositório");
        }else {
            System.out.println("UPDATE - Recebendo o usuário na camada de repositório");
        }
        System.out.println(usuario);
    }

    public void deleteById(Integer id) {
        System.out.println(String.format("DELETE/id - Recebendo o id: %d pada excluir um usuário", id));
        System.out.println(id);
    }

    public List<Usuario> findAll() {
        System.out.println("LIST - Listando os usuarios do Sistema");
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("gleyson","password"));
        usuarios.add(new Usuario("wandberg","123456789"));
        usuarios.add(new Usuario("usuarioroot","987654321"));
        return usuarios;
    }

    public Usuario findById(Integer id) {
        System.out.println(String.format("FIND/id - Recebendo o id: %d pada Localizar um usuário", id));
        return new Usuario("gleyson","password");
    }

    public Usuario findByUserName(String login) {
        System.out.println(String.format("FIND/username - Recebendo o username: %s pada Localizar um usuário", login));
        return new Usuario("wandberg","123456789");
    }




}
