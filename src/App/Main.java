package App;

import App.Db.DrugsDatabase;
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
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Lekáreň");

        UsersDatabase usersDatabase = new UsersDatabase();
        DrugsDatabase drugsDatabase = new DrugsDatabase();

        SceneService sceneService = new SceneService(primaryStage);
        LoginService loginService = new LoginService(usersDatabase);

        FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("../View/Login.fxml"));
        // inject loginService and sceneService into LoginController
        LoginController loginController = new LoginController(loginService, sceneService);
        loginLoader.setControllerFactory((Class<?> type) -> loginController);

        FXMLLoader adminLoader = new FXMLLoader(getClass().getResource("../View/Admin.fxml"));
        AdminController adminController = new AdminController(loginService, sceneService);
        adminLoader.setControllerFactory((Class<?> type) -> adminController);

        // TODO maybe enums here
        sceneService.add("login", loginLoader);
        sceneService.add("admin", adminLoader);
        sceneService.switchScene("login");
    }


    public static void main(String[] args) {
        launch(args);
    }
}
