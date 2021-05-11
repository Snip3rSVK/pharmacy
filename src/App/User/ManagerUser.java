package App.User;

import App.DependencyInjectionContainer;
import App.ViewEnum.ViewEnum;
import Services.SceneService;

public class ManagerUser extends User {
    // TODO ReportsCreated[]
    // TODO PurchaseMade[]

    public ManagerUser(String firstName, String lastName, String email, String password) {
        super(firstName, lastName, email, password);
    }

    public UserEnum getType() {
        return UserEnum.MANAGER;
    }

    public void login() {
        DependencyInjectionContainer.sceneService.switchScene(ViewEnum.ADMIN_MANAGER);
    }

}
