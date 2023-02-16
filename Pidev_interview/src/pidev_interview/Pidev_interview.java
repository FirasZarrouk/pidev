/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev_interview;

import models.PV;
import models.rappel;
import models.reunion;
import services.servicePV;
import services.serviceRappel;
import services.serviceReunion;

/**
 *
 * @author afifa
 */
public class Pidev_interview {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Interfaces.Interface_IService in = new serviceReunion (); 
        Interfaces.Interface_IService n = new servicePV (); 
        Interfaces.Interface_IService ni = new serviceRappel ();
      
        reunion R = new reunion();
        //R.setId_reunion(3);
        R.setDate(java.sql.Date.valueOf("2011-06-04"));
        R.setHeure("2:00");
        R.setLocation("lac 4");
        R.setID_investisseur("159");
        R.setID_entrepreneur("123");
        R.setID_projet("147");
        //in.ajouter(R);
        //in.supprimer(2);
        //in.modifier(R);
        //System.out.println(in.afficher());
        //System.out.println(in.readById(3));
        
        PV P = new PV();
        //P.setID_PV(3);
        P.setDate(java.sql.Date.valueOf("2011-06-04"));
        P.setCommentaire("2:00");
        P.setID_investisseur("159pv");
        P.setID_entrepreneur("123pv");
        P.setID_projet("147pvmodifier");
        
        //n.ajouter(P);
        //n.supprimer(1);
        //n.modifier(P);
        //System.out.println(n.afficher());
        //System.out.println(n.readById(4));
        
        
        rappel r = new rappel();
        r.setID_rappel(2);
        r.setDate(java.sql.Date.valueOf("2011-06-04"));
        r.setHeure("2:00");
        r.setReminder("votre reunion est dans 2 jours");
        r.setID_investisseur("159rappel");
        r.setID_entrepreneur("123rappelmodifier");
        
        //ni.ajouter(r);
        //ni.supprimer(1);
        //ni.modifier(r);
        //System.out.println(ni.afficher());
        //System.out.println(ni.readById(2));
        
        
    }
    
}
