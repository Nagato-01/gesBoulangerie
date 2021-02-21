/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.connexion.Connexion;
import com.model.Utilisateur;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


/**
 *
 * @author NALF
 */

@Path("utilisateurs")

public class Utilisateurs {
    
    @GET
    @Path("/howsUser")
    @Produces({ "application/json" }) 
    
    public ArrayList<Utilisateur> showtUser() throws SQLException{
       ArrayList<Utilisateur> ListUsers = new ArrayList<>();
       try{
            Statement etat = com.connexion.Connexion.seconnecter().createStatement();
            System.out.println("test connexion");
            ResultSet rs = etat.executeQuery("SELECT* FROM utilisateur");  
            
            while (rs.next()) {
                Utilisateur unUser = new Utilisateur();
                
                unUser.setIduser(rs.getInt("idutilisateur"));
                unUser.setLogin(rs.getString("login"));
                unUser.setMdp(rs.getString("mdp")) ;
                unUser.setRole(rs.getString("roles")) ;
                unUser.setStatuUser(rs.getString("statututilisateur")) ;
                
                ListUsers.add(unUser);
            }
                rs.close();
                etat.close();
       }catch(Exception e){
           System.out.println("erreur" + e.getMessage());
       }
      
        return ListUsers;
    }
    
    
/**
 * name: create user
 * @author NALF
 * var 
 */

    @POST
    @Consumes("application/x-www-form-urlencoded") 
    public boolean createUser(@FormParam("login") String login, @FormParam("mdp") String mdp, @FormParam("role") String role, @FormParam("statut") boolean statututilisateur){  

        try{
            Statement etat = Connexion.seconnecter().createStatement();
            ResultSet rs;
            
            rs = etat.executeQuery(" INSERT INTO utilisateur(login, mdp, roles, statututilisateur) VALUES('"+login+"','"+mdp+"', '"+role+"','"+statututilisateur+"')");
            
            rs.close();
            etat.close();
        }
        catch(Exception e){
            
            System.out.println("L'ajout n'a pas été éffectué: "+e.getMessage());            
        }
        
        return true;
    }
    
    
  /**
 * name: create user
 * @author NALF
 * var 
 */
    @GET
    @Path("/{id}/d")
    public boolean deleteUser(@PathParam("id") int id)
    
   {
        try{
             
            Statement etat = Connexion.seconnecter().createStatement();
            
            ResultSet rs;
            
            rs = etat.executeQuery("DELETE FROM utilisateur WHERE idutilisateut=" +id);

            rs.close();
            etat.close();
        }
        catch(Exception e){
            System.out.println("La suppression n'a pas été éffectuée : "+e.getMessage());
        }
        
        return true;
    }
    
}

    