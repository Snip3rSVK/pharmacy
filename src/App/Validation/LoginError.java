package App.Validation;

public class LoginError extends Error {

    public LoginError(LoginErrorEnum errorEnum) {
        super(errorEnum.toString());
    }

}
