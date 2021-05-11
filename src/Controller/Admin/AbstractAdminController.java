package Controller.Admin;

import App.ViewEnum.ViewEnum;
import Controller.Controller;
import Model.Admin.AbstractAdminModel;
import Services.LoginService;
import Services.SceneService;

public abstract class AbstractAdminController<T extends AbstractAdminModel> extends Controller<T> {
    protected final SceneService sceneService;
    protected final LoginService loginService;

    public AbstractAdminController(SceneService sceneService, LoginService loginService) {
        this.sceneService = sceneService;
        this.loginService = loginService;
    }

    public void logout() {
        this.m.logout();

        this.sceneService.switchScene(ViewEnum.LOGIN);
    }

    public void goToBuyMedicine() {
        this.sceneService.switchScene(ViewEnum.ADMIN_BUY_MEDICINE);
    }

    public void goToWarehouse() {
        this.sceneService.switchScene(ViewEnum.ADMIN_WAREHOUSE);
    }

    public void goToEmployees() {
        this.sceneService.switchScene(ViewEnum.ADMIN_EMPLOYEES);
    }

    public void goToDrugsInformations() {
        this.sceneService.switchScene(ViewEnum.ADMIN_DRUGS_INFORMATION);
    }

    public void goToMainAdminPage() {
        this.loginService.getCurrentUser().login();
    }

}
