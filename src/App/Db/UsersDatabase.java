package App.Db;


import App.User.ManagerUser;
import App.User.PharmacistUser;
import App.User.User;

import java.util.HashSet;
import java.util.Set;

public class UsersDatabase {

    private Set<User> allUsers = new HashSet<>();

    public UsersDatabase() {
        allUsers.add(new ManagerUser("Matej", "Pavlík", "snip3rsvk@gmail.com", "+421948611676", "1234"));
        allUsers.add(new PharmacistUser("Janko", "Hraško", "hrasko@gmail.com", "+421777777777", "1234"));
    }

    public Set<User> getAllUsers() {
        return this.allUsers;
    }

}
