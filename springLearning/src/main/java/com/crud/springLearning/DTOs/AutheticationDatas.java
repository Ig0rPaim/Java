package com.crud.springLearning.DTOs;

public record AutheticationDatas(String login, String password) {
    public AutheticationDatas(String login, String password){
        this.login = login;
        this.password = password;
    }
}
