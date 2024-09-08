package dio.aula.repository;

import dio.aula.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // Query Method
    List<User> findByNameContaining(String name);

    // Query Method
    User findByUsername (String username);

    // Query Override
    @Query("SELECT U FROM User U WHERE U.name LIKE %:name%")
    List<User> filtrarPorNome(@Param("name") String name);

}
