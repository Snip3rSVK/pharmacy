package App.Db;

import App.Drug.Drug;
import App.Drug.DrugManufacturer;
import App.Drug.DrugSupplier;

import java.util.*;

public class DrugsDatabase extends AbstractDatabase<Drug> {

    private Map<String, DrugManufacturer> allDrugManufacturers = new HashMap<>();
    private Map<String, DrugSupplier> allDrugSuppliers = new HashMap<>();
    private Set<Drug> allDrugs = new HashSet<>();

    public DrugsDatabase() {
        this.initializeManufacturers();
        this.initializeSuppliers();
        this.initializeDrugs();
    }

    private void initializeManufacturers() {
        DrugManufacturer herbacos = new DrugManufacturer("Herbacos Recordati s.r.o.", "CZE");
        allDrugManufacturers.put(herbacos.getName(), herbacos);
    }

    private void initializeSuppliers() {
        DrugSupplier herbacos = new DrugSupplier("Herbacos Recordati s.r.o.", "CZE");
        allDrugSuppliers.put(herbacos.getName(), herbacos);
    }

    private void initializeDrugs() {
        DrugManufacturer acylpyrinManufacturer = this.allDrugManufacturers.get("Herbacos Recordati s.r.o.");

        ArrayList<DrugSupplier> acylpyrinSuppliers = new ArrayList<>();
        acylpyrinSuppliers.add(this.allDrugSuppliers.get("Herbacos Recordati s.r.o."));

        this.allDrugs.add(new Drug("07/0066/73-S", 25544, "ACYLPYRIN 500 mg šumivé tablety", "tbl eff 20x500 mg (tuba PP)", acylpyrinManufacturer, acylpyrinSuppliers, false, 2.99));
    }

    public Set<Drug> getAll() {
        return this.allDrugs;
    }
}
