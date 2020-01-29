package be.technobel.ucm.springboot.controllers;

import be.technobel.ucm.springboot.models.views.HomeIndexView;
import be.technobel.ucm.springboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class HomeController {
    private UserService userService;
    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping({"/", "/index"})
    public String indexAction(Map<String, HomeIndexView> model) {
        return "home/index";
    }
}
