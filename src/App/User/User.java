package App.User;

import java.io.Serializable;

public class User implements Serializable {
    private String firstName;
    private String lastName;

    private String email;
    private String phone;

    private String password;

    User(String firstName, String lastName, String email, String phone, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }
}
