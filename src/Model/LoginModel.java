package Model;

import Services.LoginService;

public class LoginModel implements Model {
    private LoginService loginService;

    public LoginModel(LoginService loginService) {
        this.loginService = loginService;
    }

    public void login(String email, String password) {
        this.loginService.login(email, password);
        // TODO check for null
        this.loginService.getCurrentUser().login();
    }
}
