package Services;

import App.Db.OrdersDatabase;
import App.Db.WarehouseDatabase;
import App.Order.Order;
import App.Order.OrderItem;

public class OrderService extends Service {

    private OrdersDatabase ordersDatabase;
    private WarehouseDatabase warehouseDatabase;

    public OrderService(OrdersDatabase ordersDatabase, WarehouseDatabase warehouseDatabase) {
        this.ordersDatabase = ordersDatabase;
        this.warehouseDatabase = warehouseDatabase;
    }

    public void createOrder(Order order) {
        order.create();

        this.ordersDatabase.add(order);

        // update drug count in warehouse
        for (OrderItem item : order.getItems()) {
            this.warehouseDatabase.increaseDrugCount(item.getDrug(), item.getDrugCount());
        }
    }

    // TODO smth like public ... getLastMonthOrdersSum
}
