package Services;

import App.Db.UsersDatabase;
import App.User.ManagerUser;
import App.User.User;
import App.Validation.LoginError;
import App.Validation.LoginErrorEnum;
import App.ViewEnum.ViewEnum;
import javafx.scene.SceneAntialiasing;

public class LoginService implements Service {
    private User currentUser = null;

    private UsersDatabase usersDatabase;

    public LoginService(UsersDatabase usersDatabase) {
        this.usersDatabase = usersDatabase;
    }

    public void login(String email, String password) {
        User user = this.getUser(email, password);

        if (user != null) {
            this.currentUser = user;
        }
        else {
            throw new LoginError(LoginErrorEnum.BAD_LOGIN);
        }
    }

    public void logout() {
        this.currentUser = null;
    }

    public User getUser(String email, String password) {
        for (User user : this.usersDatabase.getAll()) {
            if (user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password)) {
                return user;
            }
        }

        return null;
    }

    // Current logged in user
    public User getCurrentUser() {
        return this.currentUser;
    }



}
