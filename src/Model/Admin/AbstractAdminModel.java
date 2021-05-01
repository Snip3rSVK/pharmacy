package Model.Admin;

import App.User.User;
import Model.Model;
import Services.LoginService;

public abstract class AbstractAdminModel implements Model {
    private LoginService loginService;

    private User currentUser;

    public AbstractAdminModel(LoginService loginService) {
        this.loginService = loginService;

        this.currentUser = this.loginService.getCurrentUser();
    }

    private User getUser() {
        return this.currentUser;
    }

    // TODO check for null here
    public String getUserEmail() {
        return this.getUser().getEmail();
    }

    public void logout() {
        this.loginService.logout();
    }
}
