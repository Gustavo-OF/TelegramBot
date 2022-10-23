package com.model;

public class Auth {

    private final String userName = "guga";
    private final String password = "crash1010";

    private String token;
    public Auth(){

    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getAuthKey() {
        return token;
    }

    public void setAuthKey(String authKey) {
        this.token = authKey;
    }

}
