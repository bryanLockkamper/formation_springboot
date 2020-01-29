package be.technobel.ucm.springboot.models.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "technobel_user")
@Getter
@Setter
@EqualsAndHashCode(of= {"username"})
@ToString(of= {"id", "username", "password", "userTypeList"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "user_id")
    private long id;

    @Column(unique = true)
    private String username;
    @Column(length = 50)
    private String password;

    @ManyToMany(targetEntity = Group.class)
    private Set<Group> groups;

    @OneToMany(targetEntity = UserRole.class, mappedBy = "user")
    private Set<UserRole> userRoles;

    public User() {
        this.groups = new HashSet<Group>();
    }

    public Set<Role> getRoles() {
        Set<Role> roles = new HashSet<>();

        this.groups.forEach(group -> roles.addAll(group.getRoles()));
        this.userRoles.forEach(userRole -> roles.add(userRole.getRole()));

        return roles;
    }
}
