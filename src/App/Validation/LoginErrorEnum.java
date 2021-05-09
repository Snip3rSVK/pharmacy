package App.Validation;

public enum LoginErrorEnum implements ErrorEnum {
    BAD_LOGIN ("Nesprávny email alebo heslo!");

    private final String name;

    LoginErrorEnum(String str) {
        this.name = str;
    }

    public String toString() {
        return this.name;
    }
}
