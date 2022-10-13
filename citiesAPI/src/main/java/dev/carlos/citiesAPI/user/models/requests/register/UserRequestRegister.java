package dev.carlos.citiesAPI.user.models.requests.register;

public class UserRequestRegister {

    private String userName;
    private String userEmail;
    private String userPassword;
    private String userUf;
    private String userCity;

    //CONSTRUCTOR

    public UserRequestRegister() {
    }

    //GETTERS AND SETTERS


    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserUf() {
        return userUf;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setUserUf(String userUf) {
        this.userUf = userUf;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    @Override
    public String toString() {
        return "UserRequestRegister{" +
                "userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userUf='" + userUf + '\'' +
                ", userCity='" + userCity + '\'' +
                '}';
    }
}
