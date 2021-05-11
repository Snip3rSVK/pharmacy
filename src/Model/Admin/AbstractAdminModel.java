package Model.Admin;

import App.User.User;
import App.ViewEnum.ViewEnum;
import Model.Model;
import Services.LoginService;
import Services.SceneService;

public abstract class AbstractAdminModel implements Model {
    private LoginService loginService;

    public AbstractAdminModel(LoginService loginService) {
        this.loginService = loginService;
    }

    private User getUser() {
        return this.loginService.getCurrentUser();
    }

    // TODO check for null here
    public String getUserEmail() {
        return this.getUser().getEmail();
    }

    public void logout() {
        this.loginService.logout();
    }
}
