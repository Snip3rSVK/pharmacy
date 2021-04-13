package App.Validation;

public enum LoginErrorType {
    BAD_LOGIN ("Nesprávny email alebo heslo!");

    private final String name;

    LoginErrorType(String str) {
        this.name = str;
    }

    public String toString() {
        return this.name;
    }
}
