package Util;

import App.Order.Order;
import App.Warehouse.WarehouseItem;

import java.io.Serializable;
import java.util.Comparator;

public class Comparators {
    private Comparators() {}

    public static class WarehouseComparator implements Comparator<WarehouseItem>, Serializable {
        public int compare(WarehouseItem w1, WarehouseItem w2) {
            return w2.getSection().compareTo(w1.getSection());
        }
    }

    public static class OrderComparator implements Comparator<Order>, Serializable {
        public int compare(Order o1, Order o2) {
            return o2.getCreatedDate().compareTo(o1.getCreatedDate());
        }
    }

}
