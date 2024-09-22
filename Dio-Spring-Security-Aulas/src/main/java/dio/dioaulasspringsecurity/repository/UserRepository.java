package dio.dioaulasspringsecurity.repository;

import dio.dioaulasspringsecurity.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT e FROM User e JOIN FETCH e.roles where e.username=(:username)")
    User findByUsername(@Param("username") String username);

}
