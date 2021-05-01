package App.User;

import App.ViewEnum.ViewEnum;
import Services.SceneService;

public class ManagerUser extends User {
    // ReportsCreated[]
    // PurchaseMade[]

    public ManagerUser(String firstName, String lastName, String email, String phone, String password, SceneService sceneService) {
        super(firstName, lastName, email, phone, password, sceneService);
    }

    public void login() {
        this.sceneService.switchScene(ViewEnum.ADMIN_MANAGER);
    }
}
