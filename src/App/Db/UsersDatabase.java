package App.Db;


import App.User.ManagerUser;
import App.User.PharmacistUser;
import App.User.User;
import Services.SceneService;

import java.util.HashSet;
import java.util.Set;

public class UsersDatabase extends AbstractDatabase<User> {

    private Set<User> allUsers = new HashSet<>();

    public UsersDatabase() {
        allUsers.add(new ManagerUser("Matej", "Pavlík", "snip3rsvk@gmail.com", "1234"));
        allUsers.add(new PharmacistUser("Janko", "Hraško", "hrasko@gmail.com", "1234"));
    }

    public Set<User> getAll() {
        return this.allUsers;
    }

    public void add(User user) {
        this.allUsers.add(user);
    }

    public void remove(User user) {
        this.allUsers.remove(user);
    }

}
