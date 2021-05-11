package App;

import App.Db.*;
import App.ViewEnum.ViewEnum;
import Controller.Admin.*;
import Controller.LoginController;
import Model.Admin.*;
import Model.LoginModel;
import Services.LoginService;
import Services.OrderService;
import Services.SceneService;
import Services.UserManagementService;
import Util.FXMLLoaderCreator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Lekáreň");

        primaryStage.setScene(DependencyInjectionContainer.sceneService.getScene());
        primaryStage.show();

        FXMLLoader loginLoader = FXMLLoaderCreator.create(
            ViewEnum.LOGIN,
            // Inject loginService, sceneService into LoginModel
            new LoginModel(
                DependencyInjectionContainer.loginService,
                DependencyInjectionContainer.sceneService
            ),
            new LoginController()
        );

        FXMLLoader adminManagerLoader = FXMLLoaderCreator.create(
            ViewEnum.ADMIN_MANAGER,
            new AdminManagerModel(DependencyInjectionContainer.loginService),
            new AdminManagerController(DependencyInjectionContainer.sceneService)
        );

        FXMLLoader adminPharmacistLoader = FXMLLoaderCreator.create(
            ViewEnum.ADMIN_PHARMACIST,
            new AdminPharmacistModel(DependencyInjectionContainer.loginService),
            new AdminPharmacistController(DependencyInjectionContainer.sceneService)
        );

        FXMLLoader adminBuyMedicineLoader = FXMLLoaderCreator.create(
            ViewEnum.ADMIN_BUY_MEDICINE,
            new AdminBuyMedicineModel(
                DependencyInjectionContainer.loginService,
                DependencyInjectionContainer.orderService
            ),
            new AdminBuyMedicineController(
                DependencyInjectionContainer.sceneService,
                DependencyInjectionContainer.drugsDatabase
            )
        );

        FXMLLoader adminWarehouseLoader = FXMLLoaderCreator.create(
            ViewEnum.ADMIN_WAREHOUSE,
            new AdminWarehouseModel(DependencyInjectionContainer.loginService, DependencyInjectionContainer.warehouseDatabase),
            new AdminWarehouseController(DependencyInjectionContainer.sceneService)
        );

        FXMLLoader adminEmployeesLoader = FXMLLoaderCreator.create(
            ViewEnum.ADMIN_EMPLOYEES,
            new AdminEmployeesModel(DependencyInjectionContainer.loginService),
            new AdminEmployeesController(DependencyInjectionContainer.sceneService, DependencyInjectionContainer.usersDatabase, DependencyInjectionContainer.userManagementService)
        );

        FXMLLoader adminDrugsInformationLoader = FXMLLoaderCreator.create(
            ViewEnum.ADMIN_DRUGS_INFORMATION,
            new AdminDrugsInformationModel(DependencyInjectionContainer.loginService),
            new AdminDrugsInformationController(DependencyInjectionContainer.sceneService, DependencyInjectionContainer.drugsInformationDatabase)
        );


        SceneService sceneService = DependencyInjectionContainer.sceneService;
        sceneService.add(ViewEnum.LOGIN, loginLoader);
        sceneService.add(ViewEnum.ADMIN_MANAGER, adminManagerLoader);
        sceneService.add(ViewEnum.ADMIN_PHARMACIST, adminPharmacistLoader);
        sceneService.add(ViewEnum.ADMIN_BUY_MEDICINE, adminBuyMedicineLoader);
        sceneService.add(ViewEnum.ADMIN_WAREHOUSE, adminWarehouseLoader);
        sceneService.add(ViewEnum.ADMIN_EMPLOYEES, adminEmployeesLoader);
        sceneService.add(ViewEnum.ADMIN_DRUGS_INFORMATION, adminDrugsInformationLoader);
        sceneService.switchScene(ViewEnum.LOGIN);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
