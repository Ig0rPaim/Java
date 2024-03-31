package com.auth.authenticationServer.services.tokens.interfaces;

import com.auth.authenticationServer.models.interfaces.User;

public interface TokenService {

    public String generateToken();

    public String validateToken(String token);
}
