package be.technobel.ucm.springboot.repositories;

import be.technobel.ucm.springboot.models.entities.User;
import be.technobel.ucm.springboot.models.entities.UserType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query(value = "SELECT u FROM User u WHERE u.username = :username")
    User findByUsername(@Param("username") String username);

//    @Query(value = "SELECT u FROM User u JOIN u.userTypeList utl WHERE utl = :type")
    List<User> findByUserTypeListContaining(@Param("type") UserType type);
}
