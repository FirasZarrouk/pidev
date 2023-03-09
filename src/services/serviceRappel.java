package services;


import Interfaces.Interface_IService;
import models.rappel;
import utilities.connection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.TableColumn;
import models.reunion;

public class serviceRappel implements Interface_IService<rappel>{
    
     Connection cnx = connection.getInstance().getCnx();

    @Override
    public void ajouter(rappel r) {
        try {
            String req = "INSERT INTO `rappel`(`dateRappel`,`heureRappel`,`reminder`,`email_investisseur`,`eamil_entrepreneur`) VALUES ('"+r.getDateRappel()+"','"+r.getHeureRappel()+"','"+r.getReminder()+"','"+r.getEmail_investisseur()+"','"+r.getEmail_entrepreneur()+"')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("rappel ajouter avec succes");
        } catch (SQLException ex) {
            Logger.getLogger(serviceReunion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimer(int ID) {
        try {
            String req="DELETE FROM rappel WHERE (`ID_rappel`='"+ID+"' )";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("rappel supprimé avec succes");
        } catch (SQLException ex) {
            Logger.getLogger(serviceReunion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifier(rappel r) {
        try {
            String req="UPDATE rappel SET `dateRappel`='"+r.getDateRappel()+"',`heureRappel`='"+r.getHeureRappel()+"',`reminder`='"+r.getReminder()+"',`email_investisseur`='"+r.getEmail_investisseur()+"',`email_entrepreneur`='"+r.getEmail_entrepreneur()+"' WHERE (ID_rappel='"+r.getID_rappel()+"')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("rappel modifie avec succes");
        } catch (SQLException ex) {
            Logger.getLogger(serviceReunion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<rappel> afficher() {
        List<rappel> li=new ArrayList<>();
        try {
            String req="SELECT * FROM `rappel`";
            Statement ste = cnx.createStatement();
            ResultSet res=ste.executeQuery(req);
            while(res.next()){
              rappel R = new rappel(); 
              R.setID_rappel(res.getInt(1));
              R.setDateRappel(res.getDate(2));
              R.setHeureRappel(res.getString(3));
              R.setReminder(res.getString(4));
              R.setEmail_investisseur(res.getString(5));
              R.setEmail_entrepreneur(res.getString(6));
              li.add(R);    
            }
        } catch (SQLException ex) {
            Logger.getLogger(serviceReunion.class.getName()).log(Level.SEVERE, null, ex);
        }
       return (ArrayList<rappel>)li ;
    }

    @Override
    public rappel readById(int id) {
        rappel r = new rappel();
        try {
            String req="SELECT * FROM rappel WHERE `iD_rappel`='"+id+"'";
            Statement ste = cnx.createStatement();
            ResultSet res=ste.executeQuery(req);
            while(res.next()){
              
              r.setID_rappel(res.getInt(1));
              r.setDateRappel(res.getDate(2));
              r.setHeureRappel(res.getString(3));
              r.setReminder(res.getString(4));
              r.setEmail_investisseur(res.getString(5));
              r.setEmail_entrepreneur(res.getString(6));
              
                  
            }
        } catch (SQLException ex) {
            Logger.getLogger(serviceReunion.class.getName()).log(Level.SEVERE, null, ex);
        }
       return r;
    }

    @Override
    public ArrayList<rappel> sortBy(String nom_column, String Asc_Dsc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean sortBy(int i, TableColumn.SortType sortType) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<rappel> readBynom(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public reunion readbyd(Date d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}