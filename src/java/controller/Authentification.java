/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.model.Utilisateur;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author NALF
 */
 @Path("/login")

public class Authentification {
    @POST
    @Path("/authentification")
    @Produces({ "application/json" }) 
    @Consumes("application/x-www-form-urlencoded") 

    
    public ArrayList<Utilisateur> logUser(@FormParam("login") String login, @FormParam("mdp") String mdp) throws SQLException{
        
       ArrayList<Utilisateur> testUsers = new ArrayList<>();
       try{
            Statement etat = com.connexion.Connexion.seconnecter().createStatement();
            ResultSet rs = etat.executeQuery("SELECT * FROM utilisateur WHERE login = '"+login+"' AND mdp = '"+mdp+"' "); 

            while (rs.next()) {
                Utilisateur unUser = new Utilisateur();
                
                unUser.setIduser(rs.getInt("idutilisateur"));
                unUser.setLogin(rs.getString("login"));
                unUser.setMdp(rs.getString("mdp")) ;
                unUser.setRole(rs.getString("role")) ;
                unUser.setStatuUser(rs.getString("statuutilisateur")) ;
                
                testUsers.add(unUser);
            }
                rs.close();
                etat.close();
       }catch(Exception e){
           System.out.println("erreur" + e.getMessage());
       }
      
        return testUsers;
      
    }

}
