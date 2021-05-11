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

        DrugsDatabase drugsDatabase = DependencyInjectionContainer.drugsDatabase;
        DrugsInformationDatabase drugsInformationDatabase = DependencyInjectionContainer.drugsInformationDatabase;
        UsersDatabase usersDatabase = DependencyInjectionContainer.usersDatabase;
        OrdersDatabase ordersDatabase = DependencyInjectionContainer.ordersDatabase;
        WarehouseDatabase warehouseDatabase = DependencyInjectionContainer.warehouseDatabase;
        SceneService sceneService = DependencyInjectionContainer.sceneService;
        LoginService loginService = DependencyInjectionContainer.loginService;
        UserManagementService userManagementService = DependencyInjectionContainer.userManagementService;
        OrderService orderService = DependencyInjectionContainer.orderService;

        FXMLLoader loginLoader = FXMLLoaderCreator.create(
            ViewEnum.LOGIN,
            // Inject loginService, sceneService into LoginModel
            new LoginModel(loginService, sceneService),
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

        FXMLLoader adminBuyMedicineLoader = FXMLLoaderCreator.create(
            ViewEnum.ADMIN_BUY_MEDICINE,
            new AdminBuyMedicineModel(loginService, orderService),
            new AdminBuyMedicineController(sceneService, drugsDatabase)
        );

        FXMLLoader adminWarehouseLoader = FXMLLoaderCreator.create(
            ViewEnum.ADMIN_WAREHOUSE,
            new AdminWarehouseModel(loginService, warehouseDatabase),
            new AdminWarehouseController(sceneService)
        );

        FXMLLoader adminEmployeesLoader = FXMLLoaderCreator.create(
            ViewEnum.ADMIN_EMPLOYEES,
            new AdminEmployeesModel(loginService),
            new AdminEmployeesController(sceneService, usersDatabase, userManagementService)
        );

        FXMLLoader adminDrugsInformationLoader = FXMLLoaderCreator.create(
            ViewEnum.ADMIN_DRUGS_INFORMATION,
            new AdminDrugsInformationModel(loginService),
            new AdminDrugsInformationController(sceneService, drugsInformationDatabase)
        );

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
