package be.technobel.ucm.springboot.models.views;

import be.technobel.ucm.springboot.models.entities.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString(of = {"username"})
public class HomeIndexView {
    private String username;
    private List<User> users;

    public HomeIndexView(String username, List<User> users) {
        this.username = username;
        this.users = users;
    }
}
