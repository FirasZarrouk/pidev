/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tn.esprit.entity;

/**
 *
 * @author ASUS
 */
public class Formation {
     private int id_formation, nbreEtapes;
    private String Nom, Description, statut;

    public Formation() {
    }

    
    public Formation(int id_formation, String Nom, int nbreEtapes, String Description, String statut) {
        this.id_formation = id_formation;
        this.Nom = Nom;
        this.nbreEtapes = nbreEtapes;
        this.Description = Description;
        this.statut = statut;
    }
     public Formation(String Nom, int nbreEtapes, String Description, String statut) {
       
        this.Nom = Nom;
        this.nbreEtapes = nbreEtapes;
        this.Description = Description;
        this.statut = statut;
    }

    public int getId_formation() {
        return id_formation;
    }

    public void setId_formation(int id_formation) {
        this.id_formation = id_formation;
    }

    public int getNbreEtapes() {
        return nbreEtapes;
    }

    public void setNbreEtapes(int nbreEtapes) {
        this.nbreEtapes = nbreEtapes;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "Formation{" + "id=" + id_formation + ", Nom=" + Nom + ", nbreEtapes=" + nbreEtapes + ", Description=" + Description + ", statut=" + statut + '}';
    }


   
    
    
}
