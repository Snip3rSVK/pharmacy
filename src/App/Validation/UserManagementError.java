package App.Validation;

public class UserManagementError extends Error {

    public UserManagementError(UserManagementErrorEnum errorEnum) {
        super(errorEnum.toString());
    }

}
