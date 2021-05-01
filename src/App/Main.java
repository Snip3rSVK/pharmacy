package App;

import App.Db.DrugsDatabase;
import App.Db.UsersDatabase;
import App.ViewEnum.ViewEnum;
import Controller.Admin.AdminManagerController;
import Controller.Admin.AdminPharmacistController;
import Controller.LoginController;
import Model.Admin.AdminManagerModel;
import Model.Admin.AdminPharmacistModel;
import Model.LoginModel;
import Services.LoginService;
import Services.SceneService;
import Util.FXMLLoaderCreator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Lekáreň");

        // Initialization of services, databases
        DrugsDatabase drugsDatabase = new DrugsDatabase();
        SceneService sceneService = new SceneService(primaryStage);
        UsersDatabase usersDatabase = new UsersDatabase(sceneService);
        LoginService loginService = new LoginService(usersDatabase);

        FXMLLoader loginLoader = FXMLLoaderCreator.create(
            ViewEnum.LOGIN,
            // Inject loginService into LoginModel
            new LoginModel(loginService),
            new LoginController()
        );

        FXMLLoader adminManagerLoader = FXMLLoaderCreator.create(
            ViewEnum.ADMIN_MANAGER,
            new AdminManagerModel(loginService),
            new AdminManagerController(sceneService)
        );

        FXMLLoader adminPharmacistLoader = FXMLLoaderCreator.create(
            ViewEnum.ADMIN_PHARMACIST,
            new AdminPharmacistModel(loginService),
            new AdminPharmacistController(sceneService)
        );

        // TODO Maybe incorporate loaders directly into ViewEnums?
        sceneService.add(ViewEnum.LOGIN, loginLoader);
        sceneService.add(ViewEnum.ADMIN_MANAGER, adminManagerLoader);
        sceneService.add(ViewEnum.ADMIN_PHARMACIST, adminPharmacistLoader);
        sceneService.switchScene(ViewEnum.LOGIN);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
