package be.technobel.ucm.springboot.models.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass= UserType.class)
    private Set<UserType> userTypeList;

    @ManyToMany(targetEntity = Group.class)
    private Set<Group> groups;

    public User() {
        this.userTypeList = new HashSet<UserType>();
        this.groups = new HashSet<Group>();
    }
}
