package Controller.Admin;

import Model.Admin.AdminManagerModel;
import Services.LoginService;
import Services.SceneService;

public class AdminPharmacistController extends AbstractAdminController {
    private AdminManagerModel m;

    public AdminPharmacistController(LoginService loginService, SceneService sceneService) {
        super(loginService, sceneService);
    }

    public void initialize() {
        this.m = new AdminManagerModel(this.loginService);

        this.afterInitialization();
    }


    private void afterInitialization() {

    }
}
