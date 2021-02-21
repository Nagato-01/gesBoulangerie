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
public class Categorie {
    public  int idCategorie;
    public  String libelle ;
    public boolean  statutCategorie ;

    public Categorie() {
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public String getLibelle() {
        return libelle;
    }

    public boolean getStatutCategorie() {
        return statutCategorie;
    }
    
    
    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setStatutCategorie(boolean statutCategorie) {
        this.statutCategorie = statutCategorie;
    }
    
    
    
}
