package App;

import App.Db.UsersDatabase;
import Controller.AdminController;
import Controller.LoginController;
import Services.LoginService;
import Services.SceneService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        SceneService sceneService = new SceneService(primaryStage);
        LoginService loginService = new LoginService(new UsersDatabase());

        FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("../View/Login.fxml"));
        // inject loginService and sceneService into LoginController
        LoginController loginController = new LoginController(loginService, sceneService);
        loginLoader.setControllerFactory((Class<?> type) -> loginController);

        FXMLLoader adminLoader = new FXMLLoader(getClass().getResource("../View/Admin.fxml"));
        AdminController adminController = new AdminController(loginService, sceneService);
        adminLoader.setControllerFactory((Class<?> type) -> adminController);


        primaryStage.setTitle("Lekáreň");

        // TODO maybe enums here
        sceneService.add("admin", adminLoader);
        sceneService.add("login", loginLoader);
        sceneService.switchScene("login");
    }


    public static void main(String[] args) {
        launch(args);
    }
}
