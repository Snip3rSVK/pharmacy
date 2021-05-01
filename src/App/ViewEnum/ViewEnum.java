package App.ViewEnum;

import java.net.URL;

public enum ViewEnum {
    LOGIN("Login.fxml"),
    ADMIN_MANAGER("Admin/AdminManager.fxml"),
    ADMIN_PHARMACIST("Admin/AdminPharmacist.fxml");

    private final String VIEW_DIRECTORY = "../../View/";

    private URL path;

    ViewEnum(String path) {
        this.path = getClass().getResource(this.VIEW_DIRECTORY + path);
    }

    public URL getPath() {
        return this.path;
    }

}
