package Model;

/**
 *
 * @author MSI
 */
public class Equipe {
    
    private int Id_Equipe ;
    private String Nom_Equipe ;
    private Projet Projet ;
    
    
    public Equipe(){
        
    }

    public Equipe(int Id_Equipe, String Nom_Equipe, Projet Projet) {
        this.Id_Equipe = Id_Equipe;
        this.Nom_Equipe = Nom_Equipe;
        this.Projet = Projet;
    }

    public Equipe(String Nom_Equipe, Projet Projet) {
        this.Nom_Equipe = Nom_Equipe;
        this.Projet = Projet;
    }
    
    

    

    public int getId_Equipe() {
        return Id_Equipe;
    }

    public String getNom_Equipe() {
        return Nom_Equipe;
    }

    public Projet getProjet() {
        return Projet;
    }


    public void setId_Equipe(int Id_Equipe) {
        this.Id_Equipe = Id_Equipe;
    }

    public void setNom_Equipe(String Nom_Equipe) {
        this.Nom_Equipe = Nom_Equipe;
    }

    public void setProjet(Projet Projet) {
        this.Projet = Projet;
    }

    @Override
    public String toString() {
        return "Equipe{" + "Id_Equipe=" + Id_Equipe + ", Nom_Equipe=" + Nom_Equipe + ", Projet=" + Projet + '}';
    }

    

    

    

    

    
    
    
    
}
