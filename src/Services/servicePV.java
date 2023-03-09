package services;

import Interfaces.Interface_IService;
import Model.PV;
import Util.MaConnection;
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
import Model.reunion;


    
public class servicePV implements Interface_IService<PV>{
    
    Connection cnx = MaConnection.getInstance().getCnx();
    @Override
    public void ajouter(PV P) {
        try {
            String req = "INSERT INTO `pv`(`datePV`,`Commentaire`,`Verifier`,`id_reunion`) VALUES ('"+P.getDatePV()+"','"+P.getCommentaire()+"','"+P.getVerifier()+"','"+P.getId_reunion().getId_reunion()+"')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("PV ajouter avec succes");
        } catch (SQLException ex) {
            Logger.getLogger(serviceReunion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimer(int ID) {
        try {
            String req="DELETE FROM PV WHERE (`ID_PV`='"+ID+"' )";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("PV supprimé avec succes");
        } catch (SQLException ex) {
            Logger.getLogger(serviceReunion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifier(PV P) {
        try {
            String req="UPDATE PV SET `datePV`='"+P.getDatePV()+"',`Commentaire`='"+P.getCommentaire()+"',`Verifier`='"+P.getVerifier()+"',`id_reunion`='"+P.getId_reunion().getId_reunion()+"' WHERE (ID_PV='"+P.getID_PV()+"')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("PV modifie avec succes");
        } catch (SQLException ex) {
            Logger.getLogger(serviceReunion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<PV> afficher() {
         List<PV> l=new ArrayList<>();
        try {
            String req="SELECT * FROM `PV`";
            Statement ste = cnx.createStatement();
            ResultSet res=ste.executeQuery(req);
            while(res.next()){
              PV P = new PV(); 
              P.setID_PV(res.getInt(1));
              P.setDatePV(res.getDate(2));
              P.setCommentaire(res.getString(3));
              P.setVerifier(res.getString(4));
              reunion Ri = new reunion();
              Ri.setId_reunion(res.getInt(5));
              P.setId_reunion(Ri);
              l.add(P);    
            }
        } catch (SQLException ex) {
            Logger.getLogger(servicePV.class.getName()).log(Level.SEVERE, null, ex);
        }
       return (ArrayList<PV>)l ;
    }

    @Override
    public PV readById(int id) {
        PV P = new PV();
        try {
            String req="SELECT * FROM PV WHERE `ID_PV`='"+id+"'";
            Statement ste = cnx.createStatement();
            ResultSet res=ste.executeQuery(req);
            while(res.next()){
                
               
              P.setID_PV(res.getInt(1));
              P.setDatePV(res.getDate(2));
              P.setCommentaire(res.getString(3));
              P.setVerifier(res.getString(4));
              reunion Ri = new reunion();
              Ri.setId_reunion(res.getInt(5));
              P.setId_reunion(Ri);
                 
            }
        } catch (SQLException ex) {
            Logger.getLogger(servicePV.class.getName()).log(Level.SEVERE, null, ex);
        }
       return P;
    }

    @Override
    public ArrayList<PV> sortBy(String nom_column, String Asc_Dsc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    

    @Override
    public List<PV> readBynom(String nom) {
        List<PV> l=new ArrayList<>();
        try {
            String req="SELECT * FROM PV WHERE `nom`='"+nom+"'";
            Statement ste = cnx.createStatement();
            ResultSet res=ste.executeQuery(req);
            while(res.next()){
                PV P = new PV(); 
               
              P.setID_PV(res.getInt(1));
              P.setDatePV(res.getDate(2));
              P.setCommentaire(res.getString(3));
              P.setVerifier(res.getString(4));
              reunion Ri = new reunion();
              Ri.setId_reunion(res.getInt(5));
              P.setId_reunion(Ri);
              l.add(P);   
            }
        } catch (SQLException ex) {
            Logger.getLogger(servicePV.class.getName()).log(Level.SEVERE, null, ex);
        }
       return l;
    }

    @Override
    public reunion readbyd(Date d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PV readByName(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PV> afficherjointure() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PV> afficherrr() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PV readbyName(String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int nbLigne() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

