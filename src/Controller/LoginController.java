package Controller;

import App.Validation.LoginError;
import Model.LoginModel;
import Services.LoginService;
import Services.SceneService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController {
    private LoginModel m;

    private LoginService loginService;
    private SceneService sceneService;
    //private Main main;

    public LoginController(LoginService loginService, SceneService sceneService) {
        this.loginService = loginService;
        this.sceneService = sceneService;
    }

    public void initialize() {
        this.m = new LoginModel(this.loginService);
    }

    @FXML TextField email;
    @FXML PasswordField password;

    @FXML Text errorMessage;

    public void login(ActionEvent event) {
        errorMessage.setText("");

        try {
            this.m.login(email.getText(), password.getText());

            // Login successfull
            this.sceneService.switchScene("admin");
        }
        catch (LoginError error) {
            errorMessage.setText(error.getMessage());
        }
    }
}
