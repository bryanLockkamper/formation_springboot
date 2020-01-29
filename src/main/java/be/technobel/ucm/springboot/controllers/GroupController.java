package be.technobel.ucm.springboot.controllers;

import be.technobel.ucm.springboot.models.entities.Group;
import be.technobel.ucm.springboot.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = {"/group"})
public class GroupController {
    private GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping(value = {"/", "/list"})
    public String listAction(Map<String, List<Group>> model) {

        List<Group> groupSet = this.groupService.findAll();

        model.put("groups", groupSet);
        return "group/list";
    }

    @GetMapping(value = {"/show/{id}"})
    public String showAction(Map<String, Group> model, @PathVariable(name = "id") long id) {
        Group group = this.groupService.findById(id);

        model.put("group", group);
        return "group/show";
    }

    @GetMapping(value = {"/create"})
    public String createAction(Map<String, Group> model) {
        return "group/create";
    }

    @PostMapping(value = {"/create"})
    public String createAction(Map<String, Group> model, Group group) {
        group = this.groupService.create(group);

        model.put("group", group);
        return "redirect:/group/show/"+ group.getId();
    }
}
