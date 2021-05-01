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

public class LoginController extends Controller<LoginModel> {
    public LoginController() {
    }

    @FXML TextField email;
    @FXML PasswordField password;

    @FXML Text errorMessage;

    public void login(ActionEvent event) {
        errorMessage.setText("");

        try {
            this.m.login(email.getText(), password.getText());
        }
        catch (LoginError error) {
            errorMessage.setText(error.getMessage());
        }
    }
}
