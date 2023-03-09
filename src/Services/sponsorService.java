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
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.evenements;
import Model.reunion;
import Model.sponsors;
import Util.MaConnection;


/**
 *
 * @author ydorr
 */
public class sponsorService implements Interface_IService<sponsors>{

       Connection cnx = MaConnection.getInstance().getCnx();
    @Override
    public void ajouter(sponsors t) {
           try {
            String req = "INSERT INTO `sponsors`(`nom`, `prenom`, `Nom_evenement`, `ID_ev`) VALUES ('"+ t.getNom()+"','"+t.getPrenom()+"','"+t.getNom_Evenement().getNom_ev()+"','"+t.getEv().getID_ev()+"')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println(" Le sponsor est ajouté avec succés ! ");
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimer(int ID) {
         try {
            String req = "DELETE FROM `sponsors` WHERE (`ID_sponsors`='" +ID+ "' )";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println(" Le sponsor est supprimé avec succés ! ");
        } catch (SQLException ex) {
           Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifier(sponsors t) {
          try {
            String req = "UPDATE  sponsors SET `nom`='"+ t.getNom()+"',`prenom`='"+t.getPrenom()+"',`Nom_evenement`='"+t.getNom_Evenement().getNom_ev()+"',`ID_ev`='"+t.getEv().getID_ev()+"' WHERE (`ID_sponsors`='" +t.getID_sponsors()+ "')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("  Le sponsor est modifié avec succés ! ");
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<sponsors> afficher() {
           List<sponsors> li=new ArrayList<>();
        try {
            
            String req="SELECT * FROM sponsors";
            Statement ste = cnx.createStatement();
            ResultSet res=ste.executeQuery(req);
            while(res.next()){
                sponsors s=new sponsors();
                s.setID_sponsors(res.getInt(1));
                s.setNom(res.getString(2));
                s.setPrenom(res.getString(3));
                evenements ev = new evenements();
              
                ev.setNom_ev(res.getString(4));
                ev.setID_ev(res.getInt(5));
               s.setNom_Evenement(ev);
                s.setEv(ev);
                
                li.add(s);
            }
            
            } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
            }
            return (ArrayList<sponsors>)li ;
    
    }

    @Override
    public sponsors readById(int id) {
       sponsors s=new sponsors();
        try {
            
            String req="SELECT * FROM sponsors WHERE `ID_sponsors`='" +id+ "' ";
            Statement ste = cnx.createStatement();
            ResultSet res=ste.executeQuery(req);
            while(res.next()){
                
                s.setID_sponsors(res.getInt(1));
                s.setNom(res.getString(2));
                s.setPrenom(res.getString(3));
                
                evenements ev = new evenements();
              
                ev.setNom_ev(res.getString(4));
                ev.setID_ev(res.getInt(5));
              
                s.setNom_Evenement(ev);
                s.setEv(ev);
             
            }
            
            } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
            }
            return s ;
    
    }

    @Override
    public ArrayList<sponsors> sortBy(String nom_column, String Asc_Dsc) {
          
         List<sponsors> li=new ArrayList<>();
        try {
            
            String req="SELECT * FROM sponsors ORDER BY "+nom_column+" "+Asc_Dsc+" ";
            Statement ste = cnx.createStatement();
            ResultSet res=ste.executeQuery(req);
            while(res.next()){
                sponsors s=new sponsors();
                s.setID_sponsors(res.getInt(1));
                s.setNom(res.getString(2));
                s.setPrenom(res.getString(3));
              evenements ev = new evenements();
              
                ev.setNom_ev(res.getString(4));
                ev.setID_ev(res.getInt(5));
               s.setNom_Evenement(ev);
                s.setEv(ev);
                li.add(s);
            }
            
            } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
            }
            return (ArrayList<sponsors>)li ;
    
    }

   

    @Override
    public sponsors readbyName(String e) {
        sponsors s=new sponsors();
           
              try {
              
            String req="SELECT * FROM sponsors WHERE `nom`='" +e+ "' ";
           
            Statement ste = cnx.createStatement();
            ResultSet res=ste.executeQuery(req);
          
            while(res.next()){
              
                s.setID_sponsors(res.getInt(1));
                s.setNom(res.getString(2));
                s.setPrenom(res.getString(3));
                
                evenements ev = new evenements();
              
                ev.setNom_ev(res.getString(4));
                ev.setID_ev(res.getInt(5));
              
                s.setNom_Evenement(ev);
                s.setEv(ev);
               
               
            }   
            
            }catch (SQLException ex) {  
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex); 
         
            }
     
          return s ; 
    }

//    @Override
//    public ArrayList<sponsors> readbyd(Date d) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public int nbLigne() {
        int nombreDeLignes = 0;
   
     try (
            Statement ste = cnx.createStatement();
             ResultSet resultSet = ste.executeQuery("SELECT COUNT(*) AS nombre_de_lignes FROM sponsors")) {
            resultSet.next();
            nombreDeLignes = resultSet.getInt("nombre_de_lignes");
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
            return nombreDeLignes;
    }

    @Override
    public sponsors readByName(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<sponsors> afficherjointure() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<sponsors> afficherrr() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<sponsors> readBynom(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public reunion readbyd(java.sql.Date d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    }
   
