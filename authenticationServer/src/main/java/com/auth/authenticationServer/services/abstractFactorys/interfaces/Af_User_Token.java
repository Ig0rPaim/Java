package com.auth.authenticationServer.services.abstractFactorys.interfaces;

import com.auth.authenticationServer.models.interfaces.User;
import com.auth.authenticationServer.services.tokens.interfaces.TokenService;

public interface Af_User_Token {
    public User getUser();
    public TokenService getTokenService();
}
