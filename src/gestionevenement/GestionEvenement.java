/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionevenement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import models.sponsors;
import models.evenements;
import models.Participant;
import services.EventService;
import services.sponsorService;
import services.participantServices;
import java.util.Date;
import javax.swing.JOptionPane;
import models.Participant;

/**
 *
 * @author ydorr
 */
public class GestionEvenement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        Interfaces.Interface_IService in = new EventService (); 
      EventService es = new EventService();
        evenements e = new evenements();
       e.setID_ev(7);
        e.setDate_ev(java.sql.Date.valueOf("2023-03-04"));
        e.setLieu_ev("Menzah 7 ");
        e.setDescription("evenement de formations");
       e.setType_ev("formations");
       e.setNom_ev("Event infinity");
       e.setTarif_Ev("30Dt000");
      
      

       
        // in.ajouter(e);
      //  in.supprimer(3); 
        //in.modifier(e);
        //System.out.println(in.afficher());
       //System.out.println(in.readById(15));
       //System.out.println(in.readbyd(e.getDate_ev()));
       // System.out.println(in.nbLigne());
       //System.out.println(in.readbyName(e.getNom_ev()));
        //System.out.println(  in.sortBy("Tarif_Ev", "DESC"));
        Interfaces.Interface_IService i = new sponsorService (); 
        sponsors s = new sponsors();
       s.setID_sponsors(1);
        s.setNom("Yahia");
        s.setPrenom("Dorra");
        s.setEv(e);
        s.setNom_Evenement(e);
        //i.ajouter(s);
    //    i.supprimer(4);
      // i.modifier(s);
      //System.out.println(i.afficher());
     // System.out.println(i.readbyName("aa"));
        //System.out.println(  i.sortBy("ID_sponsors", "ASC"));
//        
        Interfaces.Interface_IService ip = new services.participantServices (); 
          Participant p = new Participant();
          p.setID_part(2);
          p.setNom("doi");
          p.setPrenom("etre");
         p.setRole("inves");
        p.setNom_event(e);
         p.setEvent(e);
        // System.out.println(ip.nbLigne());
    // ip.ajouter(p);
    // ip.supprimer(1);
    //ip.modifier(p);
   //System.out.println(ip.afficher());
     //System.out.println(ip.readbyName("dorra"));
     //System.out.println(  ip.sortBy("ID_part", "Desc"));
         
        
     
     
//     
//         LocalDate  eventDate = e.getDate_ev().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//        
//        // Calcul du nombre de jours restants
//        int daysUntilEvent = getDaysUntilEvent(eventDate);
//        
//        // Affichage du résultat dans le Label
//        if (daysUntilEvent > 0) {
//            System.out.println("Il reste " + daysUntilEvent + " jours avant la date de l'événement");
//        } else if (daysUntilEvent == 0) {
//            System.out.println("L'événement a lieu aujourd'hui !");
//        } else {
//            System.out.println("L'événement est déjà passé depuis " + Math.abs(daysUntilEvent) + " jours");
//        }
//    }
//    
//    private int getDaysUntilEvent(LocalDate eventDate) {
//        LocalDate currentDate = LocalDate.now();
//        return (int) ChronoUnit.DAYS.between(currentDate, eventDate);
//    }
//
//     
//     
     
    }
    
}
