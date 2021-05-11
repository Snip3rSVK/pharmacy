package Services;

import App.ViewEnum.ViewEnum;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.HashMap;

public class SceneService implements Service {
    private HashMap<ViewEnum, FXMLLoader> scenes = new HashMap<>();

    private Scene scene;

    public SceneService() {
        this.scene = new Scene(new Group(), 1280, 720);
    }

    public Scene getScene() {
        return this.scene;
    }

    public void add(ViewEnum viewEnum, FXMLLoader loader) {
        this.scenes.put(viewEnum, loader);
    }

    public void switchScene(ViewEnum viewEnum) {
        FXMLLoader loader = this.scenes.get(viewEnum);
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
