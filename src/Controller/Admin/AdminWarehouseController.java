package Controller.Admin;

import Model.Admin.AdminWarehouseModel;
import Services.SceneService;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

public class AdminWarehouseController extends AbstractAdminController<AdminWarehouseModel> {
    public AdminWarehouseController(SceneService sceneService) {
        super(sceneService);
    }

    @FXML
    VBox vBox;

    public void initialize() {
        vBox.getChildren().add(0, this.m.getTreeView());
    }
}
