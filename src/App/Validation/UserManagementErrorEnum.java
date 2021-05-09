package App.Validation;

public enum UserManagementErrorEnum implements ErrorEnum {

    FIRST_NAME_EMPTY("Meno je prázdne!"),
    LAST_NAME_EMPTY("Priezvisko je prázdne!"),
    INVALID_EMAIL("Email nie je v správnom tvare!"),
    EMAIL_ALREADY_EXISTS("Používateľ s takýmto emailom už existuje!"),
    SHORT_PASSWORD_LENGTH("Heslo je príliš krátke"),
    PASSWORD_DOESNT_CONTAIN_NUMBERS("Heslo musí obsahovať číslice"),
    PASSWORD_DOESNT_CONTAIN_ALPHABET("Heslo musí obsahovať znaky abecedy"),
    USER_TYPE_NOT_SPECIFIED("Nie je zvolený typ používateľa!"),
    CANNOT_REMOVE_CURRENT_USER("Nie je možné odstrániť práve prihlaseného používateľa!");

    private final String name;

    UserManagementErrorEnum(String str) {
        this.name = str;
    }

    public String toString() {
        return this.name;
    }

}
