
package Services;



import Interfaces.Interface_IService;
import Model.Projet;
import Util.MaConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author MSI
 */
public class ServiceProjet implements Interface_IService<Projet>{
    Connection cnx = MaConnection.getInstance().getCnx();

    @Override
    public void ajouter(Projet P) {
    
        try {
            String req = "INSERT INTO `Projet`(`Nom_Projet`, `Description`, `Technologie`, `Date_creation`) VALUES ('"+ P.getNom_Projet()+"','"+P.getDescription()+"','"+P.getTechnologie()+"','"+P.getDate_creation()+"')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Projet  ajouter avec succes");
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProjet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimer(int ID) {
    
        try {
            String req="DELETE FROM projet WHERE (`Id_projet`='"+ID+"' )";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Projet supprimé avec succes");
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProjet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifier(Projet P) {
    
        try {
            String req="UPDATE projet SET `Nom_Projet`='"+P.getNom_Projet()+"',`Description`='"+P.getDescription()+"',`Technologie`='"+P.getTechnologie()+"' WHERE (`Id_projet`='"+P.getId_Projet()+"' )";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Projet modifie avec succes");
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProjet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Projet> afficher() {
        
        List<Projet> li=new ArrayList<>();
        try {
            
            String req="SELECT * FROM projet";
            Statement st = cnx.createStatement();
            ResultSet res=st.executeQuery(req);
            while(res.next()){
                Projet P=new Projet();
                P.setId_Projet(res.getInt(1));
                P.setNom_Projet(res.getString(2));
                P.setDescription(res.getString(3));
                P.setTechnologie(res.getString(4));
                P.setDate_creation(res.getDate(5));
                li.add(P);
            }
            
            } catch (SQLException ex) {
            Logger.getLogger(ServiceProjet.class.getName()).log(Level.SEVERE, null, ex);
            }
            return (ArrayList<Projet>)li ;
    
        
        
    }

    @Override
    public Projet readById(int id) {
        Projet P=new Projet();
        
        try {
            
            
            String req="SELECT * FROM projet WHERE `Id_projet`='"+id+"'";
            Statement st = cnx.createStatement();
            ResultSet res=st.executeQuery(req);
            while(res.next()){
                
                P.setId_Projet(res.getInt(1));
                P.setNom_Projet(res.getString(2));
                P.setDescription(res.getString(3));
                P.setTechnologie(res.getString(4));
                P.setDate_creation(res.getDate(5));
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProjet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return P;
    
    }

    @Override
    public ArrayList<Projet> sortBy(String nom_column, String Asc_Dsc) {
        
        List<Projet> li=new ArrayList<>();

        try {
            
            String req="SELECT * FROM projet ORDER BY "+nom_column+" "+Asc_Dsc+"";   
            Statement st = cnx.createStatement();
            ResultSet res=st.executeQuery(req);
            while(res.next()){
                Projet P=new Projet();
                P.setId_Projet(res.getInt(1));
                P.setNom_Projet(res.getString(2));
                P.setDescription(res.getString(3));
                P.setTechnologie(res.getString(4));
                P.setDate_creation(res.getDate(5));
                
                li.add(P);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProjet.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return (ArrayList<Projet>) li; 

  
    }
}
    
    
    
    
    
        
    

    

    
    

    
    
    
