package App.Warehouse;

import App.Drug.Drug;
import App.Drug.DrugSupplier;
import Util.HashGenerator;

public class WarehouseItem {

    private static final Integer MAX_SECTION_NUMBER = 20;

    private Drug drug;
    private Integer drugCount = 0;

    private String section;

    public WarehouseItem(Drug drug) {
        this.drug = drug;

        this.section = this.generateSection();
    }

    // generates sections like A13, B5, etc.
    private String generateSection() {
        String fullName = this.getDrug().getFullName();

        return Character.toUpperCase(fullName.charAt(0)) + String.valueOf(HashGenerator.generateFromString(fullName, MAX_SECTION_NUMBER));
    }

    public Drug getDrug() {
        return this.drug;
    }

    public Integer getDrugCount() {
        return this.drugCount;
    }

    public String getSection() {
        return this.section;
    }

    public void increaseDrugCountBy(Integer number) {
        this.drugCount += number;
    }

    public void decreaseDrugCountBy(Integer number) {
        Integer updatedDrugCount = this.drugCount - number;

        if (updatedDrugCount < 0) {
            throw new IllegalStateException("Cannot decrease by drugCount larger than drugCount in warehouse!");
        }

        this.drugCount = updatedDrugCount;
    }

}
