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
public class Participant {
    private int ID_part; 
    private String nom; 
    private String prenom  ;
    private String role ;
    private evenements nom_event ;
    private  evenements event ;
    

    public Participant() {
    }

    public Participant(int ID_part, String nom, String prenom, String role, evenements nom_event, evenements event) {
        this.ID_part = ID_part;
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
        this.nom_event = nom_event;
        this.event = event;
    }

    public int getID_part() {
        return ID_part;
    }

    public evenements getNom_event() {
        return nom_event;
    }

   
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getRole() {
        return role;
    }

    public evenements getEvent() {
        return event;
    }

    public void setID_part(int ID_part) {
        this.ID_part = ID_part;
    }

    public void setNom_event(evenements nom_event) {
        this.nom_event = nom_event;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setEvent(evenements event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "Participant{" + "ID_part=" + ID_part + ", nom=" + nom + ", prenom=" + prenom + ", role=" + role + ", nom_event=" + nom_event + ", event=" + event + '}';
    }

    
    
    
    
}
