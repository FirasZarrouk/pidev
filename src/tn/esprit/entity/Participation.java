/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tn.esprit.entity;

/**
 *
 * @author ASUS
 */
public class Participation {
     private int id_participation, idU;
    private String niveau, etat;
    private Formation id_formation;

    public Participation() {
    }

    public Participation(int id_participation, int idU, String niveau, String etat, Formation id_formation) {
        this.id_participation = id_participation;
        this.idU = idU;
        this.niveau = niveau;
        this.etat = etat;
        this.id_formation = id_formation;
    }

    public Participation(int idU, String niveau, String etat, Formation id_formation) {
        this.idU = idU;
        this.niveau = niveau;
        this.etat = etat;
        this.id_formation = id_formation;
    }

    

    public int getId_participation() {
        return id_participation;
    }

    public void setId_participation(int id_participation) {
        this.id_participation = id_participation;
    }

    public int getIdU() {
        return idU;
    }

    public Formation getId_formation() {
        return id_formation;
    }

    public void setId_formation(Formation id_formation) {
        this.id_formation = id_formation;
    }
    
    public void setIdU(int idU) {
        this.idU = idU;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Participation{" + "id_participation=" + id_participation + ", idU=" + idU + ", niveau=" + niveau + ", etat=" + etat + ", id_formation=" + id_formation + '}';
    }

    
    
    
    

}
