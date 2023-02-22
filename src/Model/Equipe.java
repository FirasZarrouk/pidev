package Model;

/**
 *
 * @author MSI
 */
public class Equipe {
    
    private int Id_Equipe ;
    private String Nom_Equipe ;
    private String Description ;
    private String Membre;
    private String Tache ;
    
    
    
    
    public Equipe(){
        
    }

    public Equipe(int Id_Equipe, String Nom_Equipe, String Description, String Membre, String Tache) {
        this.Id_Equipe = Id_Equipe;
        this.Nom_Equipe = Nom_Equipe;
        this.Description = Description;
        this.Membre = Membre;
        this.Tache = Tache;
        
    }

    public Equipe(String Nom_Equipe, String Description, String Membre, String Tache) {
        this.Nom_Equipe = Nom_Equipe;
        this.Description = Description;
        this.Membre = Membre;
        this.Tache = Tache;
        
    }

    

    public String getMembre() {
        return Membre;
    }

    public String getTache() {
        return Tache;
    }
    
    

    

    public int getId_Equipe() {
        return Id_Equipe;
    }

    public String getNom_Equipe() {
        return Nom_Equipe;
    }

    


    public void setId_Equipe(int Id_Equipe) {
        this.Id_Equipe = Id_Equipe;
    }

    public void setNom_Equipe(String Nom_Equipe) {
        this.Nom_Equipe = Nom_Equipe;
    }

    

    public void setMembre(String Membre) {
        this.Membre = Membre;
    }

    public void setTache(String Tache) {
        this.Tache = Tache;
    }

    @Override
    public String toString() {
        return "Equipe{" + "Id_Equipe=" + Id_Equipe + ", Nom_Equipe=" + Nom_Equipe + ", Description=" + Description + ", Membre=" + Membre + ", Tache=" + Tache + '}';
    }

    
    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    
    
    

    

    

    

    

    

    
    
    
    
}
