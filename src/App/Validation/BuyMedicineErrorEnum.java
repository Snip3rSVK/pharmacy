package App.Validation;

public enum BuyMedicineErrorEnum implements ErrorEnum {
    DRUG_COUNT_CANNOT_BE_ZERO("Počet liekov nesmie byť nula!"),
    DRUG_COUNT_EXCEEDS_MAX_COUNT("Počet liekov presahuje maximálny povolený počet!");

    private final String name;

    BuyMedicineErrorEnum(String str) {
        this.name = str;
    }

    public String getText() {
        return this.name;
    }

}
