package App.Drug;

import java.util.ArrayList;

public class Drug {

    private String registrationNumber;
    private Integer code;

    private String name;
    private String nameDetail;

    private DrugManufacturer manufacturer;
    private ArrayList<DrugSupplier> suppliers;

    private boolean prescriptionDrug;

    // TODO maybe object as constructor parameter
    public Drug(String registrationNumber, Integer code, String name, String nameDetail, DrugManufacturer manufacturer, ArrayList<DrugSupplier> suppliers, boolean prescriptionDrug) {
        this.registrationNumber = registrationNumber;
        this.code = code;

        this.name = name;
        this.nameDetail = nameDetail;

        this.manufacturer = manufacturer;
        this.suppliers = suppliers;

        this.prescriptionDrug = prescriptionDrug;
    }
}
