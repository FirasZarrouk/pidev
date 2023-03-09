
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
    private String Tache_de_projet ; 
    private Date Date_creation ;
    private String categorie;
    private User id ;
    
    private Equipe Id_Equipe;
    
    
    
    
    //const
    public Projet(){
        
    }

    public Projet(int Id_Projet, String Nom_Projet, String Description, String Technologie, String Tache_de_projet, Date Date_creation, String categorie, User id, Equipe Id_Equipe) {
        this.Id_Projet = Id_Projet;
        this.Nom_Projet = Nom_Projet;
        this.Description = Description;
        this.Technologie = Technologie;
        this.Tache_de_projet = Tache_de_projet;
        this.Date_creation = Date_creation;
        this.categorie = categorie;
        this.id = id;
        this.Id_Equipe = Id_Equipe;
    }

    public Projet(String Nom_Projet, String Description, String Technologie, String Tache_de_projet, Date Date_creation, String categorie, User id, Equipe Id_Equipe) {
        this.Nom_Projet = Nom_Projet;
        this.Description = Description;
        this.Technologie = Technologie;
        this.Tache_de_projet = Tache_de_projet;
        this.Date_creation = Date_creation;
        this.categorie = categorie;
        this.id = id;
        this.Id_Equipe = Id_Equipe;
    }

    public User getId() {
        return id;
    }

    public void setId(User id) {
        this.id = id;
    }

    

    

   

    
    
    
    

    

    public void setId_Equipe(Equipe Id_Equipe) {
        this.Id_Equipe = Id_Equipe;
    }

    public Equipe getId_Equipe() {
        return Id_Equipe;
    }

    public String getTache_de_projet() {
        return Tache_de_projet;
    }

    public void setTache_de_projet(String Tache_de_projet) {
        this.Tache_de_projet = Tache_de_projet;
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
        return "Projet{" + "Id_Projet=" + Id_Projet + ", Nom_Projet=" + Nom_Projet + ", Description=" + Description + ", Technologie=" + Technologie + ", Tache_de_projet=" + Tache_de_projet + ", Date_creation=" + Date_creation + ", categorie=" + categorie + ", id=" + id + ", Id_Equipe=" + Id_Equipe + '}';
    }

    
    

    

    

    
    

    

    

    

    

    

    

    
    
    
   

    

    
    
    
    
    
}
