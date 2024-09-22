package dio.dio.spring.security.jwt.security;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

public class JWTCreator {

    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String ROLES_AUTHORITIES = "authorities";

    // Método para criar o token JWT
    public static String createJWT(String prefix, String key, JWTObject jwtObject) {
        String token = Jwts.builder()
                .setSubject(jwtObject.getSubject())
                .setIssuedAt(jwtObject.getIssuedAt())
                .setExpiration(jwtObject.getExpiration())
                .claim(ROLES_AUTHORITIES, checkRoles(jwtObject.getRoles())) // Adiciona as roles ao token
                .signWith(SignatureAlgorithm.HS512, key) // Assinatura com a chave secreta
                .compact();
        return prefix + " " + token; // Adiciona o prefixo Bearer
    }

    // Método para criar o JWTObject a partir de um token
    public static JWTObject create(String token, String prefix, String key)
            throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException,
            SignatureException, IllegalArgumentException {

        JWTObject object = new JWTObject();

        // Remove o prefixo Bearer do token
        token = token.replace(prefix, "").trim();

        // Lê as claims do token
        Claims claims = Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(token)
                .getBody();

        // Seta os atributos do JWTObject
        object.setSubject(claims.getSubject());
        object.setExpiration(claims.getExpiration());
        object.setIssuedAt(claims.getIssuedAt());

        // Extrai a lista de roles (autorização)
        List<String> roles = Arrays.asList(claims.get(ROLES_AUTHORITIES).toString().split(","));
        object.setRoles(roles); // Define as roles no JWTObject

        return object;
    }

    // Método para ajustar as roles e garantir que todas tenham o prefixo ROLE_
    private static List<String> checkRoles(List<String> roles) {
        return roles.stream()
                .map(role -> role.startsWith("ROLE_") ? role : "ROLE_" + role)
                .collect(Collectors.toList());
    }
}
