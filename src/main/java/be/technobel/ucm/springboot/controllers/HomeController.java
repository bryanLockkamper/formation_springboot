package be.technobel.ucm.springboot.controllers;

import be.technobel.ucm.springboot.models.entities.User;
import be.technobel.ucm.springboot.models.entities.UserType;
import be.technobel.ucm.springboot.models.views.HomeIndexView;
import be.technobel.ucm.springboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
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
        User u = new User();
        u.getUserTypeList().add(UserType.USER);
        u.getUserTypeList().add(UserType.MODO);
        u.setUsername("Flavian");
        u.setPassword("Blop");

        this.userService.save(u);

        List<User> userList = this.userService.findByUserTypeListContaining(UserType.USER);

        model.put("view", new HomeIndexView("Flavian", userList));

        return "home/index";
    }
}
