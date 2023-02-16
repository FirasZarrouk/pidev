
package Interfaces;

import java.util.ArrayList;
import java.util.List;


    
    
    public interface Interface_IService<T> {
    public void ajouter(T t);
    public void supprimer(int ID);
    public void modifier (T t);
    public List <T> afficher();
    T readById(int id);
    ArrayList<T> sortBy(String nom_column,String Asc_Dsc);
    
    

}
    

