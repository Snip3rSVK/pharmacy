package Util;

import javafx.scene.control.TextFormatter;
import java.util.function.UnaryOperator;

public class Formatter {
    private Formatter() {}

    public static UnaryOperator<TextFormatter.Change> numberFilter() {
        return change -> {
            String text = change.getText();

            if (text.matches("[0-9]*")) {
                return change;
            }

            return null;
        };
    }
}
