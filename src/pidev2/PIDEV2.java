/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev2;

import tn.esprit.services.FormationServices;
//import tn.esprit.services.ParticipationServices;
import tn.esprit.interfaces.Interface_IService;
import tn.esprit.entity.Formation;
//import tn.esprit.entity.Participation;
import tn.esprit.tools.MyConnection;

/**
 *
 * @author ASUS
 */
public class PIDEV2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Interface_IService is= new FormationServices();
        
        Formation F1 = new Formation();
        //Formation F2 = new Formation();
        
        F1.setNom("koaaa");
        F1.setNbreEtapes(3);
        F1.setDescription("tresaa importante");
        F1.setStatut("terminéeaaa");
        is.ajouter(F1);
        
        
        //Participation p = new Participation();
        //p.setIdU(3);
        is.afficher();
        F1.setNom("aaaa");
        F1.setId_formation(4);
        is.modifier(F1);
    }
    
}
