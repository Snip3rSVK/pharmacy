package Model;

import App.User.ManagerUser;
import App.User.PharmacistUser;
import App.User.User;
import Services.LoginService;

public class AdminModel {
    private LoginService loginService;
    private User currentUser;

    public AdminModel(LoginService loginService) {
        this.loginService = loginService;

        this.currentUser = this.loginService.getCurrentUser();
    }

    // TODO check for null here
    private User getUser() {
        return this.currentUser;
    }

    public boolean isUserManager() {
        return this.getUser() instanceof ManagerUser;
    }

    public boolean isUserPharmacist() {
        return this.getUser() instanceof PharmacistUser;
    }

    public String getUserEmail() {
        return this.getUser().getEmail();
    }

    public void logout() {
        this.loginService.logout();
    }
}
