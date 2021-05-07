package App.Validation;

public class BuyMedicineError extends Error {

    public BuyMedicineError(BuyMedicineErrorEnum errorEnum) {
        super(errorEnum.getText());
    }

}
