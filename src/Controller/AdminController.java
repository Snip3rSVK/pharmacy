package Controller;

import App.User.ManagerUser;
import App.User.PharmacistUser;
import Model.AdminModel;
import Services.LoginService;
import Services.SceneService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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

        if (this.m.isUserManager()) {
            type = "MANAŽÉR";
        }
        else if (this.m.isUserPharmacist()) {
            type = "LEKÁRNIK";
        }

        welcomeMessage.setText(this.m.getUserEmail() + " - " + type);
    }

    public void logout() {
        this.m.logout();

        this.sceneService.switchScene("login");
    }

}
