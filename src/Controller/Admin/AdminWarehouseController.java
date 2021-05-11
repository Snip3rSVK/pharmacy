package Controller.Admin;

import Model.Admin.AdminWarehouseModel;
import Services.LoginService;
import Services.SceneService;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

public class AdminWarehouseController extends AbstractAdminController<AdminWarehouseModel> {
    public AdminWarehouseController(SceneService sceneService, LoginService loginService) {
        super(sceneService, loginService);
    }

    @FXML
    VBox vBox;

    public void initialize() {
        vBox.getChildren().add(0, this.m.getTreeView());
    }
}
