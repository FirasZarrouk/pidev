/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class Formation {
    private int id_formation;
    private String titre;
    private String lien;
    private String imageSrc;
    private String description;
    private String categorie;
    private int nbrPlaces;
    private float prix;

    public Formation() {
    }
    
    
    
    public Formation(int id_formation, String titre,String lien,String imageSrc, String description, String categorie,  int nbrPlaces, float prix) {
        this.id_formation = id_formation;
        this.titre = titre;
        this.lien=lien;
        this.imageSrc=imageSrc;
        this.description = description;
        this.categorie = categorie;
        this.nbrPlaces = nbrPlaces;
        this.prix = prix;
    }

    public Formation(String titre,String lien,String imageSrc, String description, String categorie, int nbrPlaces, float prix) {
        this.titre = titre;
        this.description = description;
        this.lien=lien;
        this.imageSrc=imageSrc;
        this.categorie = categorie;
        this.nbrPlaces = nbrPlaces;
        this.prix = prix;
    }

 
    // Getters and setters for all attributes
    
    public int getId_formation() {
        return id_formation;
    }

    public void setId_formation(int id_formation) {
        this.id_formation = id_formation;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getNbrPlaces() {
        return nbrPlaces;
    }

    public void setNbrPlaces(int nbrPlaces) {
        this.nbrPlaces = nbrPlaces;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }


    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    @Override
    public String toString() {
        return "Formation{" + "id_formation=" + id_formation + ", titre=" + titre + ", lien=" + lien + ", imageSrc=" + imageSrc + ", description=" + description + ", categorie=" + categorie + ", nbrPlaces=" + nbrPlaces + ", prix=" + prix + '}';
    }

    
    
    

 
    
    
    
    
    
    
}