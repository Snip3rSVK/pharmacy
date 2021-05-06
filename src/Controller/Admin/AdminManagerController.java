package Controller.Admin;

import Model.Admin.AdminManagerModel;
import Services.SceneService;

public class AdminManagerController extends AbstractAdminController<AdminManagerModel> {
    public AdminManagerController(SceneService sceneService) {
        super(sceneService);
    }
}
