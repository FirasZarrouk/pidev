/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
   private String roleU;
   private User user;


    public Pack() {
    }

    public Pack(int ID_Pack, String nomPack, String categorie, float tarif, String roleU, User user) {
        this.ID_Pack = ID_Pack;
        this.nomPack = nomPack;
        this.categorie = categorie;
        this.tarif = tarif;
        this.roleU = roleU;
        this.user = user;
    }

    public Pack(String nomPack, String categorie, float tarif, String roleU, User user) {
        this.nomPack = nomPack;
        this.categorie = categorie;
        this.tarif = tarif;
        this.roleU = roleU;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
   

    public String getRoleU() {
        return roleU;
    }

    public void setRoleU(String roleU) {
        this.roleU = roleU;
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
        return "Pack{" + "ID_Pack=" + ID_Pack + ", nomPack=" + nomPack + ", categorie=" + categorie + ", tarif=" + tarif + ", roleU=" + roleU + ", user=" + user + '}';
    }

    

  

    
   

}
