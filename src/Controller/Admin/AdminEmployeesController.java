package Controller.Admin;

import App.Db.UsersDatabase;
import App.User.User;
import App.User.UserEnum;
import App.Validation.UserManagementError;
import Model.Admin.AdminEmployeesModel;
import Services.SceneService;
import Services.UserManagementService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Arrays;

public class AdminEmployeesController extends AbstractAdminController<AdminEmployeesModel> {

    private UsersDatabase usersDatabase;
    private UserManagementService userManagementService;

    public AdminEmployeesController(SceneService sceneService, UsersDatabase usersDatabase, UserManagementService userManagementService) {
        super(sceneService);

        this.usersDatabase = usersDatabase;
        this.userManagementService = userManagementService;
    }

    @FXML
    private TableView<User> users;

    @FXML
    private Button selectButton;

    @FXML
    private Button addButton;

    @FXML
    private Button editButton;

    @FXML
    private Button removeButton;

    @FXML
    private VBox addUserBox;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private ChoiceBox<UserEnum> choiceBox;

    @FXML
    private Text errorMessage;


    public void initialize() {
        users.getItems().addAll(this.usersDatabase.getAll());

        ArrayList<Button> allButtons = new ArrayList<>(Arrays.asList(selectButton, editButton, removeButton));
        for (Button button : allButtons) {
            // show button only if user is selected in table
            button.disableProperty().bind(users.getSelectionModel().selectedItemProperty().isNull());
        }

        choiceBox.setItems(FXCollections.observableArrayList(UserEnum.values()));
    }

    public void clear() {
        errorMessage.setText("");

        firstNameField.clear();
        lastNameField.clear();
        emailField.clear();
        passwordField.clear();
    }

    public void selectUser() {
        User selectedUser = this.getSelectedUser();

        firstNameField.setText(selectedUser.getFirstName());
        lastNameField.setText(selectedUser.getLastName());
        emailField.setText(selectedUser.getEmail());
        passwordField.setText(selectedUser.getPassword());
        choiceBox.setValue(selectedUser.getType());
    }

    public void addUser() {
        try {
            User newUser = this.userManagementService.add(
                firstNameField.getText(),
                lastNameField.getText(),
                emailField.getText(),
                passwordField.getText(),
                choiceBox.getValue()
            );

            // TODO some automation for this
            this.users.getItems().add(newUser);
            this.clear();
        }
        catch (UserManagementError error) {
            // TODO this is redundant
            errorMessage.setText(error.getMessage());
        }
    }

    public void editUser() {
        try {
            this.userManagementService.edit(
                this.getSelectedUser(),
                firstNameField.getText(),
                lastNameField.getText(),
                emailField.getText(),
                passwordField.getText()
            );

            this.users.refresh();
            this.clear();
        }
        catch (UserManagementError error) {
            errorMessage.setText(error.getMessage());
        }
    }

    public void removeUser() {
        try {
            this.userManagementService.remove(this.getSelectedUser());

            this.users.getItems().remove(this.getSelectedUser());
            this.clear();
        }
        catch (UserManagementError error) {
            errorMessage.setText(error.getMessage());
        }

    }

    private User getSelectedUser() {
        return users.getSelectionModel().getSelectedItem();
    }

}
