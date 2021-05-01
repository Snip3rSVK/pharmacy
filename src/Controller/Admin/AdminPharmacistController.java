package Controller.Admin;

import Model.Admin.AdminPharmacistModel;
import Services.LoginService;
import Services.SceneService;

public class AdminPharmacistController extends AbstractAdminController<AdminPharmacistModel> {
    public AdminPharmacistController(SceneService sceneService) {
        super(sceneService);
    }
}
