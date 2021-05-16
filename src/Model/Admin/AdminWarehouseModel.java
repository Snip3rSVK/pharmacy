package Model.Admin;

import App.Db.WarehouseDatabase;
import App.Warehouse.WarehouseItem;
import Services.LoginService;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class AdminWarehouseModel extends AbstractAdminModel {
    private WarehouseDatabase warehouseDatabase;

    public AdminWarehouseModel(LoginService loginService, WarehouseDatabase warehouseDatabase) {
        super(loginService);

        this.warehouseDatabase = warehouseDatabase;
    }

    public TreeView<String> getTreeView() {
        TreeItem<String> rootItem = new TreeItem<>("Sklad");

        TreeItem<String> currTreeItem = null;
        String currTreeItemSection = "";
        for (WarehouseItem item : this.warehouseDatabase.getAll()) {
            String warehouseItemSection = item.getSection();

            if (!currTreeItemSection.equals(warehouseItemSection)) {
                currTreeItemSection = warehouseItemSection;
                currTreeItem = new TreeItem<>(warehouseItemSection);

                rootItem.getChildren().add(currTreeItem);
            }

            currTreeItem.getChildren().add(new TreeItem<>("(" + item.getDrugCount() + " ks) " + item.getDrug().getFullName()));
        }

        rootItem.setExpanded(true);

        return new TreeView<>(rootItem);
    }

}
