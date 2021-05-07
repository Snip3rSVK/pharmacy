package App.Db;

import App.Order.Order;

import java.util.*;

public class OrdersDatabase extends AbstractDatabase<Order> {

    // sort by date
    // TODO check if sorting is correct
    private SortedSet<Order> allOrders = new TreeSet<>((o1, o2) -> o2.getCreatedDate().compareTo(o1.getCreatedDate()));

    public SortedSet<Order> getAll() {
        return this.allOrders;
    }

    public void add(Order order) {
        this.allOrders.add(order);
    }
}
