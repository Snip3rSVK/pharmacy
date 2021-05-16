package App.Db;

import App.Drug.Drug;
import App.Warehouse.WarehouseItem;
import Util.Comparators;

import java.util.*;

public class WarehouseDatabase implements Database<WarehouseItem> {
    private Map<Drug, WarehouseItem> warehouseMap = new HashMap<>();
    // sort by section
    private SortedSet<WarehouseItem> allStorage = new TreeSet<>(new Comparators.WarehouseComparator());

    private DrugsDatabase drugsDatabase;

    public WarehouseDatabase(DrugsDatabase drugsDatabase) {
        this.drugsDatabase = drugsDatabase;

        this.deserializeAll();
    }

    public SortedSet<WarehouseItem> getAll() {
        return this.allStorage;
    }

    public void increaseDrugCount(Drug drug, Integer howMany) {
        this.getWarehouseItem(drug).increaseDrugCountBy(howMany);
    }

    public void decreaseDrugCount(Drug drug, Integer howMany) {
        this.getWarehouseItem(drug).decreaseDrugCountBy(howMany);
    }

    private WarehouseItem getWarehouseItem(Drug drug) {
        WarehouseItem warehouseItem = this.warehouseMap.get(drug);

        if (warehouseItem == null) {
            warehouseItem = new WarehouseItem(drug);

            this.add(warehouseItem);
        }

        return warehouseItem;
    }

    public void add(WarehouseItem warehouseItem) {
        this.allStorage.add(warehouseItem);
        this.warehouseMap.put(warehouseItem.getDrug(), warehouseItem);
    }

    public void addDeserialized(WarehouseItem warehouseItem) {
        // set drug to same instance as drug in drugsDatabase in deserialization
        warehouseItem.setDrug(this.drugsDatabase.getByCode(warehouseItem.getDrug().getCode()));

        this.add(warehouseItem);
    }
}
