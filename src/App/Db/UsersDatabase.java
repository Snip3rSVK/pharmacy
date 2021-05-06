package App.Db;


import App.User.ManagerUser;
import App.User.PharmacistUser;
import App.User.User;
import Services.SceneService;

import java.util.HashSet;
import java.util.Set;

public class UsersDatabase extends AbstractDatabase<User> {

    private Set<User> allUsers = new HashSet<>();

    public UsersDatabase(SceneService sceneService) {
        allUsers.add(new ManagerUser("Matej", "Pavlík", "snip3rsvk@gmail.com", "+421948611676", "1234", sceneService));
        allUsers.add(new PharmacistUser("Janko", "Hraško", "hrasko@gmail.com", "+421777777777", "1234", sceneService));
    }

    public Set<User> getAll() {
        return this.allUsers;
    }

}
