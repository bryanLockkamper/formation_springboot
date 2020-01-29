package be.technobel.ucm.springboot.repositories;

import be.technobel.ucm.springboot.models.entities.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByLabel(String label);
}
