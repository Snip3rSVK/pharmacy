package App.Drug;

public class DrugManufacturer {
    private String name;
    private String countryCode;

    public DrugManufacturer(String name, String countryCode) {
        this.name = name;
        this.countryCode = countryCode;
    }

    public String getName() {
        return name;
    }
}
