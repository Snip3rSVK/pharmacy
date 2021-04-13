package Controller;

import App.User.ManagerUser;
import App.User.PharmacistUser;
import Model.AdminModel;
import Services.LoginService;
import Services.SceneService;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

import java.io.IOException;

public class AdminController {
    private AdminModel m;

    private LoginService loginService;
    private SceneService sceneService;
    //private Main main;

    public AdminController(LoginService loginService, SceneService sceneService) {
        this.loginService = loginService;
        this.sceneService = sceneService;
    }

    public void initialize() {
        this.m = new AdminModel(this.loginService);

        this.afterInitialize();
    }

    @FXML Text welcomeMessage;

    private void afterInitialize() {
        String type = null;

        if (this.m.getUser() instanceof ManagerUser) {
            type = "MANAŽÉR";
        }
        else if (this.m.getUser() instanceof PharmacistUser) {
            type = "LEKÁRNIK";
        }

        welcomeMessage.setText(this.m.getUser().getEmail() + " - " + type);
    }

    public void logout() throws IOException {
        this.m.logout();

        this.sceneService.switchScene("login");
    }

}
