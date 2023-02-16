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
            String req = "INSERT INTO `reunion`(`date`,`heure`,`location`,`ID_investisseur`,`ID_entrepreneur`,`ID_projet`) VALUES ('"+R.getDate()+"','"+R.getHeure()+"','"+R.getLocation()+"','"+R.getID_investisseur()+"','"+R.getID_entrepreneur()+"','"+R.getID_projet()+"')";
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
            String req="UPDATE reunion SET `date`='"+R.getDate()+"',`heure`='"+R.getHeure()+"',`location`='"+R.getLocation()+"',`ID_investisseur`='"+R.getID_investisseur()+"',`ID_entrepreneur`='"+R.getID_entrepreneur()+"',`ID_projet`='"+R.getID_projet()+"' WHERE (Id_reunion='"+R.getId_reunion()+"')";
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
              R.setDate(res.getDate(2));
              R.setHeure(res.getString(3));
              R.setLocation(res.getString(4));
              R.setID_investisseur(res.getString(5));
              R.setID_entrepreneur(res.getString(6));
              R.setID_projet(res.getString(7));
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
              R.setDate(res.getDate(2));
              R.setHeure(res.getString(3));
              R.setLocation(res.getString(4));
              R.setID_investisseur(res.getString(5));
              R.setID_entrepreneur(res.getString(6));
              R.setID_projet(res.getString(7));
                  
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
              R.setDate(res.getDate(2));
              R.setHeure(res.getString(3));
              R.setLocation(res.getString(4));
              R.setID_investisseur(res.getString(5));
              R.setID_entrepreneur(res.getString(6));
              R.setID_projet(res.getString(7));
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