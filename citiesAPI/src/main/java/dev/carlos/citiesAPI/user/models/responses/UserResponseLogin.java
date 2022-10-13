package dev.carlos.citiesAPI.user.models.responses;

public class UserResponseLogin {
    private String userName;
    private String userToken;

    public UserResponseLogin() {
    }

    public String getUserName() {
        return userName;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    @Override
    public String toString() {
        return "UserResponseLogin{" +
                "userName='" + userName + '\'' +
                ", userToken='" + userToken + '\'' +
                '}';
    }
}
