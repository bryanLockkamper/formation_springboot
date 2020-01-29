package be.technobel.ucm.springboot.controllers;

import be.technobel.ucm.springboot.models.entities.User;
import be.technobel.ucm.springboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = {"/user"})
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = {"/", "/list"})
    public String listAction(Map<String, Object> model) {
        List<User> users = this.userService.findAll();

        model.put("users", users);
        return "user/list";
    }

    @GetMapping(value = {"/:id"})
    public String showAction(Map<String, User> model, @PathVariable long id) {
        User user = this.userService.findById(id);
        return "user/show";
    }
}
