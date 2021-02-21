/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.connexion.Connexion;
import com.model.Categorie;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;



/**
 *
 * @author NALF
 */

@Path("categorie")

public class Categories {
    @GET
    @Path("showsCategorie")
    @Produces({"application/json"})
    
        public ArrayList<Categorie> howsCategorie()
    {
        ArrayList<Categorie> ListCategorie = new ArrayList<>();
        try{
            Statement etat = com.connexion.Connexion.seconnecter().createStatement();
            ResultSet rs = etat.executeQuery("SELECT* FROM categories") ;
            
            while(rs.next()) {
                Categorie oneCategorie = new Categorie();
                oneCategorie.setIdCategorie(rs.getInt("idcategorie"));
                oneCategorie.setLibelle(rs.getString("libelle"));
                oneCategorie.setStatutCategorie(rs.getBoolean("statutcategorie"));
                
                ListCategorie.add(oneCategorie);
            }
            rs.close();
            etat.close();
        }catch(Exception e){
            System.out.println("erreur de selection" + e.getMessage());
        }
        
        return ListCategorie ;
    } 
        
        /**
   * name: delete categprie
   * @author NALF
   * var 
   */
    @GET
    @Path("/{id}/d")
    public boolean deleteCategorie(@PathParam("id") int id)
    
   {
        try{
             
            Statement etat = Connexion.seconnecter().createStatement();
            
            ResultSet rs;
            
            rs = etat.executeQuery("DELETE FROM categorie WHERE idcategorie=" +id);

            rs.close();
            etat.close();
        }
        catch(Exception e){
            System.out.println("La suppression n'a pas été éffectuée : "+e.getMessage());
        }
        
        return true;
    }
    
    
    //save categorie
    @POST
    @Path("/add")
    @Consumes("application/x-www-form-urlencoded")
    
    public boolean saveCategorie(@FormParam("idcategorie") String idcategorie, @FormParam("libelle") String libelle, @FormParam("statutcategorie") boolean statutcategorie ){
        
        try{
            Statement etat = Connexion.seconnecter().createStatement();
            ResultSet rs;
            
            rs = etat.executeQuery("INSERT INTO categories(idcategorie,libelle,statutcategorie) VALUES ('"+idcategorie+"', '"+libelle+"', '"+statutcategorie+"')");
            
            rs.close();
            etat.close();
        }
        catch(Exception e){
            System.out.println("L'ajout n'a pas été");
        }
        
        return true;
        
    }
    
}
