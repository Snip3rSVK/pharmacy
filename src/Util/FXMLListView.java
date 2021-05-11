package Util;

import App.Drug.Drug;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

import java.util.function.Function;

public class FXMLListView {
    private FXMLListView() {}

    public static <T> Callback<ListView<T>, ListCell<T>> cellTextCallback(Function<T, String> strFunc) {
        return param -> new ListCell<T>() {
            @Override
            protected void updateItem(T item, boolean empty) {
            super.updateItem(item, empty);

            if (empty || item == null) {
                setText(null);
                setGraphic(null);
            } else {
                setText(strFunc.apply(item));
            }
            }
        };
    }
}
