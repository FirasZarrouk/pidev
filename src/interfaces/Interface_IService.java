
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public interface Interface_IService<T> {
    public void ajouter(T t);
    public void supprimer(int ID);
    public void modifier (T t);
    public List <T> afficher();
    T readById(int id);
    public ArrayList<T> readbyd(Date d);
       public T readbyName(String s);
       public int nbLigne () ;

   
    ArrayList<T> sortBy(String nom_column,String Asc_Dsc);
}