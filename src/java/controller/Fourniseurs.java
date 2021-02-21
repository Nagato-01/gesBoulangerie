/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.connexion.Connexion;
import com.model.Fourniseur;
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
@Path("fourniseurs")
public class Fourniseurs {
    
    @GET
    @Path("/showfourniseur")
    @Produces({"application/json"})
    
    public ArrayList<Fourniseur> showFourniseur(){
        ArrayList<Fourniseur> ListFourniseur = new ArrayList<>();
        try{
            Statement etat = com.connexion.Connexion.seconnecter().createStatement();
            ResultSet rs = etat.executeQuery("SELECT* FROM fourniseurs");
            
            System.out.println("test fourniseur");
            
            while(rs.next()){
                Fourniseur oneFourniseur = new Fourniseur();
                
                oneFourniseur.setId_fournisseur(rs.getInt("idfourniseur"));
                oneFourniseur.setNomFournisuer(rs.getString("nom"));
                oneFourniseur.setStatutFourniseur(rs.getBoolean("statutfourniseur"));
                oneFourniseur.setTelFourniseur(rs.getString("tel"));
                
                ListFourniseur.add(oneFourniseur);

            }
            rs.close();
            etat.close();
        }catch(Exception e){
            System.out.println("errreur de selection" + e.getMessage());
        }
        
        return ListFourniseur;
    }  
    
    
    //delete fourniseur
    @GET
    @Path("/{id]/d")

    public boolean deleteFourniseur(@PathParam("id") int id){

        try{
               Statement  etat = Connexion.seconnecter().createStatement();
               ResultSet rs;
               rs = etat.executeQuery("DELETE FROM fourniseurs WHERE idfourniseur=" +id);
                          
               rs.close();
               etat.close();
        }catch(Exception e){
            System.out.println("la suppresion n'a pas été éffectuer:" +e.getMessage());
        }
        
        return true ;
    }
    
    //save fourniseur
    @POST
    @Consumes("application/x-www-form-urlencoded")
    
    public boolean saveProduit(@FormParam("idfourniseur") String idFourniseur, @FormParam("nomFourniseur") String nomFourniseur, @FormParam("telFourniseur") String telFourniseur,  @FormParam("statutFourniseur") boolean statutFourniseur ){
        
        try{
            Statement etat = Connexion.seconnecter().createStatement();
            ResultSet rs;
            
            rs = etat.executeQuery("INSERT INTO fourniseurs(idfourniseur,nom, tel, statutfourniseur) VALUE ('"+idFourniseur+"','"+nomFourniseur+"', '"+telFourniseur+"',  '"+statutFourniseur+"')");
            rs.close();
            etat.close();
        }
        catch(Exception e){
            System.out.println("L'ajout n'a pas été");
        }
        return true;
        
        
    }
    


}

