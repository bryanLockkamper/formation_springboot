package be.technobel.ucm.springboot.services;

import be.technobel.ucm.springboot.models.entities.User;
import be.technobel.ucm.springboot.models.entities.UserType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User findByUsername(String username);
    User findByUsername(char[] username);
    User save(User user);
    User save(String username, String password, UserType... userType);

    List<User> findByUserTypeListContaining(UserType type);
}
