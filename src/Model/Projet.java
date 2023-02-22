
package Model;
 
import java.sql.Date;



/**
 *
 * @author MSI
 */
public class Projet {
    
    private int Id_Projet ;
    private String Nom_Projet ;
    private String Description ;
    private String Technologie ;
    private Date Date_creation ;
    private String categorie;
    private Equipe Id_Equipe;
    
    
    
    
    //const
    public Projet(){
        
    }

    public Projet(int Id_Projet, String Nom_Projet, String Description, String Technologie, Date Date_creation, String categorie, Equipe Id_Equipe) {
        this.Id_Projet = Id_Projet;
        this.Nom_Projet = Nom_Projet;
        this.Description = Description;
        this.Technologie = Technologie;
        this.Date_creation = Date_creation;
        this.categorie = categorie;
        this.Id_Equipe = Id_Equipe;
    }

    public Projet(String Nom_Projet, String Description, String Technologie, Date Date_creation, String categorie, Equipe Id_Equipe) {
        this.Nom_Projet = Nom_Projet;
        this.Description = Description;
        this.Technologie = Technologie;
        this.Date_creation = Date_creation;
        this.categorie = categorie;
        this.Id_Equipe = Id_Equipe;
    }

    public void setId_Equipe(Equipe Id_Equipe) {
        this.Id_Equipe = Id_Equipe;
    }

    public Equipe getId_Equipe() {
        return Id_Equipe;
    }

    

    

    

    

    public int getId_Projet() {
        return Id_Projet;
    }

    public String getNom_Projet() {
        return Nom_Projet;
    }

    public String getDescription() {
        return Description;
    }

    public String getTechnologie() {
        return Technologie;
    }

    public Date getDate_creation() {
        return Date_creation;
    }

    public String getCategorie() {
        return categorie;
    }

    

    

    public void setId_Projet(int Id_Projet) {
        this.Id_Projet = Id_Projet;
    }

    public void setNom_Projet(String Nom_Projet) {
        this.Nom_Projet = Nom_Projet;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setTechnologie(String Technologie) {
        this.Technologie = Technologie;
    }

    public void setDate_creation(Date Date_creation) {
        this.Date_creation = Date_creation;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return "Projet{" + "Id_Projet=" + Id_Projet + ", Nom_Projet=" + Nom_Projet + ", Description=" + Description + ", Technologie=" + Technologie + ", Date_creation=" + Date_creation + ", categorie=" + categorie + ", Id_Equipe=" + Id_Equipe + '}';
    }

    

    

    

    

    

    

    
    
    
   

    

    
    
    
    
    
}
