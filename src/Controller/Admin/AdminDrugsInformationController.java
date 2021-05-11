package Controller.Admin;

import App.Db.DrugsInformationDatabase;
import App.Drug.DrugInformation;
import Model.Admin.AdminDrugsInformationModel;
import Services.LoginService;
import Services.SceneService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;

public class AdminDrugsInformationController extends AbstractAdminController<AdminDrugsInformationModel> {
    private DrugsInformationDatabase drugsInformationDatabase;

    public AdminDrugsInformationController(SceneService sceneService, DrugsInformationDatabase drugsInformationDatabase, LoginService loginService) {
        super(sceneService, loginService);

        this.drugsInformationDatabase = drugsInformationDatabase;
    }

    @FXML
    private TableView<DrugInformation> drugsInformation;

    @FXML
    private Text composition;

    @FXML
    private Text dosing;

    public void initialize() {
        drugsInformation.setItems(FXCollections.observableArrayList(this.drugsInformationDatabase.getAll()));

        drugsInformation.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                this.setInfo(newValue);
            }
        });
    }

    private void setInfo(DrugInformation drugInformation) {
        composition.setText(drugInformation.getComposition());
        dosing.setText(drugInformation.getDosing());
    }
}
