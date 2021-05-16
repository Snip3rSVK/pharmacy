package App.Db;

import App.User.User;

import java.util.HashSet;
import java.util.Set;

public class UsersDatabase implements Database<User> {

    private Set<User> allUsers = new HashSet<>();

    public UsersDatabase() {
        this.deserializeAll();
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

    public void addDeserialized(User user) {
        this.add(user);
    }

}
