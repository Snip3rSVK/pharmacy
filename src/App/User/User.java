package App.User;

import App.DependencyInjectionContainer;
import App.ViewEnum.ViewEnum;
import Services.SceneService;

import java.io.Serializable;

// TODO serialization
public class User {
    private String firstName;
    private String lastName;

    private String email;

    private String password;

    User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;

        this.email = email;

        this.password = password;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public UserEnum getType() {
        return null;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void login() {
        DependencyInjectionContainer.sceneService.switchScene(ViewEnum.LOGIN);
    }
}
