/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kata.main.Chat;


public class Chat {
    private String _id;
    private String name;
    private boolean duo;
    private Member[] members;

    public void setId(String _id) {
        this._id = _id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDuo(boolean duo) {
        this.duo = duo;
    }

    public void setMembers(Member[] members) {
        this.members = members;
    }

    public String getId() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public boolean isDuo() {
        return duo;
    }

    public Member[] getMembers() {
        return members;
    }
    
    
    
}
