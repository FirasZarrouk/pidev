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
        R.setId_reunion(10);
        R.setNom("nomm");
        R.setPrenom("prenomm");
        R.setEntreprise("entreprisem");
        R.setDate(java.sql.Date.valueOf("2023-06-04"));
        R.setHeure("2:00m");
        R.setLieu( "premiere validationm");
        R.setContact("contactm");
        R.setID_investisseur("159m");
        R.setID_entrepreneur("123m");
        R.setID_projet("147m");
        
        //in.ajouter(R);
        //in.supprimer(9);
        //in.modifier(R);
        //System.out.println(in.afficher());
        //System.out.println(in.readById(6));
        //System.out.println(in.sortBy("id_reunion", "Desc"));
        
       
        PV P = new PV();
        P.setID_PV(7);
        P.setNom("nom");
        P.setPrenom("prenom");
        P.setDate(java.sql.Date.valueOf("2011-06-04"));
        P.setCommentaire("2:00m");
        P.setID_investisseur("159pvm");
        P.setID_entrepreneur("123pvm");
        P.setID_projet("147pvmodifierm");
        reunion Ri = new reunion();
        Ri.setId_reunion(11);
        P.setId_reunion(Ri);
        
        
        //n.ajouter(P);
        //n.supprimer(6);
        //n.modifier(P);
        //System.out.println(n.afficher());
        //System.out.println(n.readById(7));
    
        
        
        rappel r = new rappel();
        //r.setID_rappel(2);
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
