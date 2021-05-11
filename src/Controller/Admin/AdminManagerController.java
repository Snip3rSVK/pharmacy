package Controller.Admin;

import Model.Admin.AdminManagerModel;
import Services.LoginService;
import Services.SceneService;

public class AdminManagerController extends AbstractAdminController<AdminManagerModel> {
    public AdminManagerController(SceneService sceneService, LoginService loginService) {
        super(sceneService, loginService);
    }
}
