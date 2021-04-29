package Services;

import App.Router.RouterEnum;
import App.Router.RouterEnumType;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class SceneService {
    private HashMap<RouterEnumType, FXMLLoader> scenes = new HashMap<>();

    private Scene scene;
    private Stage primaryStage;

    public SceneService(Stage primaryStage) {
        this.scene = new Scene(new Group(), 1280, 720);

        this.primaryStage = primaryStage;
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
    }

    public void add(RouterEnumType routerEnum, FXMLLoader loader) {
        this.scenes.put(routerEnum, loader);
    }

    public void switchScene(RouterEnumType routerEnum) {
        FXMLLoader loader = this.scenes.get(routerEnum);
        loader.setRoot(null);
        loader.setController(null);

        try {
            this.scene.setRoot(loader.load());
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

}
