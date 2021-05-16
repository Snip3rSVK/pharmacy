package App.Drug;

import java.io.Serializable;

public class DrugInformation implements Serializable {

    private Drug drug;
    private String composition;
    private String dosing;
    //String adverseEffects;

    public DrugInformation(Drug drug, String composition, String dosing) {
        this.drug = drug;
        this.composition = composition;
        this.dosing = dosing;
    }

    public String getComposition() {
        return this.composition;
    }

    public String getDosing() {
        return this.dosing;
    }

    // TODO
    public String getDrugFullName() {
        return this.drug.getFullName();
    }

    public String getDrugManufacturerName() {
        return this.drug.getManufacturerName();
    }

    public Drug getDrug() {
        return this.drug;
    }

    // this is for deserialization
    public void setDrug(Drug drug) {
        this.drug = drug;
    }
}
