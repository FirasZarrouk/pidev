/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import Interfaces.Interface_IService;

import java.sql.Connection;
//import java.sql.Date;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.time.LocalDate;
//import java.time.ZoneId;
//import java.time.temporal.ChronoUnit;
//import javax.mail.*;
//import javax.mail.internet.*;
//import java.util.*;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import Model.evenements;
import Model.reunion;
import Util.MaConnection;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
/**
 *
 * @author ydorr
 */
public class EventService implements Interface_IService<evenements>{

    Connection cnx = MaConnection.getInstance().getCnx();
    @Override
    public void ajouter(evenements t) { 
        
          try {
            String req = "INSERT INTO `evenements`(`date_ev`, `lieu_ev`, `description`, `type_ev`, `nom_ev`,`Tarif_Ev`) VALUES ('"+ t.getDate_ev()+"','"+t.getLieu_ev()+"','"+t.getDescription()+"','"+t.getType_ev()+"','"+t.getNom_ev()+"','"+t.getTarif_Ev()+"')";
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
            String req = "UPDATE  evenements SET `date_ev`='"+ t.getDate_ev()+"',`lieu_ev`='"+t.getLieu_ev()+"',`description`='"+t.getDescription()+"',`type_ev`='"+t.getType_ev()+"',`nom_ev`='"+t.getNom_ev()+"',`Tarif_Ev`='"+t.getTarif_Ev()+"' WHERE (`ID_ev`='" +t.getID_ev()+ "' )";
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
                e.setTarif_Ev(res.getString(7));
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
                  e.setTarif_Ev(res.getString(7));
               
            }   
            
            }catch (SQLException ex) {  
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
                 e.setTarif_Ev(res.getString(7));
                li.add(e);
            }
            
            } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
            }
            return (ArrayList<evenements>)li ;
    
    }
    
    
  
    
//    public static long joursRestants(evenements evenement) {
//        Date dateActuelle = new Date();
//        long diffEnMillisecondes = evenement.getDate_ev().getTime() - dateActuelle.getTime();
//        long diffEnJours = diffEnMillisecondes / (24 * 60 * 60 * 1000);
//        return diffEnJours;
//    }
//    

//    @Override
//    public ArrayList<evenements> readbyd(Date d) {
//          
//           List<evenements> li=new ArrayList<>();
//              try {
//              
//            String req="SELECT * FROM evenements WHERE `date_ev`='" +d+ "' ";
//           
//            Statement ste = cnx.createStatement();
//            ResultSet res=ste.executeQuery(req);
//          
//            while(res.next()){
//               evenements e=new evenements();
//                e.setID_ev(res.getInt(1));
//                e.setDate_ev(res.getDate(2));
//                e.setLieu_ev(res.getString(3));
//                e.setDescription(res.getString(4));
//                e.setType_ev(res.getString(5));
//                e.setNom_ev(res.getString(6));
//                  e.setTarif_Ev(res.getString(7));
//                li.add(e);
//            }   
//            
//            }catch (SQLException ex) {  
//            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex); 
//         
//            }
//     
//          return (ArrayList<evenements>)li ; 
//    }

    @Override
    public evenements readbyName(String s) {
           evenements e=new evenements();
           
              try {
              
            String req="SELECT * FROM evenements WHERE `nom_ev`='" +s+ "' ";
           
            Statement ste = cnx.createStatement();
            ResultSet res=ste.executeQuery(req);
          
            while(res.next()){
              
                e.setID_ev(res.getInt(1));
                e.setDate_ev(res.getDate(2));
                e.setLieu_ev(res.getString(3));
                e.setDescription(res.getString(4));
                e.setType_ev(res.getString(5));
                e.setNom_ev(res.getString(6));
                  e.setTarif_Ev(res.getString(7));
               
            }   
            
            }catch (SQLException ex) {  
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex); 
         
            }
     
          return e ; 
    }

    @Override
    public int nbLigne() {
        int nombreDeLignes = 0;
   
     try (
            Statement ste = cnx.createStatement();
             ResultSet resultSet = ste.executeQuery("SELECT COUNT(*) AS nombre_de_lignes FROM evenements")) {
            resultSet.next();
            nombreDeLignes = resultSet.getInt("nombre_de_lignes");
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
            return nombreDeLignes;
    }

   

   public void evoyerEmailToParticipantWhenEventDeleted(String email, evenements e){
      Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("yousseffarhat818@gmail.com", "cerbtzsaklmkfbde");
            }
        });
     
        
         try {
            // Création de l'objet Message
            Message message = new MimeMessage(session);
            // from 
            message.setFrom(new InternetAddress("yousseffarhat818@gmail.com"));
            // Recipients
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            // Objet de l'email
            message.setSubject("Abrogation de l'événement ! ") ;
            Multipart emailContent = new MimeMultipart();

            // creer la parite message de l'email
            MimeBodyPart emailTextContent = new MimeBodyPart();
            
                emailTextContent.setText("Bonjour,\n"
                        + "\n"
                        + "Nous sommes au regret de vous informer que l'événement que nous avions prévu pour le "+e.getDate_ev()+" est annulé.\n"
                        + "\n"
                        + "Cette décision n'a pas été prise à la légère, mais nous avons dû la prendre pour des raisons indépendantes de notre volonté. Nous comprenons que cela peut causer des désagréments, mais nous espérons que vous comprendrez que la situation est hors de notre contrôle.\n"
                        + "\n"
                        + "Nous sommes désolés pour toute gêne occasionnée et nous vous remercions de votre compréhension.\n"
                        + "\n"
                        +"Si vous avez des questions ou des préoccupations, n'hésitez pas à nous contacter ."
                        + "Cordialement,\n"
                        + "\n"
                        + "L'équipe DEPPANINI.");
               emailContent.addBodyPart(emailTextContent);
                    message.setContent(emailContent);
                    // Envoie l'email
                    System.out.println("----------------------------------");
                    Transport.send(message); 
    }

    

         catch (MessagingException e1) {
            System.out.println(e1.getMessage());
        }
    }
//    public void evoyerEmailToParticipantWhenEventpostponed(String email, Event event) throws AddressException, MessagingException{
//        Properties props = new Properties();
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.port", "587");
//        Session session = Session.getInstance(props,
//                new javax.mail.Authenticator() {
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication("yousseffarhat818@gmail.com", "cerbtzsaklmkfbde");
//            }
//        });
//         try {
//            // Création de l'objet Message
//            Message message = new MimeMessage(session);
//            // from 
//            message.setFrom(new InternetAddress("yousseffarhat818@gmail.com"));
//            // Recipients
//            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
//            // Objet de l'email
//            message.setSubject("Abrogation de l'événement ! ") ;
//            Multipart emailContent = new MimeMultipart();
//
//            // creer la parite message de l'email
//            MimeBodyPart emailTextContent = new MimeBodyPart();
//            
//                emailTextContent.setText("Bonjour,\n"
//                        + "\n"
//                        + "Nous souhaitons vous informer que la date de l'événement "+event.getNomEvent()+" a été modifiée. L'événement aura lieu le "+event.getDateDabEvent()+".\n"
//                        + "\n"
//                        + "Nous espérons que vous pourrez toujours assister à l'événement à la nouvelle date. Si vous ne pouvez pas être présent, nous vous prions de bien vouloir nous en informer afin que nous puissions mettre à jour notre liste des participants.\n"
//                        + "\n"
//                        + "Nous sommes conscients que ce changement de date peut causer des désagréments, mais nous sommes convaincus que la nouvelle date permettra à tous les participants de profiter pleinement de l'événement.\n"
//                        + "\n"
//                        +"Si vous avez des questions ou des préoccupations, n'hésitez pas à nous contacter ."
//                        + "Cordialement,\n"
//                        + "\n"
//                        + "L'équipe DEPPANINI.");
//                
//                 emailContent.addBodyPart(emailTextContent);
//                    message.setContent(emailContent);
//                    // Envoie l'email
//                    Transport.send(message); 
//    }
//
//    
//
//         catch (MessagingException e) {
//            System.out.println(e.getMessage());
//        }

    @Override
    public evenements readByName(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<evenements> afficherjointure() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<evenements> afficherrr() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<evenements> readBynom(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public reunion readbyd(java.sql.Date d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }
   

    
    

       

    
