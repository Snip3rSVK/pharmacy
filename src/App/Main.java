package App;

import App.Db.DrugsDatabase;
import App.Db.UsersDatabase;
import App.Router.RouterEnum;
import Controller.Admin.AdminManagerController;
import Controller.Admin.AdminPharmacistController;
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

        SceneService sceneService = new SceneService(primaryStage);

        UsersDatabase usersDatabase = new UsersDatabase(sceneService);
        DrugsDatabase drugsDatabase = new DrugsDatabase();

        // TODO THIS DOESNT LOOK GOOD (maybe some extends?)
        LoginService loginService = new LoginService(usersDatabase);

        FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("../View/Login.fxml"));
        // inject loginService and sceneService into LoginController
        LoginController loginController = new LoginController(loginService, sceneService);
        loginLoader.setControllerFactory((Class<?> type) -> loginController);

        FXMLLoader adminManagerLoader = new FXMLLoader(getClass().getResource("../View/Admin/AdminManager.fxml"));
        AdminManagerController adminManagerController = new AdminManagerController(loginService, sceneService);
        adminManagerLoader.setControllerFactory((Class<?> type) -> adminManagerController);

        FXMLLoader adminPharmacistLoader = new FXMLLoader(getClass().getResource("../View/Admin/AdminPharmacist.fxml"));
        AdminPharmacistController adminPharmacistController = new AdminPharmacistController(loginService, sceneService);
        adminPharmacistLoader.setControllerFactory((Class<?> type) -> adminPharmacistController);

        sceneService.add(RouterEnum.LOGIN, loginLoader);
        sceneService.add(RouterEnum.ADMIN.MANAGER, adminManagerLoader);
        sceneService.add(RouterEnum.ADMIN.PHARMACIST, adminPharmacistLoader);
        sceneService.switchScene(RouterEnum.LOGIN);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
