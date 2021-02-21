/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

/**
 *
 * @author NALF
 */
public class Utilisateur {
    private int iduser;
    private String login;
    private String mdp;
    private String role;
    private String statuUser;

    public Utilisateur() {
    }

    public int getIduser() {
        return iduser;
    }

    public String getLogin() {
        return login;
    }

    public String getRole() {
        return role;
    }

    public String getStatuUser() {
        return statuUser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setStatuUser(String statuUser) {
        this.statuUser = statuUser;
    }
    
    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
}
