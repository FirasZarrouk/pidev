/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pidev;

import interfaces.Interface_IService;
import java.sql.Date;
import models.User;
import models.Wallet;
import services.UserService;

/**
 *
 * @author Firas
 */
public class JavaMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         Interface_IService ui= new UserService() ;
          User u = new User("zaroukk", "zarrouk", new Date(1920), "zarrou.firas@gamil.com", "firas123", 99887755, "Ariana", "investiseur");
          Wallet w = new Wallet (u,2222222,"monjeya",new Date (2222));
          User u2 = new User("ben hamouda","aziz", new Date(1999),"aziz@gmail.com","monji",73827846,"sokra","entrepreneur");
           
          
          //ui.ajouter(u2);
          //ui.afficher();
          
          //
          //ui.ajouter(w);
          //u.setNom("azouz");
          //System.out.println(u);
          //ui.modifier(u);
          //System.out.println(ui.afficher());;
                  
          //ui.afficher("1");
          
          // read by id
          
          System.out.println(ui.readById(10));
          
          System.out.println(ui.sortBy("tel", "asc"));
      }
    }