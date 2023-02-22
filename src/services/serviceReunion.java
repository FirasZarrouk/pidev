package services;



import Interfaces.Interface_IService;
import models.reunion;
import utilities.connection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.TableColumn;


public class serviceReunion implements Interface_IService<reunion>{
    
    Connection cnx = connection.getInstance().getCnx();

    @Override
    public void ajouter(reunion R) {
        try {
            String req = "INSERT INTO `reunion`(`nom`,`prenom`,`entreprise`,`date`,`heure`,`lieu`,`contact`,`ID_investisseur`,`ID_entrepreneur`,`ID_projet`) VALUES ('"+R.getNom()+"','"+R.getPrenom()+"','"+R.getEntreprise()+"','"+R.getDate()+"','"+R.getHeure()+"','"+R.getLieu()+"','"+R.getContact()+"','"+R.getID_investisseur()+"','"+R.getID_entrepreneur()+"','"+R.getID_projet()+"')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("reunion ajouter avec succes");
        } catch (SQLException ex) {
            Logger.getLogger(serviceReunion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimer(int ID) {
        try {
            String req="DELETE FROM reunion WHERE (`Id_reunion`='"+ID+"' )";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("reunion supprimé avec succes");
        } catch (SQLException ex) {
            Logger.getLogger(serviceReunion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifier(reunion R) {
try {
            String req="UPDATE reunion SET `nom`='"+R.getNom()+"',`prenom`='"+R.getPrenom()+"',`entreprise`='"+R.getEntreprise()+"',`date`='"+R.getDate()+"',`heure`='"+R.getHeure()+"',`lieu`='"+R.getLieu()+"',`contact`='"+R.getContact()+"',`ID_investisseur`='"+R.getID_investisseur()+"',`ID_entrepreneur`='"+R.getID_entrepreneur()+"',`ID_projet`='"+R.getID_projet()+"' WHERE (Id_reunion='"+R.getId_reunion()+"')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("reunion modifie avec succes");
        } catch (SQLException ex) {
            Logger.getLogger(serviceReunion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<reunion> afficher() {
         List<reunion> l=new ArrayList<>();
        try {
            String req="SELECT * FROM `reunion`";
            Statement ste = cnx.createStatement();
            ResultSet res=ste.executeQuery(req);
            while(res.next()){
              reunion R = new reunion(); 
              R.setId_reunion(res.getInt(1));
              R.setNom(res.getString(2));
              R.setPrenom(res.getString(3));
              R.setEntreprise(res.getString(4));
              R.setDate(res.getDate(5));
              R.setHeure(res.getString(6));
              R.setLieu(res.getString(7));
              R.setContact(res.getString(8));
              R.setID_investisseur(res.getString(9));
              R.setID_entrepreneur(res.getString(10));
              R.setID_projet(res.getString(11));
              l.add(R);    
            }
        } catch (SQLException ex) {
            Logger.getLogger(serviceReunion.class.getName()).log(Level.SEVERE, null, ex);
        }
       return (ArrayList<reunion>)l ;
    }

    @Override
    public reunion readById(int id) {
         reunion R = new reunion();
        try {
            String req="SELECT * FROM reunion WHERE `id_reunion`='"+id+"'";
            Statement ste = cnx.createStatement();
            ResultSet res=ste.executeQuery(req);
            while(res.next()){
               
              R.setId_reunion(res.getInt(1));
              R.setNom(res.getString(2));
              R.setPrenom(res.getString(3));
              R.setEntreprise(res.getString(4));
              R.setDate(res.getDate(5));
              R.setHeure(res.getString(6));
              R.setLieu(res.getString(7));
              R.setContact(res.getString(8));
              R.setID_investisseur(res.getString(9));
              R.setID_entrepreneur(res.getString(10));
              R.setID_projet(res.getString(11));
                  
            }
        } catch (SQLException ex) {
            Logger.getLogger(serviceReunion.class.getName()).log(Level.SEVERE, null, ex);
        }
       return R;
    }

    @Override
    public ArrayList<reunion> sortBy(String nom_column, String Asc_Dsc) {
        List<reunion> l=new ArrayList<>();
        
        try {   
            String req="SELECT * FROM reunion ORDER BY "+nom_column+" "+Asc_Dsc+"";
            Statement ste = cnx.createStatement();
            ResultSet res=ste.executeQuery(req);
            
             while(res.next()){
              reunion R = new reunion(); 
              R.setId_reunion(res.getInt(1));
              R.setNom(res.getString(2));
              R.setPrenom(res.getString(3));
              R.setEntreprise(res.getString(4));
              R.setDate(res.getDate(5));
              R.setHeure(res.getString(6));
              R.setLieu(res.getString(7));
              R.setContact(res.getString(8));
              R.setID_investisseur(res.getString(9));
              R.setID_entrepreneur(res.getString(10));
              R.setID_projet(res.getString(11));
              l.add(R);    
            }
        } catch (SQLException ex) {
            Logger.getLogger(serviceReunion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (ArrayList<reunion>)l ;
    }

    @Override
    public boolean sortBy(int i, TableColumn.SortType sortType) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
