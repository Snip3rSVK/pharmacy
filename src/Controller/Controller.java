package Controller;

import Model.Model;

public abstract class Controller<T extends Model> {
    protected T m = null;

    public void initModel(T model) {
        if (this.m != null) {
            // TODO maybe enum message
            throw new IllegalStateException("Model can only be initialized once");
        }

        this.m = model;
    }
}
