/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;



import java.util.Date;

/**
 *
 * @author ydorr
 */
public class evenements {
    
        private  int ID_ev ; 
        private Date date_ev ;
        private String lieu_ev ; 
        private String description ;
        private String type_ev ;
        private String nom_ev; 

    public evenements(int ID_ev, Date date_ev,  String lieu_ev, String description, String type_ev, String nom_ev) {
        this.ID_ev = ID_ev;
        this.date_ev = date_ev;
   
        this.lieu_ev = lieu_ev;
        this.description = description;
        this.type_ev = type_ev;
        this.nom_ev = nom_ev;
    }

    public evenements() {
    }
    
    

    public int getID_ev() {
        return ID_ev;
    }

    public Date getDate_ev() {
        return date_ev;
    }

  

    public String getLieu_ev() {
        return lieu_ev;
    }

    public String getDescription() {
        return description;
    }

    public String getType_ev() {
        return type_ev;
    }

    public String getNom_ev() {
        return nom_ev;
    }

    public void setID_ev(int ID_ev) {
        this.ID_ev = ID_ev;
    }

    public void setDate_ev(Date date_ev) {
        this.date_ev = date_ev;
    }

   

    public void setLieu_ev(String lieu_ev) {
        this.lieu_ev = lieu_ev;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType_ev(String type_ev) {
        this.type_ev = type_ev;
    }

    public void setNom_ev(String nom_ev) {
        this.nom_ev = nom_ev;
    }

    @Override
    public String toString() {
        return "evenements{" + "ID_ev=" + ID_ev + ", date_ev=" + date_ev + ", lieu_ev=" + lieu_ev + ", description=" + description + ", type_ev=" + type_ev + ", nom_ev=" + nom_ev + '}';
    }
        
        
        
    
}
