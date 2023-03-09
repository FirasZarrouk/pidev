
package Interfaces;

import Model.reunion;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


    
    
    public interface Interface_IService<T> {
    public void ajouter(T t);
    public void supprimer(int ID);
    public void modifier (T t);
    public List <T> afficher();
    public T readById(int id);
    T readByName(String nom);
    ArrayList<T> sortBy(String nom_column,String Asc_Dsc);
    public List<T> afficherjointure();
    public List<T> afficherrr();
    public List<T> readBynom(String nom);
    public reunion readbyd(Date d);
    
    //public ArrayList<T> readbyd(Date d);
    public T readbyName(String s);
    public int nbLigne();
    
    
    
    
    
    
    
    
    

}
    

