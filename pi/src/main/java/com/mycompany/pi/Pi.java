/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.pi;
import Interface.Interface_IService;
import Util.Maconnexion;
import model.Pack;
import service.servicePack;

/**
 *
 * @author LENOVO
 */
public class Pi {

    public static void main(String[] args) {
      //Maconnexion mac=new Maconnexion();
      
      //int_service
      Interface_IService ps= new servicePack ();
      
      //init  un pack
      Pack P = new Pack();
      P.setNomPack("kadija");
      P.setCategorie("premium");
      P.setTarif(2.1f);
      
       //ajouter pack
      // ps.ajouter(P);
       
       
       //Pack P1 = new Pack();
      // P1.setNomPack("anis");
      //P1.setCategorie("gold");
      //P1.setTarif(2.1f);
     // ps.ajouter(P1);
      
       //supprimer
   
      // ps.supprimer(2);
      
      //modifier 
      //P1.setNomPack("ayoub");
      //P1.setCategorie("silver");
      //P1.setTarif(2.3f);
      //P1.setID_Pack(3);
      //ps.modifier(P1);
        //System.out.println(ps.sortBy("tarif", "DESC"));
      
      
      
    }
}
