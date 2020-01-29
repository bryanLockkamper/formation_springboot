package be.technobel.ucm.springboot.models.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "technobel_UserRole")
@Getter
@Setter
@ToString(of = {"user", "role", "startDate", "endDate"})
public class UserRole implements Serializable {
    @Id
    @ManyToOne(targetEntity = User.class)
    private User user;
    @Id
    @ManyToOne(targetEntity = Role.class)
    private Role role;

    @Column
    private LocalDate startDate;
    @Column
    private LocalDate endDate;
}
