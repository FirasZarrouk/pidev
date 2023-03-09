/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;


import java.sql.Date;
import java.time.LocalDate;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TableColumn;
import models.reunion;


public interface Interface_IService<T> {
    public void ajouter(T t);
    public void supprimer(int ID);
    public void modifier (T t);
    public List <T> afficher();
    public T readById(int id);
    public List <T> readBynom(String nom);
    public reunion readbyd(Date d);

   
    ArrayList<T> sortBy(String nom_column,String Asc_Dsc);

    public boolean sortBy(int i, TableColumn.SortType sortType);
}