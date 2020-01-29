package be.technobel.ucm.springboot.services;

import be.technobel.ucm.springboot.models.entities.Group;
import be.technobel.ucm.springboot.models.entities.Role;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface GroupService {
    List<Group> findAll();
    Set<Group> findByRoleContaining(Role role);
    Group findByLabel(String label);
    Group create(Group newGroup);
    Group update(Group updateGroup);
    void remove(long id);
    Group findById(long id);
}
