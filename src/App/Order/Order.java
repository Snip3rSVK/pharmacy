package App.Order;

import App.Drug.Drug;
import App.Drug.DrugSupplier;

import java.util.*;

public class Order {

    private Set<OrderItem> orderItems = new HashSet<>();
    private Date createdDate;
    private Double totalPrice = 0.00;

    public Order() {}

    // TODO this seems wrong
    public void add(OrderItem item) {
        if (this.createdDate != null) {
            throw new IllegalStateException("Cannot add item because order was already created!");
        }

        this.orderItems.add(item);
        // TODO differentiate buying, selling price
        this.totalPrice += item.getDrug().getPrice() * item.getDrugCount();
    }

    public void remove(OrderItem item) {
        if (this.createdDate != null) {
            throw new IllegalStateException("Cannot remove item because order was already created!");
        }

        if (this.orderItems.remove(item)) {
            this.totalPrice -= item.getDrug().getPrice() * item.getDrugCount();
        }
    }

    public void create() {
        if (this.createdDate != null) {
            throw new IllegalStateException("Order was already created!");
        }

        this.createdDate = new Date();
    }

    public Date getCreatedDate() {
        if (this.createdDate == null) {
            throw new IllegalStateException("Cannot get order date because order is not created!");
        }

        return this.createdDate;
    }

    public Double getTotalPrice() {
        return this.totalPrice;
    }

    public Set<OrderItem> getItems() {
        return this.orderItems;
    }

}
