package App;

import App.Db.DrugsDatabase;
import App.Db.OrdersDatabase;
import App.Db.UsersDatabase;
import App.Db.WarehouseDatabase;
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

        // Initialization of services, databases
        DrugsDatabase drugsDatabase = new DrugsDatabase();
        UsersDatabase usersDatabase = new UsersDatabase();
        OrdersDatabase ordersDatabase = new OrdersDatabase();
        WarehouseDatabase warehouseDatabase = new WarehouseDatabase();
        
        SceneService sceneService = new SceneService(primaryStage);
        LoginService loginService = new LoginService(usersDatabase);
        UserManagementService userManagementService = new UserManagementService(loginService, usersDatabase);
        OrderService orderService = new OrderService(ordersDatabase, warehouseDatabase);

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

        // TODO Maybe incorporate loaders directly into ViewEnums?
        // TODO maybe some initialize method that will loop over all ViewEnums or some Loader wrapper class?
        sceneService.add(ViewEnum.LOGIN, loginLoader);
        sceneService.add(ViewEnum.ADMIN_MANAGER, adminManagerLoader);
        sceneService.add(ViewEnum.ADMIN_PHARMACIST, adminPharmacistLoader);
        sceneService.add(ViewEnum.ADMIN_BUY_MEDICINE, adminBuyMedicineLoader);
        sceneService.add(ViewEnum.ADMIN_WAREHOUSE, adminWarehouseLoader);
        sceneService.add(ViewEnum.ADMIN_EMPLOYEES, adminEmployeesLoader);
        sceneService.switchScene(ViewEnum.LOGIN);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
