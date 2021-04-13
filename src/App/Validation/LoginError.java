package App.Validation;

public class LoginError extends Error {

    public LoginError(LoginErrorType errorType) {
        super(errorType.toString());
    }

}
