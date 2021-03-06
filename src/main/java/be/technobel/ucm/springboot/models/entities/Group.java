package be.technobel.ucm.springboot.models.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "technobel_group")
@Getter
@Setter
@EqualsAndHashCode(of = {"id", "label"})
@ToString(of = {"id", "label"})
public class Group implements Serializable {
    @Id
    @Column(name = "group_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String label;

    @ManyToMany(targetEntity = Role.class)
    private Set<Role> roles;

    public Group() {
        this.roles = new HashSet<Role>();
    }
    public Group(long id, String label) {
        this();
        this.id = id;
        this.label = label;
    }
    public Group(String label) {
        this();
        this.label = label;
    }
}
