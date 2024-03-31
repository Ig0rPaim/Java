package com.auth.authenticationServer.services.abstractFactorys.implementations;

import org.springframework.beans.factory.annotation.Autowired;

import com.auth.authenticationServer.models.implementacoes.UserLogin;
import com.auth.authenticationServer.models.interfaces.User;
import com.auth.authenticationServer.services.abstractFactorys.interfaces.Af_User_Token;
import com.auth.authenticationServer.services.tokens.implementations.JWTokenLogin;
import com.auth.authenticationServer.services.tokens.interfaces.TokenService;

public class Af_User_JwTokenLogin implements Af_User_Token{
    @Autowired
    private UserLogin user;
    private TokenService jWTokenLogin;

    
    public Af_User_JwTokenLogin() {
        jWTokenLogin = new JWTokenLogin();
    }

    public Af_User_JwTokenLogin(UserLogin user){
        this.user = user;
        jWTokenLogin = new JWTokenLogin(user);
    }

    @Override
    public TokenService getTokenService() {
            return jWTokenLogin;
    }

    @Override
    public User getUser() {
        return new UserLogin(user.getLogin());
    }

}
