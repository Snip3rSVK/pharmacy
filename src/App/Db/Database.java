package App.Db;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

public interface Database<E> {

    String DATABASE_EXTENSION = ".ser";
    Path DATABASE_PATH = Paths.get("src", "App", "Db");

    Set<E> getAll();

    void addDeserialized(E item);

    default String getPath() {
        String path = this.DATABASE_PATH.toFile().getAbsolutePath();

        return path + File.separator + this.getClass().getSimpleName() + this.DATABASE_EXTENSION;
    }

    default void serializeAll() {
        try {
            FileOutputStream outputFile = new FileOutputStream(this.getPath());
            ObjectOutputStream outputStream = new ObjectOutputStream(outputFile);

            outputStream.writeObject(this.getAll());

            outputStream.close();
            outputFile.close();
        }
        catch (IOException error) {
            error.printStackTrace();
        }
    }

    default void deserializeAll() {
        try {
            FileInputStream inputFile = new FileInputStream(this.getPath());
            ObjectInputStream inputStream = new ObjectInputStream(inputFile);

            for(E item : (Set<E>) inputStream.readObject()) {
                this.addDeserialized(item);
            }

            inputStream.close();
            inputFile.close();
        }
        catch (IOException | ClassNotFoundException error) {
            error.printStackTrace();
        }
    }

}
