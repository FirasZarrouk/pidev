/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import Interfaces.Interface_IService;
import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.evenements;
import util.MyConnection;

/**
 *
 * @author ydorr
 */
public class EventService implements Interface_IService<evenements>{

    Connection cnx = MyConnection.getInstance().getCnx();
    @Override
    public void ajouter(evenements t) { 
        
          try {
            String req = "INSERT INTO `evenements`(`date_ev`, `lieu_ev`, `description`, `type_ev`, `nom_ev`) VALUES ('"+ t.getDate_ev()+"','"+t.getLieu_ev()+"','"+t.getDescription()+"','"+t.getType_ev()+"','"+t.getNom_ev()+"')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println(" L'evenement est ajouté avec succés ! ");
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
 
    @Override
    public void supprimer(int ID) {
      try {
            String req = "DELETE FROM evenements WHERE (`ID_ev`='" +ID+ "' )";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println(" L'evenement est supprimé avec succés ! ");
        } catch (SQLException ex) {
           Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifier(evenements t) {
          
          try {
            String req = "UPDATE  evenements SET `date_ev`='"+ t.getDate_ev()+"',`lieu_ev`='"+t.getLieu_ev()+"',`description`='"+t.getDescription()+"',`type_ev`='"+t.getType_ev()+"',`nom_ev`='"+t.getNom_ev()+"' WHERE (`ID_ev`='" +t.getID_ev()+ "' )";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println(" L'evenement est modifié avec succés ! ");
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<evenements> afficher() {
       
         List<evenements> li=new ArrayList<>();
        try {
            
            String req="SELECT * FROM evenements";
            Statement ste = cnx.createStatement();
            ResultSet res=ste.executeQuery(req);
            while(res.next()){
                evenements e=new evenements();
                e.setID_ev(res.getInt(1));
                e.setDate_ev(res.getDate(2));
                e.setLieu_ev(res.getString(3));
                e.setDescription(res.getString(4));
                e.setType_ev(res.getString(5));
                e.setNom_ev(res.getString(6));
                li.add(e);
            }
            
            } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
            }
            return (ArrayList<evenements>)li ;
    
    }

    @Override
    public evenements readById(int id) {
              evenements e=new evenements();
            try {
            
            String req="SELECT * FROM evenements WHERE `ID_ev`='" +id+ "' ";
            Statement ste = cnx.createStatement();
            ResultSet res=ste.executeQuery(req);
            while(res.next()){
              
                e.setID_ev(res.getInt(1));
                e.setDate_ev(res.getDate(2));
                e.setLieu_ev(res.getString(3));
                e.setDescription(res.getString(4));
                e.setType_ev(res.getString(5));
                e.setNom_ev(res.getString(6));
               
            }
            
            } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
            }
        
            return e ; 
        
    }

    @Override
    public ArrayList<evenements> sortBy(String nom_column, String Asc_Dsc) {
        
         List<evenements> li=new ArrayList<>();
        try {
            
            String req="SELECT * FROM evenements ORDER BY "+nom_column+" "+Asc_Dsc+" ";
            Statement ste = cnx.createStatement();
            ResultSet res=ste.executeQuery(req);
            while(res.next()){
                evenements e=new evenements();
                e.setID_ev(res.getInt(1));
                e.setDate_ev(res.getDate(2));
                e.setLieu_ev(res.getString(3));
                e.setDescription(res.getString(4));
                e.setType_ev(res.getString(5));
                e.setNom_ev(res.getString(6));
                li.add(e);
            }
            
            } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
            }
            return (ArrayList<evenements>)li ;
    
    }
    
    
    
}
