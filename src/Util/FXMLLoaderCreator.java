package Util;

import App.ViewEnum.ViewEnum;
import Controller.Controller;
import Model.Model;
import javafx.fxml.FXMLLoader;

public class FXMLLoaderCreator {
    private FXMLLoaderCreator() {}

    public static FXMLLoader create(ViewEnum viewEnum, Model model, Controller controller) {
        FXMLLoader loader = new FXMLLoader(viewEnum.getPath());
        controller.initModel(model);
        loader.setControllerFactory((Class<?> type) -> controller);

        return loader;
    }

}
