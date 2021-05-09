package App.User;

import App.ViewEnum.ViewEnum;
import Services.SceneService;

public class PharmacistUser extends User {
    // TODO drugsSelled[]

    public PharmacistUser(String firstName, String lastName, String email, String password) {
        super(firstName, lastName, email, password);
    }

    public ViewEnum adminViewEnum() {
        return ViewEnum.ADMIN_PHARMACIST;
    }

    public UserEnum getType() {
        return UserEnum.PHARMACIST;
    }
}