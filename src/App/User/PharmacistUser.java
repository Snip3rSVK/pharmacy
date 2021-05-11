package App.User;

import App.DependencyInjectionContainer;
import App.ViewEnum.ViewEnum;

public class PharmacistUser extends User {
    // TODO drugsSelled[]

    public PharmacistUser(String firstName, String lastName, String email, String password) {
        super(firstName, lastName, email, password);
    }

    public UserEnum getType() {
        return UserEnum.PHARMACIST;
    }

    public void login() {
        DependencyInjectionContainer.sceneService.switchScene(ViewEnum.ADMIN_MANAGER);
    }
}