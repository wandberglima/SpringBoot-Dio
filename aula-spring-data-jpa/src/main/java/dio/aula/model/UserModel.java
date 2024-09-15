package dio.aula.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tab_user")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer code;

    @Column(length = 50, nullable = false)
    private String username;

    @Column(length = 10, nullable = false)
    private String password;

    @Column(length = 100, nullable = false)
    private LocalDate birthday;

    @Column(length = 100, nullable = false)
    private String email;

}
