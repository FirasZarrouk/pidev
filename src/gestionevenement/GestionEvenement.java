/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionevenement;

import models.sponsors;
import models.evenements;
import models.Participant;
import services.EventService;
import services.sponsorService;
import services.participantServices;
import java.util.Date;
import models.Participant;

/**
 *
 * @author ydorr
 */
public class GestionEvenement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Interfaces.Interface_IService in = new EventService (); 
      
        evenements e = new evenements();
       e.setID_ev(3);
        e.setDate_ev(java.sql.Date.valueOf("2011-05-06"));
        e.setLieu_ev("Menzah 7 ");
        e.setDescription("evenement de formations");
       e.setType_ev("formations");
       e.setNom_ev("Event infinity");
//        
        
         //in.ajouter(e);
      //  in.supprimer(3);
       // in.modifier(e);
      //  System.out.println(in.afficher());
      //  System.out.println(in.readById(3));
       // System.out.println(  in.sortBy("ID_ev", "ASC"));
        Interfaces.Interface_IService i = new sponsorService (); 
        sponsors s = new sponsors();
        s.setID_sponsors(1);
        s.setNom("Ben Yahia");
        s.setPrenom("Dorra");
        s.setEv(e);
        
        //i.ajouter(s);
       // i.supprimer(2);
      // i.modifier(s);
      //System.out.println(i.afficher());
     // System.out.println(i.readById(1));
        //System.out.println(  i.sortBy("ID_sponsors", "ASC"));
//        
        Interfaces.Interface_IService ip = new services.participantServices (); 
          Participant p = new Participant();
          p.setID_part(2);
          p.setNom("aaa");
          p.setPrenom("bbb");
         p.setRole("inves");
        p.setNom_event(e);
         p.setEvent(e);
     // ip.ajouter(p);
    // ip.supprimer(1);
    //ip.modifier(p);
   //System.out.println(ip.afficher());
     //System.out.println(ip.readById(2));
     //System.out.println(  ip.sortBy("ID_part", "Desc"));
         
        
    }
    
}
