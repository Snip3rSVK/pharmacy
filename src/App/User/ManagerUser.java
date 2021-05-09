package App.User;

import App.ViewEnum.ViewEnum;
import Services.SceneService;

public class ManagerUser extends User {
    // TODO ReportsCreated[]
    // TODO PurchaseMade[]

    public ManagerUser(String firstName, String lastName, String email, String password) {
        super(firstName, lastName, email, password);
    }

    public ViewEnum adminViewEnum() {
        return ViewEnum.ADMIN_MANAGER;
    }

    public UserEnum getType() {
        return UserEnum.MANAGER;
    }
}
