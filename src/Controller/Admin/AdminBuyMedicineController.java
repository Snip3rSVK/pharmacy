package Controller.Admin;

import App.Db.DrugsDatabase;
import App.Drug.Drug;
import App.Drug.DrugSupplier;
import App.Order.OrderItem;
import App.Validation.BuyMedicineError;
import Model.Admin.AdminBuyMedicineModel;
import Services.SceneService;
import Util.FXMLListView;
import Util.Format;
import Util.Formatter;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;

import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

// TODO too much logic here, try to refactor or move some logic to model

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
    private Text errorMessageDrugCount;

    @FXML
    private Button addToCartButton;

    @FXML
    private TableView<OrderItem> orderItems;

    @FXML
    private Text totalPrice;

    @FXML
    private Button removeOrderItemButton;

    @FXML
    private Button buyButton;

    public void initialize() {
        this.m.initializeOrResetOrder();

        this.initializeDrugs();
        this.initializeSuppliers();
        this.initializeDrugCount();
        this.initializeAddToCart();

        this.initializeTotalPrice();
        this.initializeRemoveOrderItem();
        this.initializeBuy();
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

    public void initializeTotalPrice() {
        // update total price on add/remove item to cart
        orderItems.getItems().addListener((ListChangeListener<? super OrderItem>)param -> {
            // print total price in euros
            totalPrice.setText(Format.euro.format(this.m.getOrder().getTotalPrice()));
        });
    }

    public void initializeRemoveOrderItem() {
        // show removeOrderButton only when something in orderItems is selected
        removeOrderItemButton.disableProperty().bind(orderItems.getSelectionModel().selectedItemProperty().isNull());
    }

    public void initializeBuy() {
        // enable add to cart button when all fields are selected/filled
        buyButton.disableProperty().bind(Bindings.isEmpty(orderItems.getItems()));
    }

    public void addToCart() {
        errorMessageDrugCount.setText("");

        try {
            Integer count = Integer.parseInt(drugCount.getText());

            this.m.validateDrugCount(count);

            OrderItem orderItem = new OrderItem(
                drugsList.getSelectionModel().getSelectedItem(),
                suppliersList.getSelectionModel().getSelectedItem(),
                count
            );

            this.m.getOrder().add(orderItem);

            this.clearFields();

            orderItems.getItems().add(orderItem);
        }
        catch (BuyMedicineError error) {
            errorMessageDrugCount.setText(error.getMessage());
        }


    }

    public void clearFields() {
        drugCount.clear();
        suppliersList.getSelectionModel().clearSelection();
        drugsList.getSelectionModel().clearSelection();
    }

    public void removeFromCart() {
        OrderItem selectedItem = orderItems.getSelectionModel().getSelectedItem();

        this.m.getOrder().remove(selectedItem);

        orderItems.getItems().remove(selectedItem);
    }

    public void buy() {
        this.clearFields();

        this.m.createOrder();

        this.m.initializeOrResetOrder();

        orderItems.getItems().clear();

        // TODO success message
    }
}
