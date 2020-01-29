package be.technobel.ucm.springboot.repositories;

import be.technobel.ucm.springboot.models.entities.Group;
import be.technobel.ucm.springboot.models.entities.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface GroupRepository extends CrudRepository<Group, Long> {
    Group findByLabel(String label);
    Set<Group> findByRolesContaining(Role role);
}
