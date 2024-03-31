package com.auth.authenticationServer.models.implementacoes;

import com.auth.authenticationServer.models.interfaces.User;

public class UserLogin implements User {
    private String login;

    public String getLogin() {
        return login;
    }

    public UserLogin(String login) {
        this.login = login;   
    }

    public UserLogin() {
    }
    
    
    
}
