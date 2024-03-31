package com.auth.authenticationServer.models.implementacoes;

import com.auth.authenticationServer.models.interfaces.User;

public class UserLoginPassword implements User {
    private String login;

    public String getLogin() {
        return login;
    }

    private String password;
    
    public String getPassword() {
        return password;
    }

    public UserLoginPassword(String login, String password) {
        this.login = login;   
        this.password = password;
    }

    
    
}
