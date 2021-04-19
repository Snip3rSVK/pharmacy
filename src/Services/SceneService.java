package Services;

import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

// TODO
public class SceneService {
    private HashMap<String, FXMLLoader> scenes = new HashMap<>();
    private Scene scene;
    private Stage primaryStage;

    public SceneService(Stage primaryStage) {
        this.scene = new Scene(new Group(), 1280, 720);

        this.primaryStage = primaryStage;
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
    }

    public void add(String name, FXMLLoader loader) {
        this.scenes.put(name, loader);
    }

    public void switchScene(String name) {
        FXMLLoader loader = this.scenes.get(name);
        loader.setRoot(null);
        loader.setController(null);

        try {
            this.scene.setRoot(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
