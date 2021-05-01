package App.ViewEnum;

import java.io.IOException;
import java.net.URL;

public enum ViewEnum {
    LOGIN("Login.fxml"),
    ADMIN_MANAGER("Admin/AdminManager.fxml"),
    ADMIN_PHARMACIST("Admin/AdminPharmacist.fxml");

    private final String VIEW_DIRECTORY = "/View/";

    private URL path = null;

    ViewEnum(String path) {
        String fullPath = this.VIEW_DIRECTORY + path;

        this.path = getClass().getResource(fullPath);

        if (this.path == null) {
            throw new IllegalStateException("Couldn't load file " + fullPath);
        }
    }

    public URL getPath() {
        return this.path;
    }

}
