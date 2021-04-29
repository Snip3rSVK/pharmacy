package App.Router;

public enum RouterEnum implements RouterEnumType {
    LOGIN;

    public enum ADMIN implements RouterEnumType {
        MANAGER,
        PHARMACIST,
        BUY_MEDICINE,
    }
}
