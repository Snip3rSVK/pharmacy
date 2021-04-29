package Controller.Admin;

import Model.Admin.AdminManagerModel;
import Services.LoginService;
import Services.SceneService;

public class AdminManagerController extends AbstractAdminController {
    private AdminManagerModel m;

    public AdminManagerController(LoginService loginService, SceneService sceneService) {
        super(loginService, sceneService);
    }

    public void initialize() {
        this.m = new AdminManagerModel(this.loginService);

    }

}
