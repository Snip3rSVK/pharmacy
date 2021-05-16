package App.Db;

import App.Order.Order;
import App.Order.OrderItem;
import Util.Comparators;

import java.util.*;

public class OrdersDatabase implements Database<Order> {

    // sort by date
    // TODO check if sorting is correct
    private SortedSet<Order> allOrders = new TreeSet<>(new Comparators.OrderComparator());

    private DrugsDatabase drugsDatabase;

    public OrdersDatabase(DrugsDatabase drugsDatabase) {
        this.drugsDatabase = drugsDatabase;

        this.deserializeAll();
    }

    public SortedSet<Order> getAll() {
        return this.allOrders;
    }

    public void add(Order order) {
        this.allOrders.add(order);
    }

    public void addDeserialized(Order order) {
        for (OrderItem item : order.getItems()) {
            // set drug, drugSupplier to same instances as drug, drugSupplier in drugsDatabase in deserialization
            item.setDrug(this.drugsDatabase.getByCode(item.getDrug().getCode()));
            item.setDrugSupplier(this.drugsDatabase.getSupplierByName(item.getDrugSupplierName()));
        }

        this.add(order);
    }
}
