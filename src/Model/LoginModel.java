package Model;

import Services.LoginService;
import Services.SceneService;

public class LoginModel implements Model {
    private LoginService loginService;
    private SceneService sceneService;

    public LoginModel(LoginService loginService, SceneService sceneService) {
        this.loginService = loginService;
        this.sceneService = sceneService;
    }

    public void login(String email, String password) {
        this.loginService.login(email, password);

        // TODO check for null
        this.sceneService.switchScene(this.loginService.getCurrentUser().adminViewEnum());
    }
}
