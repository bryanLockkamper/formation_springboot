package be.technobel.ucm.springboot.services;

import be.technobel.ucm.springboot.models.entities.User;
import be.technobel.ucm.springboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User findByUsername(String username) {
        return this.repository.findByUsername(username);
    }

    @Override
    public User findByUsername(char[] username) {
        return this.repository.findByUsername(Arrays.toString(username));
    }

    @Override
    public User save(User user) {
        return this.repository.save(user);
    }

    @Override
    public User save(String username, String password) {
        return null;
    }

    @Override
    public User findById(long id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public List<User> findAll() {
        return (List<User>) this.repository.findAll();
    }
}
