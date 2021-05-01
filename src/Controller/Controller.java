package Controller;

import Model.Model;

public class Controller<T extends Model> {
    protected T m = null;

    public void initModel(T model) {
        if (this.m != null) {
            throw new IllegalStateException("Model can only be initialized once");
        }

        this.m = model;
    }
}
