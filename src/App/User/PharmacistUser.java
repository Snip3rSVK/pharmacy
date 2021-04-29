package App.User;

import App.Router.RouterEnum;
import Services.SceneService;

public class PharmacistUser extends User {
    // drugsSelled[]

    public PharmacistUser(String firstName, String lastName, String email, String phone, String password, SceneService sceneService) {
        super(firstName, lastName, email, phone, password, sceneService);
    }

    public void login() {
        this.sceneService.switchScene(RouterEnum.ADMIN.PHARMACIST);
    }
}