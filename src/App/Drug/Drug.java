package App.Drug;

import Util.HashGenerator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

public class Drug implements Serializable {

    private String registrationNumber;
    private Integer code;

    private String name;
    private String nameDetail;

    private DrugManufacturer manufacturer;
    private ArrayList<DrugSupplier> suppliers;

    private Boolean prescriptionDrug;

    private Double price;

    // TODO buying price, selling price of drug??

    // TODO maybe object as constructor parameter
    public Drug(String registrationNumber, Integer code, String name, String nameDetail, DrugManufacturer manufacturer, ArrayList<DrugSupplier> suppliers, Boolean prescriptionDrug, Double price) {
        this.registrationNumber = registrationNumber;
        this.code = code;

        this.name = name;
        this.nameDetail = nameDetail;

        this.manufacturer = manufacturer;
        this.suppliers = suppliers;

        this.prescriptionDrug = prescriptionDrug;

        this.price = price;
    }


    public String getFullName() {
        return this.name + ", " + this.nameDetail;
    }

    public Integer getCode() {
        return this.code;
    }

    public Double getPrice() {
        return this.price;
    }

    public DrugManufacturer getManufacturer() {
        return this.manufacturer;
    }

    public String getManufacturerName() {
        return this.manufacturer.getName();
    }

    public ArrayList<DrugSupplier> getSuppliers() {
        return this.suppliers;
    }

}
