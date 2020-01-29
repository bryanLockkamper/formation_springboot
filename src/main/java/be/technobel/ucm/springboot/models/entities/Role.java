package be.technobel.ucm.springboot.models.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "technobel_role")
@Getter
@Setter
@ToString(of = {"id","label"})
@EqualsAndHashCode(of = {"id", "label"})
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private long id;

    @Column(name = "label", nullable = false)
    private String label;
}
