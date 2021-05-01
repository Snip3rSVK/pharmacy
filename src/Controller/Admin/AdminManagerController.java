package Controller.Admin;

import Controller.Controller;
import Model.Admin.AdminManagerModel;
import Services.LoginService;
import Services.SceneService;

public class AdminManagerController extends AbstractAdminController<AdminManagerModel> {
    public AdminManagerController(SceneService sceneService) {
        super(sceneService);
    }
}
