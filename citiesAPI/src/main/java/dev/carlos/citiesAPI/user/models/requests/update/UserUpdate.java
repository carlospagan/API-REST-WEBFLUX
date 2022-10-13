package dev.carlos.citiesAPI.user.models.requests.update;

public class UserUpdate {
    private String userName;

    private String userToken;

    //CONSTRUCTOR

    public UserUpdate() {
    }

    //GETTERS AND SETTERS

    public String getUserName() {
        return userName;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "UserUpdate{" +
                "userName='" + userName + '\'' +
                ", userToken='" + userToken + '\'' +
                '}';
    }
}
