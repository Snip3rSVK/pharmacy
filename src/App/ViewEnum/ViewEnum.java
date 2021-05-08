package App.ViewEnum;

import java.io.IOException;
import java.net.URL;

public enum ViewEnum {
    LOGIN("Login.fxml"),
    ADMIN_MANAGER("Admin/AdminManager.fxml"),
    ADMIN_PHARMACIST("Admin/AdminPharmacist.fxml"),
    ADMIN_BUY_MEDICINE("Admin/AdminBuyMedicine.fxml"),
    ADMIN_WAREHOUSE("Admin/AdminWarehouse.fxml");

    private final String VIEW_DIRECTORY = "/View/";

    private URL path;

    ViewEnum(String path) {
        String fullPath = this.VIEW_DIRECTORY + path;

        this.path = getClass().getResource(fullPath);

        if (this.path == null) {
            // TODO maybe enum message
            throw new IllegalStateException("Couldn't load file " + fullPath);
        }
    }

    public URL getPath() {
        return this.path;
    }

}
