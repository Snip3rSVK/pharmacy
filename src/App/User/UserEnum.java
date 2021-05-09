package App.User;

public enum UserEnum {
    MANAGER("Manažér"),
    PHARMACIST("Lekárník");

    private final String text;

    UserEnum(String str) {
        this.text = str;
    }

    public String toString() {
        return this.text;
    }
}
