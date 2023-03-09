/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev_reunion;

import models.PV;
import models.rappel;
import models.reunion;
import services.servicePV;
import services.serviceRappel;
import services.serviceReunion;
import services.Example;

/**
 *
 * @author afifa
 */
public class Pidev_reunion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Interfaces.Interface_IService ni = new serviceRappel ();
        Interfaces.Interface_IService n = new servicePV ();
        Interfaces.Interface_IService in = new serviceReunion (); 
        
        
        
        reunion R = new reunion();
        R.setId_reunion(33);
        R.setDateReunion(java.sql.Date.valueOf("2026-02-02"));
        R.setHeureReunion("2:00m");
        R.setLieuReunion("premiere validationm");
        R.setContactReunion("contactm");
        R.setValider("non validée");
        R.setID_investisseur(159);
        R.setID_projet(147);
        
        //in.ajouter(R);
        //in.supprimer(16);
        //in.modifier(R);
        //System.out.println(in.afficher());
        //System.out.println(in.readById(6));
        //System.out.println(in.sortBy("id_reunion", "Desc"));
        //System.out.println(in.readbyd(R.getDate()));
        
       
        PV P = new PV();
        P.setID_PV(7);
        P.setDatePV(java.sql.Date.valueOf("2011-06-04"));
        P.setCommentaire("2:00m");
        reunion Ri = new reunion();
        Ri.setId_reunion(11);
        P.setId_reunion(Ri);
        
        
        //n.ajouter(P);
        //n.supprimer(32);
        //n.modifier(P);
        //System.out.println(n.afficher());
        //System.out.println(n.readById(nom));
    
        
        
        rappel r = new rappel();
        //r.setID_rappel(2);
        r.setDateRappel(java.sql.Date.valueOf("2011-06-04"));
        r.setHeureRappel("2:00");
        r.setReminder("votre reunion est dans 2 jours");
        r.setEmail_investisseur("159rappel");
        r.setEmail_entrepreneur("123rappelmodifier"); 
        
        //ni.ajouter(r);
        //ni.supprimer(1);
        //ni.modifier(r);
        //System.out.println(ni.afficher());
        //System.out.println(ni.readById(2));
        
        
        
    }
    
}
