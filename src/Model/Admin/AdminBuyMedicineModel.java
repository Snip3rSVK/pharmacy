package Model.Admin;

import App.Order.Order;
import Services.LoginService;

public class AdminBuyMedicineModel extends AbstractAdminModel {
    public Order order;

    public AdminBuyMedicineModel(LoginService loginService) {
        super(loginService);
    }

    public void initializeOrder() {
        this.order = new Order();
    }

}
