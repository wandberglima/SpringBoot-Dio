package dio.dio.spring.security.jwt.security;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Data
public class JWTObject {

    private String subject; //nome do Usuário
    private Date issuedAt; // data da criacao
    private Date expiration; // data de expiracao
    private List<String> roles; // perfis de acesso

//    public void setRoles(String... roles) {
//        this.roles = Arrays.asList(roles);
//    }

}
