package services;

import Interfaces.Interface_IService;
import models.PV;
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
import models.reunion;


    
public class servicePV implements Interface_IService<PV>{
    
    Connection cnx = connection.getInstance().getCnx();
    @Override
    public void ajouter(PV P) {
        try {
            String req = "INSERT INTO `PV`(`nom`,`prenom`,`date`,`Commentaire`,`ID_investisseur`,`ID_entrepreneur`,`ID_projet`,`id_reunion`) VALUES ('"+P.getNom()+"','"+P.getPrenom()+"','"+P.getDate()+"','"+P.getCommentaire()+"','"+P.getID_investisseur()+"','"+P.getID_entrepreneur()+"','"+P.getID_projet()+"','"+P.getId_reunion().getId_reunion()+"')";
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
            String req="UPDATE PV SET `nom`='"+P.getNom()+"',`prenom`='"+P.getPrenom()+"',`date`='"+P.getDate()+"',`Commentaire`='"+P.getCommentaire()+"',`ID_investisseur`='"+P.getID_investisseur()+"',`ID_entrepreneur`='"+P.getID_entrepreneur()+"',`ID_projet`='"+P.getID_projet()+"',`id_reunion`='"+P.getId_reunion().getId_reunion()+"' WHERE (ID_PV='"+P.getID_PV()+"')";
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
              P.setNom(res.getString(2));
              P.setPrenom(res.getString(3));
              P.setDate(res.getDate(4));
              P.setCommentaire(res.getString(5));
              P.setID_investisseur(res.getString(6));
              P.setID_entrepreneur(res.getString(7));
              P.setID_projet(res.getString(8));
              reunion Ri = new reunion();
              Ri.setId_reunion(res.getInt(9));
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
              P.setNom(res.getString(2));
              P.setPrenom(res.getString(3));
              P.setDate(res.getDate(4));
              P.setCommentaire(res.getString(5));
              P.setID_investisseur(res.getString(6));
              P.setID_entrepreneur(res.getString(7));
              P.setID_projet(res.getString(8));
              reunion Ri = new reunion();
              Ri.setId_reunion(res.getInt(9));
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
    public boolean sortBy(int i, TableColumn.SortType sortType) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

