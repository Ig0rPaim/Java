package com.auth.authenticationServer.services.abstractFactorys.implementations;

import org.springframework.beans.factory.annotation.Autowired;

import com.auth.authenticationServer.models.implementacoes.UserLoginPassword;
import com.auth.authenticationServer.models.interfaces.User;
import com.auth.authenticationServer.services.abstractFactorys.interfaces.Af_User_Token;
import com.auth.authenticationServer.services.tokens.implementations.JWTokenLoginPassword;
import com.auth.authenticationServer.services.tokens.interfaces.TokenService;

public class Af_User_JwTokenLoginPassword implements Af_User_Token{
    @Autowired
    private UserLoginPassword user;
    private TokenService jWTokenLoginPassword;

    public Af_User_JwTokenLoginPassword() {
        jWTokenLoginPassword = new JWTokenLoginPassword();
    }

    public Af_User_JwTokenLoginPassword(UserLoginPassword user){
        this.user = user;
        jWTokenLoginPassword = new JWTokenLoginPassword(this.user);
    }

    @Override
    public TokenService getTokenService() {
            return jWTokenLoginPassword;
    }

    @Override
    public UserLoginPassword getUser() {
        return new UserLoginPassword(user.getLogin(), user.getPassword() );
    }

}
