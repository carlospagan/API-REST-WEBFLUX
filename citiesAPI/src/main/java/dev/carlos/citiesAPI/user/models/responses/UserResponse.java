package dev.carlos.citiesAPI.user.models.responses;

public class UserResponse {

    private String userName;
    private String userEmail;
    private String userUf;
    private String userCity;

    //CONSTRUCTOR

    public UserResponse() {
    }

    //GETTERS AND SETTERS


    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
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

    public void setUserUf(String userUf) {
        this.userUf = userUf;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userUf='" + userUf + '\'' +
                ", userCity='" + userCity + '\'' +
                '}';
    }
}
