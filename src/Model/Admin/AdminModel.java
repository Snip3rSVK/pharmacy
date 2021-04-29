package Model.Admin;

import App.User.User;
import Services.LoginService;

public class AdminModel {
    protected final LoginService loginService;

    private User currentUser;

    public AdminModel(LoginService loginService) {
        this.loginService = loginService;

        this.currentUser = this.loginService.getCurrentUser();
    }

    // TODO check for null here
    private User getUser() {
        return this.currentUser;
    }

    public String getUserEmail() {
        return this.getUser().getEmail();
    }

    public void logout() {
        this.loginService.logout();
    }
}
