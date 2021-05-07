package Model.Admin;

import App.Order.Order;
import App.Validation.BuyMedicineError;
import App.Validation.BuyMedicineErrorEnum;
import Services.LoginService;
import Services.OrderService;

import java.text.DecimalFormat;

public class AdminBuyMedicineModel extends AbstractAdminModel {
    public Order order;

    private OrderService orderService;

    private final Integer MAX_ORDER_ITEM_DRUG_COUNT = 1000;

    public AdminBuyMedicineModel(LoginService loginService, OrderService orderService) {
        super(loginService);

        this.orderService = orderService;
    }

    public void initializeOrResetOrder() {
        this.order = new Order();
    }

    public void createOrder() {
        this.orderService.createOrder(this.order);
    }

    public void validateDrugCount(Integer drugCount) {
        if (drugCount == 0) {
            throw new BuyMedicineError(BuyMedicineErrorEnum.DRUG_COUNT_CANNOT_BE_ZERO);
        }
        if (drugCount > MAX_ORDER_ITEM_DRUG_COUNT) {
            throw new BuyMedicineError(BuyMedicineErrorEnum.DRUG_COUNT_EXCEEDS_MAX_COUNT);
        }
    }

}
