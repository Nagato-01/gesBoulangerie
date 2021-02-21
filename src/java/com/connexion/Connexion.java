/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.connexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author NALF
 */
public class Connexion {

    private static Connection conex; // c'est une classe qui permet d'effectuer un système de connexion 
    private String url = "jdbc:postgresql://localhost:5432/GesBoulangerie";
    private String user = "postgres";
    private String pwd = "argent";

    Connexion() {
        try {
            Class.forName("org.postgresql.Driver"); //permet d'implermenter ka bd postgres
        } catch (Exception e) {
            System.out.println("erreut de driver !" + e.getMessage());
        }

        try {
            conex = DriverManager.getConnection(url, user, pwd); // implemente le getsionnaire du driver 
        } catch (Exception e) {
            System.out.println("erreur de connexion :" + e.getMessage());
        }
    }

    public static Connection seconnecter() {
        if (conex == null) {
            Connexion connexion = new Connexion();
        }
        return conex;
    }
}
