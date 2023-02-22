/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev1;
import Interface.Interface_IService;
import Util.Maconnexion;
import model.Pack;
import model.rapport_financier;
import service.servicePack;
import model.transaction;
import service.servicerapportfinancier;
import service.servicetransaction;


/**
 *
 * @author LENOVO
 */
public class Pidev1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       // Maconnexion mac=new Maconnexion();
      
      //int_service
      Interface_IService ps= new servicePack ();
            Interface_IService pst= new servicetransaction ();
                        Interface_IService psr= new servicerapportfinancier ();
                        
                        //CRUD PACK 
//              Pack p = new Pack();
//              p.setNomPack("premium");
//              p.setCategorie("bronze");
//              p.setTarif(16.5f);
//              //ps.ajouter(p);
////              //System.out.println(ps.readById(6));
//              p.setID_Pack(14);
//             ps.modifier(p);
           //ps.supprimer(7);
           
           
           //CRUD TRANSACTION
           transaction tr = new transaction();
           tr.setDate_trans(java.sql.Date.valueOf("2023-11-12"));
           tr.setMontant(253.51f);
           tr.setType_trans("virementttttttjgvhjhbtt");
           //pst.ajouter(tr);
           tr.setID_trans(6);
          //pst.modifier(tr);
//           //System.out.println(pst.afficher());


             //CRUD RAPPORT FINANCIER
            rapport_financier r = new rapport_financier();
            
            r.setDate_rap(java.sql.Date.valueOf("2023-11-12"));
            r.setType_rap("Bilan annuelllllllllllllll111");
            r.setRevenus(50000000.1f);
            r.setDepences(400.1f);
            r.setTransaction(tr);
            //psr.ajouter(r);
            r.setID_rap(10);
           // psr.modifier(r);
           // System.out.println(psr.afficher());
   //System.out.println(psr.sortBy("ID_rap", "DESC"));

            


    }
    
}
