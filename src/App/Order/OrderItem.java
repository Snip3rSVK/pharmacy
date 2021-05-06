package App.Order;

import App.Drug.Drug;
import App.Drug.DrugSupplier;

public class OrderItem {

    private Drug drug;
    private DrugSupplier drugSupplier;
    private Integer drugCount;

    public OrderItem(Drug drug, DrugSupplier drugSupplier, Integer drugCount) {
        this.drug = drug;
        this.drugSupplier = drugSupplier;
        this.drugCount = drugCount;
    }

    public Drug getDrug() {
        return this.drug;
    }

}
