/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kata.main;

/**
 *
 * @author keres
 */
public class Usuario {
    private String id;
    private String full_Name;
    private String email;
    private String nickname;
    private String token;

    public String getId() {
        return id;
    }
  
    public void setId(String id) {
        this.id = id;
    }
    
    public String getToken() {
        return token;
    }
  
    public void setToken(String token) {
        this.token = token;
    }

    public String getFullName() {
        return full_Name;
    }


    public void setFullName(String fullName) {
        this.full_Name = fullName;
    }

 
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    
}
