/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.connexion.Connexion;
import com.model.Produit;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
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
@Path("produits")

public class Produits {
    
    @GET
    @Path("showsProduict")
    @Produces({ "application/json" })
    
    public ArrayList<Produit> howsProduit()
    {
        ArrayList<Produit> ListProduit = new ArrayList<>();
        try{
            Statement etat = com.connexion.Connexion.seconnecter().createStatement();
            ResultSet rs = etat.executeQuery("SELECT* FROM produit") ;
            
            while(rs.next()) {
                Produit oneProduit = new Produit();
                
                oneProduit.setIdProduit(rs.getInt("idcategorie"));
                oneProduit.setIdProduit(rs.getInt("idproduit"));
                oneProduit.setNomProduit(rs.getString("nomproduit"));
                oneProduit.setPrix(rs.getInt("prix"));
                oneProduit.setDatePeremption(rs.getDate("dateperemption", null));
                oneProduit.setStatutProduit(rs.getBoolean("statutproduit"));
                
                ListProduit.add(oneProduit);
            }
            rs.close();
            etat.close();
        }catch(Exception e){
            System.out.println("erreur de selection" + e.getMessage());
        }
        
        return ListProduit ;
    } 
    
    /**
   * name: delete produit
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
    
    
    //save produit
    @POST
    @Path("/add")
    @Consumes("application/x-www-form-urlencoded")
    
    public boolean saveProduit(@FormParam("idcategorie") String idCategorie, @FormParam("nomproduit") String nomproduit, @FormParam("dateperemption") Date datePeramtion, @FormParam("prix") int prix, @FormParam("statutProduit") boolean statutProduit ){
        
        System.out.println("Test de date " + datePeramtion);
        
        try{
            Statement etat = Connexion.seconnecter().createStatement();
            ResultSet rs;
            
            rs = etat.executeQuery("INSERT INTO produit(idcategorie,nomproduit, dateperemption, prix, statutproduit) VALUES ('"+idCategorie+"','"+nomproduit+"', '"+datePeramtion+"', '"+prix+"', '"+statutProduit+"')");
            rs.close();
            etat.close();
        }
        catch(Exception e){
            System.out.println("L'ajout n'a pas été" +e);
        }
        return true;
    }
 }


