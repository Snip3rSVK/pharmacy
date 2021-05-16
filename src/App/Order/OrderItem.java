package App.Order;

import App.Drug.Drug;
import App.Drug.DrugSupplier;

import java.io.Serializable;

public class OrderItem implements Serializable {

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

    // for deserialization
    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    // for deserialization
    public void setDrugSupplier(DrugSupplier drugSupplier) {
        this.drugSupplier = drugSupplier;
    }

    public DrugSupplier getDrugSupplier() {
        return this.drugSupplier;
    }

    public Integer getDrugCount() {
        return this.drugCount;
    }

    public String getDrugName() {
        return this.getDrug().getFullName();
    }

    public String getDrugSupplierName() {
        return this.getDrugSupplier().getName();
    }

}
