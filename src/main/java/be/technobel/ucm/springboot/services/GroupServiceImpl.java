package be.technobel.ucm.springboot.services;

import be.technobel.ucm.springboot.models.entities.Group;
import be.technobel.ucm.springboot.models.entities.Role;
import be.technobel.ucm.springboot.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class GroupServiceImpl implements GroupService {
    private GroupRepository repository;

    @Autowired
    public GroupServiceImpl(GroupRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Group> findAll() {
        return (List<Group>) this.repository.findAll();
    }

    @Override
    public Set<Group> findByRoleContaining(Role role) {
        return this.repository.findByRolesContaining(role);
    }

    @Override
    public Group findByLabel(String label) {
        return this.repository.findByLabel(label);
    }

    @Override
    public Group create(Group newGroup) {
        return this.repository.save(newGroup);
    }

    @Override
    public Group update(Group updateGroup) {
        return this.repository.save(updateGroup);
    }

    @Override
    public void remove(long id) {
        this.repository.deleteById(id);
    }

    @Override
    public Group findById(long id) {
        return this.repository.findById(id).orElse(null);
    }
}
