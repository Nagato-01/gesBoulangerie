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
public class Fourniseur {
    
    public int id_fournisseur;
    public String nomFournisuer;
    public String telFourniseur;
    public boolean statutFourniseur;

    public Fourniseur() {
    }

    public int getId_fournisseur() {
        return id_fournisseur;
    }

    public String getNomFournisuer() {
        return nomFournisuer;
    }

    public String getTelFourniseur() {
        return telFourniseur;
    }
    
    public boolean getStatutFourniseur(){
        return statutFourniseur;
    }

    public void setId_fournisseur(int id_fournisseur) {
        this.id_fournisseur = id_fournisseur;
    }

    public void setNomFournisuer(String nomFournisuer) {
        this.nomFournisuer = nomFournisuer;
    }

    public void setStatutFourniseur(boolean statutFourniseur) {
        this.statutFourniseur = statutFourniseur;
    }

    public void setTelFourniseur(String telFourniseur) {
        this.telFourniseur = telFourniseur;
    }
    
    
}
