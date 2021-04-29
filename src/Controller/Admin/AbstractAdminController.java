package Controller.Admin;

import App.Router.RouterEnum;
import Model.Admin.AdminModel;
import Services.LoginService;
import Services.SceneService;

public abstract class AbstractAdminController {
    private AdminModel m;

    protected final LoginService loginService;
    protected final SceneService sceneService;

    public AbstractAdminController(LoginService loginService, SceneService sceneService) {
        this.loginService = loginService;
        this.sceneService = sceneService;
        this.m = new AdminModel(this.loginService);
    }

    public void logout() {
        this.m.logout();

        this.sceneService.switchScene(RouterEnum.LOGIN);
    }

}
