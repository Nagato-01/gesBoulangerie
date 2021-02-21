/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.sql.Date;

/**
 *
 * @author NALF
 */

public class Produit {
    private int idProduit;
    private String nomProduit;
    private Date datePeremption;
    private int prix;
    private boolean statutProduit;

    public Produit() {
    }

    public Produit(int idProduit, String nomProduit, Date datePeremption, int prix, boolean statutProduit) {
        this.idProduit = idProduit;
        this.nomProduit = nomProduit;
        this.datePeremption = datePeremption;
        this.prix = prix;
        this.statutProduit = statutProduit;
    }

    public Date getDatePeremption() {
        return datePeremption;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public int getPrix() {
        return prix;
    }
    
    public boolean getStatutProduit() {
        return statutProduit;
    }

    public void setDatePeremption(Date datePeremption) {
        this.datePeremption = datePeremption;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public void setStatutProduit(boolean statutProduit) {
        this.statutProduit = statutProduit;
    }


    
    
    
}
