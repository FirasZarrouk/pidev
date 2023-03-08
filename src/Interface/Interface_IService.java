/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;
import java.util.ArrayList;
import java.util.List;
import model.Pack;
import model.rapport_financier;

/**
 *
 * @author LENOVO
 */
public interface Interface_IService<T> {
     public void ajouter(T t);
    public void supprimer(int ID);
    public void modifier (T t);
    public List <T> afficher();
    T readById(int id);
   
    public List <T> afficherrr();
    public List <T> afficherjointure();
    ArrayList<T> sortBy(String nom_column,String Asc_Dsc);

   
}
