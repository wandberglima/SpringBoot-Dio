package dio.aula.repository;

import dio.aula.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {

    // Query Method
    List<UserModel> findByUsernameContains(String username);

    // Query Method
    UserModel findByUsername (String username);

    // Query Override
    @Query("SELECT U FROM UserModel U WHERE U.username LIKE %:name%")
    List<UserModel> filtrarPorNome(@Param("name") String name);

}
