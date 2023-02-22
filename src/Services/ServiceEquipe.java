

package Services;

import Interfaces.Interface_IService;
import Model.Equipe;
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



public class ServiceEquipe implements Interface_IService<Equipe> {
        Connection cnx = MaConnection.getInstance().getCnx();

    @Override
    public void ajouter(Equipe E) {
    
            try {
                String req = "INSERT INTO `equipe`(`Nom_Equipe`,`Description`,`Membre`,`Tache`) VALUES ('"+E.getNom_Equipe()+"','"+E.getDescription()+"','"+E.getMembre()+"','"+E.getTache()+"')";
                Statement st = cnx.createStatement();
                st.executeUpdate(req);
                System.out.println("Equipe ajouter avec succes");
            } catch (SQLException ex) {
                Logger.getLogger(ServiceEquipe.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @Override
    public void supprimer(int ID) {
            try {
                String req="DELETE FROM equipe WHERE (`Id_Equipe`='"+ID+"' )";
                Statement st = cnx.createStatement();
                st.executeUpdate(req);
                System.out.println("Equipe supprimé avec succes");
            } catch (SQLException ex) {
                Logger.getLogger(ServiceEquipe.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @Override
    public void modifier(Equipe E) {
            try {
                String req="UPDATE equipe SET `Nom_Equipe`='"+E.getNom_Equipe()+"',`Description`='"+E.getDescription()+"',`Membre`='"+E.getMembre()+"',`Tache`='"+E.getTache()+"' WHERE (`Id_Equipe`='"+E.getId_Equipe()+"' )";
                Statement st = cnx.createStatement();
                st.executeUpdate(req);
                System.out.println("Equipe modifie avec succes");
            } catch (SQLException ex) {
                Logger.getLogger(ServiceEquipe.class.getName()).log(Level.SEVERE, null, ex);
            }
 }

    @Override
    public List<Equipe> afficher() {
            
            List<Equipe> li=new ArrayList<>();

            try {
                String req="SELECT * FROM Equipe";
                Statement ste = cnx.createStatement();
                ResultSet res=ste.executeQuery(req);
                while(res.next()){
                    Equipe E=new Equipe();
                    ServiceProjet se = new ServiceProjet();
                    E.setId_Equipe(res.getInt(1));
                    E.setNom_Equipe(res.getString(2));
                    E.setDescription(res.getString(3));
                    E.setMembre(res.getString(4));
                    E.setTache(res.getString(5));
                    
                    
                    
                    li.add(E);
                    
                    
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(ServiceEquipe.class.getName()).log(Level.SEVERE, null, ex);
            }
                            return (ArrayList<Equipe>) li;

    }

    @Override
    public Equipe readById(int id) {
        Equipe E=new Equipe();
            try {
                String req="SELECT * FROM `equipe` WHERE `Id_Equipe`='"+id+"'";
                Statement st = cnx.createStatement();
                ResultSet res=st.executeQuery(req);
                while(res.next()){
                    
                    ServiceProjet se = new ServiceProjet();
                    E.setId_Equipe(res.getInt(1));
                    E.setNom_Equipe(res.getString(2));
                    E.setDescription(res.getString(3));
                    E.setMembre(res.getString(4));
                    E.setTache(res.getString(5));
                    
                    
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(ServiceEquipe.class.getName()).log(Level.SEVERE, null, ex);
            }
                            return E;

    }

    @Override
    public ArrayList<Equipe> sortBy(String nom_column, String Asc_Dsc) {
        List<Equipe> li=new ArrayList<>(); 

            try {
                String req="SELECT * FROM Equipe ORDER BY "+nom_column+" "+Asc_Dsc+"";
                Statement ste = cnx.createStatement();
                ResultSet res=ste.executeQuery(req);
                while(res.next()){
                    Equipe E=new Equipe();
                    ServiceProjet se = new ServiceProjet();
                    E.setId_Equipe(res.getInt(1));
                    E.setNom_Equipe(res.getString(2));
                    E.setDescription(res.getString(3));
                    E.setMembre(res.getString(4));
                    E.setTache(res.getString(5));
                    
                    li.add(E);    }
            } catch (SQLException ex) {
                Logger.getLogger(ServiceEquipe.class.getName()).log(Level.SEVERE, null, ex);
            }
                 return (ArrayList<Equipe>) li; }



    

    
    
}
