package Model;

import Services.LoginService;

public class LoginModel {
    private LoginService loginService;

    public LoginModel(LoginService loginService) {
        this.loginService = loginService;
    }

    public void login(String email, String password) {
        this.loginService.login(email, password);
    }
}
