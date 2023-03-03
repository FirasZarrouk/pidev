/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piprojet;

import Interfaces.Interface_IService;
import Model.Equipe;
import Model.Projet;
import Services.ServiceEquipe;
import Services.ServiceProjet;
import Util.MaConnection;

/**
 *
 * @author MSI
 */
public class PiProjet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
            //MaConnection mac=new MaConnection();
        
        //init service
        Interface_IService psP= new ServiceProjet() ;
        Interface_IService psE=new ServiceEquipe();
        
        Equipe E=new Equipe();
//        Projet P=new Projet();
        Projet P=new Projet();
        
            
                //ajout Equipe

        
        //P.setId_Projet(12);
        /*
        E.setNom_Equipe("AAZZZZ");
        E.setDescription("anis");
        E.setMembre("houri mohamed");
        E.setTache("tache de ce projet");
        E.setId_Equipe(10);
        
        P.setNom_Projet("hourianis");
        P.setDescription("projetde AJJAJJJJ");
        P.setTechnologie("HTML");
        P.setDate_creation(java.sql.Date.valueOf("2022-11-12"));
        P.setCategorie("art"); */
        
        //P.setEquipe(E);
        
        //E.setProjet(P);
       //psP.ajouter(P);
        //E.setId_Equipe(6);
        
        //psE.modifier(E);
             //psP.ajouter(P);

//            psP.supprimer(3);
//            P1.setNom_Projet("Projet_PIDEV");
//            P1.setDescription("Description du projet");
//            P1.setTechnologie("Java");
//            P1.setDate_creation(java.sql.Date.valueOf("2022-11-21"));
//            P1.setId_Projet(7);
            
//            psP.modifier(P1);
            
//            psP.supprimer(7);

           //System.out.println(psP.sortBy("Nom_Projet","DESC"));
           System.out.println(psP.readById(27));
           System.out.println(psE.sortBy("Nom_Equipe", "DESC"));
            
            

            
            
//            P1.setNom_Projet("khdiiiija");
//            psE.ajouter(P1);
//            System.out.println(psE.sortBy("Id_equipe", "ASC"));
            
//            System.out.println(psP.readById(2));
        
        
//        Projet P = new Projet();
//        
//        P.setNom_Projet("dorra");
//        P.setDescription("yahia");
//        P.setTechnologie("css");
//        P.setDate_creation(java.sql.Date.valueOf("2011-09-04"));
//        
//        psP.ajouter(P);
        
        //ps.supprimer(1);
        
//        ps.modifier(P);
//       System.out.println(psE.sortBy("Nom_Equipe","ASC"));
    }
    
}
