package App.Drug;

public class DrugInformation {

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
}
