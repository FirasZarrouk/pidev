/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev1;
import Interface.Interface_IService;
import Util.Maconnexion;
import model.Pack;
import model.Wallet;
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
           transaction tr1 = new transaction();
           tr1.setDate_trans(java.sql.Date.valueOf("2023-11-12"));
           tr1.setMontant(253f);
           tr1.setType_trans("Transaction de revenus");
          
           //pst.ajouter(tr1);
          tr1.setID_trans(33);
      //    pst.modifier(tr1);
//           //System.out.println(pst.afficher());


             //CRUD RAPPORT FINANCIER
            rapport_financier r3 = new rapport_financier();
            
            r3.setDate_rap(java.sql.Date.valueOf("2023-03-05"));
            r3.setDate_debut_T(java.sql.Date.valueOf("2023-02-01"));
            //r2.setDate_rap(new java.sql.Date(System.currentTimeMillis()));

            r3.setType_rap("Bilan mensuel");
         //  psr.ajouter(r3);
//           psr.ajouter1(r3);
            
           // r.setRevenus(50000000.1f);
           // r.setDepences(400.1f);
          //  r2.setTransaction(tr);
            //psr.ajouter(r2);
           // r1.setID_rap(10);
           // psr.modifier(r);
           // System.out.println(psr.afficher());
   //System.out.println(psr.sortBy("ID_rap", "DESC"));

            


    }
    
}
