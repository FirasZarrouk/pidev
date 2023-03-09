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
import Model.Participant;
import Model.User;
import Util.MaConnection;
import Model.evenements;
import Model.reunion;

/**
 *
 * @author ydorr
 */
public class participantServices implements Interface_IService<Participant> {
    Connection cnx = MaConnection.getInstance().getCnx();
    @Override
    public void ajouter(Participant t) {
          try {
            String req = "INSERT INTO `participants`( `nom`, `prenom`, `role`, `nom_event`, `ID_ev`,`id`) VALUES('"+ t.getNom()+"','"+t.getPrenom()+"','"+t.getRole()+"','"+t.getNom_event().getNom_ev()+"','"+t.getEvent().getID_ev()+"','"+t.getId().getId()+"')";
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
            String req = "DELETE FROM `participants` WHERE (`ID_part`='" +ID+ "' )";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println(" Le participant est supprimé avec succés ! ");
        } catch (SQLException ex) {
           Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifier(Participant t) {
        try {
            String req = "UPDATE  `participants` SET `nom`='"+ t.getNom()+"',`prenom`='"+t.getPrenom()+"',`role`='"+t.getRole()+"',`nom_event`='"+t.getNom_event().getNom_ev()+"',`ID_ev`='"+t.getEvent().getID_ev()+"' WHERE (`ID_part`='" +t.getID_part()+ "')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("  Le participant est modifié avec succés ! ");
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Participant> afficher() {
       List<Participant> li=new ArrayList<>();
        try {
            
            String req="SELECT * FROM `participants`";
            Statement ste = cnx.createStatement();
            ResultSet res=ste.executeQuery(req);
            while(res.next()){
                Participant s=new Participant();
                s.setID_part(res.getInt(1));
                s.setNom(res.getString(2));
                s.setPrenom(res.getString(3));
                s.setRole(res.getString(4));
            
                evenements ev = new evenements();
                ev.setNom_ev(res.getString(5));
                ev.setID_ev(res.getInt(6));
                User U = new User();
              U.setId(res.getInt(7));
              s.setId(U);
                s.setNom_event(ev);
                s.setEvent(ev);
                li.add(s);
            }
            
            } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
            }
            return (ArrayList<Participant>)li ;
    
    }

    @Override
    public Participant readById(int id) {
         Participant s=new Participant();
        try {
            
            String req="SELECT * FROM `participants` WHERE `ID_part`='" +id+ "' ";
            Statement ste = cnx.createStatement();
            ResultSet res=ste.executeQuery(req);
            while(res.next()){
                
                s.setID_part(res.getInt(1));
                s.setNom(res.getString(2));
                s.setPrenom(res.getString(3));
                s.setRole(res.getString(4));
                evenements ev = new evenements();
                ev.setNom_ev(res.getString(5));
                ev.setID_ev(res.getInt(6));
                s.setEvent(ev);
                User U = new User();
              U.setId(res.getInt(7));
              s.setId(U);
             
            }
            
            } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
            }
            return s ;
    }

    @Override
    public ArrayList<Participant> sortBy(String nom_column, String Asc_Dsc) {
               List<Participant> li=new ArrayList<>();
        try {
            
            String req="SELECT * FROM `participants` ORDER BY "+nom_column+" "+Asc_Dsc+" ";
            Statement ste = cnx.createStatement();
            ResultSet res=ste.executeQuery(req);
            while(res.next()){
                Participant s=new Participant();
                s.setID_part(res.getInt(1));
                s.setNom(res.getString(2));
                s.setPrenom(res.getString(3));
                 s.setRole(res.getString(4));
                evenements ev = new evenements();
                ev.setNom_ev(res.getString(5));
                ev.setID_ev(res.getInt(6));
                s.setEvent(ev);
                User U = new User();
              U.setId(res.getInt(7));
              s.setId(U);
                li.add(s);
            }
            
            } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
            }
            return (ArrayList<Participant>)li ;
    
    }

   

    @Override
    public Participant readbyName(String s) {
        Participant e=new Participant();
           
              try {
              
            String req="SELECT * FROM `participants` WHERE `nom`='" +s+ "' ";
           
            Statement ste = cnx.createStatement();
            ResultSet res=ste.executeQuery(req);
          
            while(res.next()){
              
                e.setID_part(res.getInt(1));
              
                e.setNom(res.getString(2));
                e.setPrenom(res.getString(3));
                e.setRole(res.getString(4));
                
                  evenements ev = new evenements();
                ev.setNom_ev(res.getString(5));
                ev.setID_ev(res.getInt(6));
            e.setNom_event(ev);
                e.setEvent(ev);
                User U = new User();
              U.setId(res.getInt(7));
              e.setId(U);
               
               
            }   
            
            }catch (SQLException ex) {  
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex); 
         
            }
     
          return e ; 
    }

//    @Override
//    public ArrayList<Participant> readbyd(Date d) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public int nbLigne() {
       int nombreDeLignes = 0;
   
     try (
            Statement ste = cnx.createStatement();
             ResultSet resultSet = ste.executeQuery("SELECT COUNT(*) AS nombre_de_lignes FROM `participants`")) {
            resultSet.next();
            nombreDeLignes = resultSet.getInt("nombre_de_lignes");
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
            return nombreDeLignes;
    }

    @Override
    public Participant readByName(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Participant> afficherjointure() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Participant> afficherrr() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Participant> readBynom(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public reunion readbyd(java.sql.Date d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    public ArrayList<Participant> readbyRole(String s) {
        List<Participant> li=new ArrayList<>();
           
              try {
              
            String req="SELECT * FROM participants WHERE `role`='" +s+ "' ";
           
            Statement ste = cnx.createStatement();
            ResultSet res=ste.executeQuery(req);
          
            while(res.next()){
              Participant e=new Participant();
                e.setID_part(res.getInt(1));
              
                e.setNom(res.getString(2));
                e.setPrenom(res.getString(3));
                e.setRole(res.getString(4));
                
                  evenements ev = new evenements();
                ev.setNom_ev(res.getString(5));
                ev.setID_ev(res.getInt(6));
            e.setNom_event(ev);
                e.setEvent(ev);
                
                
                User U = new User();
              U.setId(res.getInt(7));
              e.setId(U);
                li.add(e);
               
            }   
            
            }catch (SQLException ex) {  
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex); 
         
            }
     
          return (ArrayList<Participant>) li ; 
    }
    }
    
    

