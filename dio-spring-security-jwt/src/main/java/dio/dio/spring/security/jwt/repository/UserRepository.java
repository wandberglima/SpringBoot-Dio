package dio.dio.spring.security.jwt.repository;

import dio.dio.spring.security.jwt.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT e from User e join fetch e.roles where e.username=(:username)")
    User findByUsername(@Param("username")String username);

    boolean existsByUsername(String username);

}
