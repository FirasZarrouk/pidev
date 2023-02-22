/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author ydorr
 */
public class sponsors {
    
            private   int  ID_sponsors ;
            private  String nom ;
            private String prenom ; 
            private  evenements   ev ; 

    public sponsors() {
    }

    public sponsors(int ID_sponsors, String nom, String prenom, evenements ev) {
        this.ID_sponsors = ID_sponsors;
        this.nom = nom;
        this.prenom = prenom;
        this.ev = ev;

    }

    public int getID_sponsors() {
        return ID_sponsors;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public evenements getEv() {
        return ev;
    }

    public void setID_sponsors(int ID_sponsors) {
        this.ID_sponsors = ID_sponsors;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEv(evenements ev) {
        this.ev = ev;
    }

    @Override
    public String toString() {
        return "sponsors{" + "ID_sponsors=" + ID_sponsors + ", nom=" + nom + ", prenom=" + prenom + ", ev=" + ev + '}';
    }
         
    
}
