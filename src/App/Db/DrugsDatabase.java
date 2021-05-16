package App.Db;

import App.Drug.Drug;
import App.Drug.DrugManufacturer;
import App.Drug.DrugSupplier;

import java.util.*;

public class DrugsDatabase implements Database<Drug> {

    private Map<Integer, Drug> drugCodeMap = new HashMap<>();
    private Map<String, DrugSupplier> drugSupplierNameMap = new HashMap<>();
    private Set<Drug> allDrugs = new HashSet<>();

    public DrugsDatabase() {
        this.deserializeAll();
    }

    public Set<Drug> getAll() {
        return this.allDrugs;
    }

    public Drug getByCode(Integer code) {
        return this.drugCodeMap.get(code);
    }

    public DrugSupplier getSupplierByName(String name) {
        return this.drugSupplierNameMap.get(name);
    }

    public void addDeserialized(Drug drug) {
        this.allDrugs.add(drug);
        this.drugCodeMap.put(drug.getCode(), drug);

        for (DrugSupplier supplier : drug.getSuppliers()) {
            this.drugSupplierNameMap.put(supplier.getName(), supplier);
        }
    }
}
