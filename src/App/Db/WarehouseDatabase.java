package App.Db;

import App.Drug.Drug;
import App.Order.Order;
import App.Warehouse.WarehouseItem;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class WarehouseDatabase extends AbstractDatabase<WarehouseItem> {
    private Map<Drug, WarehouseItem> warehouseMap = new HashMap<>();
    // sort by section
    private SortedSet<WarehouseItem> allStorage = new TreeSet<>((w1, w2) -> w2.getSection().compareTo(w1.getSection()));

    public WarehouseDatabase() {

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
            this.warehouseMap.put(drug, warehouseItem);
        }

        return warehouseItem;
    }
}
