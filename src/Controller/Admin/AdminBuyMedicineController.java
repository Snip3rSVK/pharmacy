package Controller.Admin;

import App.Db.DrugsDatabase;
import App.Drug.Drug;
import App.Drug.DrugSupplier;
import App.Order.OrderItem;
import Model.Admin.AdminBuyMedicineModel;
import Services.SceneService;
import Util.FXMLListView;
import Util.Formatter;
import javafx.collections.FXCollections;

import javafx.fxml.FXML;
import javafx.scene.control.*;


public class AdminBuyMedicineController extends AbstractAdminController<AdminBuyMedicineModel> {
    private DrugsDatabase drugsDatabase;

    // TODO database in controller?!
    public AdminBuyMedicineController(SceneService sceneService, DrugsDatabase drugsDatabase) {
        super(sceneService);

        this.drugsDatabase = drugsDatabase;
    }

    @FXML
    private ListView<Drug> drugsList;

    @FXML
    private ListView<DrugSupplier> suppliersList;

    @FXML
    private TextField drugCount;

    @FXML
    private Button addToCartButton;

    public void initialize() {
        this.m.initializeOrder();

        this.initializeDrugs();
        this.initializeSuppliers();
        this.initializeDrugCount();
        this.initializeAddToCart();
    }

    public void initializeDrugs() {
        // convert drugsDatabase into something javafx can read
        drugsList.setItems(FXCollections.observableArrayList(this.drugsDatabase.getAll()));
        // set list item name to drug.getFullName()
        drugsList.setCellFactory(FXMLListView.cellTextCallback(Drug::getFullName));
    }

    public void initializeSuppliers() {
        // get suppliers when drug is selected
        drugsList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                suppliersList.setItems(FXCollections.observableArrayList(newValue.getSuppliers()));
            }
        });
        // show suppliers after drug is selected
        suppliersList.visibleProperty().bind(drugsList.getSelectionModel().selectedItemProperty().isNotNull());
        // set list item name to drugSupplier.getName()
        suppliersList.setCellFactory(FXMLListView.cellTextCallback(DrugSupplier::getName));
    }

    public void initializeDrugCount() {
        // allow only number in text field
        drugCount.setTextFormatter(new TextFormatter<>(Formatter.numberFilter()));
        // show drug count text field after supplier is selected
        drugCount.visibleProperty().bind(suppliersList.getSelectionModel().selectedItemProperty().isNotNull());
    }

    public void initializeAddToCart() {
        // enable add to cart button when all fields are selected/filled
        addToCartButton.disableProperty().bind(drugCount.textProperty().isEmpty());
    }

    public void addToCart() {
        // TODO validation of drugCount if it is within linmits ---> this.validate....

        this.m.order.add(new OrderItem(
            drugsList.getSelectionModel().getSelectedItem(),
            suppliersList.getSelectionModel().getSelectedItem(),
            Integer.parseInt(drugCount.getText())
        ));

        this.clearFields();
    }

    public void clearFields() {
        drugCount.clear();
        suppliersList.getSelectionModel().clearSelection();
        drugsList.getSelectionModel().clearSelection();
    }

    public void buy() {
        // add to warehouse (store) this.orderService.....
    }
}
