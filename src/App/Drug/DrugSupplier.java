package App.Drug;

import java.io.Serializable;

public class DrugSupplier implements Serializable {

    private String name;
    private String countryCode;

    public DrugSupplier(String name, String countryCode) {
        this.name = name;
        this.countryCode = countryCode;
    }

    public String getName() {
        return name;
    }
}
