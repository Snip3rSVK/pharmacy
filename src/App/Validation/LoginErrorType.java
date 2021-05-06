package App.Validation;

public enum LoginErrorType {
    BAD_LOGIN ("Nesprávny email alebo heslo!");

    private final String name;

    LoginErrorType(String str) {
        this.name = str;
    }

    // TODO check this
    public String toString() {
        return this.name;
    }
}
