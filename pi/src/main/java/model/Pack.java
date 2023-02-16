/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;



/**
 *
 * @author LENOVO
 */
public class Pack {

   private int ID_Pack;
   private String nomPack;
   private String categorie;
   private float tarif;

    public Pack() {
    }

    public Pack(int ID_Pack, String nomPack, String categorie, float tarif) {
        this.ID_Pack = ID_Pack;
        this.nomPack = nomPack;
        this.categorie = categorie;
        this.tarif = tarif;
    }

    public Pack(String nomPack, String categorie, float tarif) {
        this.nomPack = nomPack;
        this.categorie = categorie;
        this.tarif = tarif;
    }
    
    

    public int getID_Pack() {
        return ID_Pack;
    }

    public String getNomPack() {
        return nomPack;
    }

   

    public float getTarif() {
        return tarif;
    }

    public void setID_Pack(int ID_Pack) {
        this.ID_Pack = ID_Pack;
    }

    public void setNomPack(String nomPack) {
        this.nomPack = nomPack;
    }

    
    public void setTarif(float tarif) {
        this.tarif = tarif;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return "Pack{" + "ID_Pack=" + ID_Pack + ", nomPack=" + nomPack + ", categorie=" + categorie + ", tarif=" + tarif + '}';
    }

   

}
