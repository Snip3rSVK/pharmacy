package App.Drug;

public class DrugSupplier {

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
