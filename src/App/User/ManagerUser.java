package App.User;

import App.Router.RouterEnum;
import Services.SceneService;

public class ManagerUser extends User {
    // ReportsCreated[]
    // PurchaseMade[]

    public ManagerUser(String firstName, String lastName, String email, String phone, String password, SceneService sceneService) {
        super(firstName, lastName, email, phone, password, sceneService);
    }

    public void login() {
        this.sceneService.switchScene(RouterEnum.ADMIN.MANAGER);
    }
}
