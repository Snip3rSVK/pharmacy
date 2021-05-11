package Services;

import App.Db.UsersDatabase;
import App.User.ManagerUser;
import App.User.PharmacistUser;
import App.User.User;
import App.User.UserEnum;
import App.Validation.UserManagementError;
import App.Validation.UserManagementErrorEnum;

public class UserManagementService extends Service {

    private static final Integer MIN_PASSWORD_LENGTH = 8;

    private LoginService loginService;
    private UsersDatabase usersDatabase;

    public UserManagementService(LoginService loginService, UsersDatabase usersDatabase) {
        this.loginService = loginService;
        this.usersDatabase = usersDatabase;
    }

    public User add(String firstName, String lastName, String email, String password, UserEnum type) throws UserManagementError {
        User newUser;

        // TODO maybe something like userEnum.getUserClass?
        if (type == UserEnum.MANAGER) {
            newUser = new ManagerUser(firstName, lastName, email, password);
        }
        else if (type == UserEnum.PHARMACIST) {
            newUser = new PharmacistUser(firstName, lastName, email, password);
        }
        else {
            throw new UserManagementError(UserManagementErrorEnum.USER_TYPE_NOT_SPECIFIED);
        }

        this.validateAll(firstName, lastName, email, password);

        this.usersDatabase.add(newUser);

        return newUser;
    }

    public void edit(User user, String firstName, String lastName, String email, String password) throws UserManagementError {
        this.validateAll(firstName, lastName, email, password);

        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
    }

    public void remove(User user) throws UserManagementError {
        if (user == this.loginService.getCurrentUser()) {
            throw new UserManagementError(UserManagementErrorEnum.CANNOT_REMOVE_CURRENT_USER);
        }

        this.usersDatabase.remove(user);
    }

    public void validateAll(String firstName, String lastName, String email, String password) throws UserManagementError {
        // TODO maybe copy costructors in User?
        this.validateFirstName(firstName);
        this.validateLastName(lastName);
        this.validateEmail(email);
        this.validatePassword(password);
    }

    public void validateFirstName(String firstName) {
        if (firstName.length() == 0) {
            throw new UserManagementError(UserManagementErrorEnum.FIRST_NAME_EMPTY);
        }
    }

    public void validateLastName(String lastName) {
        if (lastName.length() == 0) {
            throw new UserManagementError(UserManagementErrorEnum.LAST_NAME_EMPTY);
        }
    }

    public void validateEmail(String email) {
        if (!email.matches("^.+@.+\\..+$")) {
            throw new UserManagementError(UserManagementErrorEnum.INVALID_EMAIL);
        }

        for (User user : this.usersDatabase.getAll()) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                throw new UserManagementError(UserManagementErrorEnum.EMAIL_ALREADY_EXISTS);
            }
        }
    }

    public void validatePassword(String password) {
        if (password.length() < MIN_PASSWORD_LENGTH) {
            throw new UserManagementError(UserManagementErrorEnum.SHORT_PASSWORD_LENGTH);
        }

        if (!password.matches(".*[a-zA-Z]+.*")) {
            throw new UserManagementError(UserManagementErrorEnum.PASSWORD_DOESNT_CONTAIN_ALPHABET);
        }

        if (!password.matches(".*[0-9]+.*")) {
            throw new UserManagementError(UserManagementErrorEnum.PASSWORD_DOESNT_CONTAIN_NUMBERS);
        }
    }

}
