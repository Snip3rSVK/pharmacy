package App.User;

import App.ViewEnum.ViewEnum;
import Services.SceneService;

public class PharmacistUser extends User {
    // drugsSelled[]

    public PharmacistUser(String firstName, String lastName, String email, String phone, String password, SceneService sceneService) {
        super(firstName, lastName, email, phone, password, sceneService);
    }

    public void login() {
        this.sceneService.switchScene(ViewEnum.ADMIN_PHARMACIST);
    }
}