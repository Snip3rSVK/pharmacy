package App;

import App.Db.*;
import Services.LoginService;
import Services.OrderService;
import Services.SceneService;
import Services.UserManagementService;

public class DependencyInjectionContainer {
    private DependencyInjectionContainer() {}

    public static final DrugsDatabase drugsDatabase = new DrugsDatabase();
    public static final DrugsInformationDatabase drugsInformationDatabase = new DrugsInformationDatabase(drugsDatabase);
    public static final UsersDatabase usersDatabase = new UsersDatabase();
    public static final OrdersDatabase ordersDatabase = new OrdersDatabase();
    public static final WarehouseDatabase warehouseDatabase = new WarehouseDatabase();

    public static final SceneService sceneService = new SceneService();
    public static final LoginService loginService = new LoginService(usersDatabase);
    public static final UserManagementService userManagementService = new UserManagementService(loginService, usersDatabase);
    public static final OrderService orderService = new OrderService(ordersDatabase, warehouseDatabase);

}
