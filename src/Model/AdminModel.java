package Model;

import App.User.User;
import Services.LoginService;

public class AdminModel {
    private LoginService loginService;
    private User currentUser;

    public AdminModel(LoginService loginService) {
        this.loginService = loginService;

        this.currentUser = this.loginService.getCurrentUser();
    }

    public User getUser() {
        return this.currentUser;
    }

    public void logout() {
        this.loginService.logout();
    }
}
