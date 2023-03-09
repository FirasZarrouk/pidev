package services;



import Interfaces.Interface_IService;
import Model.reunion;
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
import Model.PV;
import Model.Projet;
import Model.User;


public class serviceReunion implements Interface_IService<reunion>{
    
    Connection cnx = MaConnection.getInstance().getCnx();

    @Override
    public void ajouter(reunion R) {
        try {
            String req = "INSERT INTO `reunion`(`dateReunion`,`heureReunion`,`lieuReunion`,`contactReunion`,`ID_entrepreneur`,`Valider`,`ID_investisseur`,`ID_projet`) VALUES ('"+R.getDateReunion()+"','"+R.getHeureReunion()+"','"+R.getLieuReunion()+"','"+R.getContactReunion()+"','"+R.getID_enrepreneur()+"','"+R.getValider()+"','"+R.getId().getId()+"','"+R.getId_projet().getId_Projet()+"')";
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
            String req="UPDATE reunion SET `dateReunion`='"+R.getDateReunion()+"',`heureReunion`='"+R.getHeureReunion()+"',`lieuReunion`='"+R.getLieuReunion()+"',`contactReunion`='"+R.getContactReunion()+"',`ID_entrepreneur`='"+R.getID_enrepreneur()+"',`Valider`='"+R.getValider()+"',`ID_investisseur`='"+R.getId().getId()+"',`ID_projet`='"+R.getId_projet().getId_Projet()+"' WHERE (Id_reunion='"+R.getId_reunion()+"')";
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
              R.setDateReunion(res.getDate(2));
              R.setHeureReunion(res.getString(3));
              R.setLieuReunion(res.getString(4));
              R.setContactReunion(res.getString(5));
              R.setID_enrepreneur(res.getInt(6));
              R.setValider(res.getString(7));
              User U = new User();
              U.setId(res.getInt(8));
              R.setId(U);
              Projet P = new Projet();
              P.setId_Projet(res.getInt(9));
              R.setId_projet(P);
              l.add(R);    
            }
        } catch (SQLException ex) {
            Logger.getLogger(serviceReunion.class.getName()).log(Level.SEVERE, null, ex);
        }
       return (ArrayList<reunion>)l ;
    }
    
    
    public reunion chercherparlieu(String lieu) {
         reunion R = new reunion();
        try {
            String req="SELECT * FROM reunion WHERE `lieuReunion`='"+lieu+"'";
            Statement ste = cnx.createStatement();
            ResultSet res=ste.executeQuery(req);
            while(res.next()){
               
              R.setId_reunion(res.getInt(1));
              R.setDateReunion(res.getDate(2));
              R.setHeureReunion(res.getString(3));
              R.setLieuReunion(res.getString(4));
              R.setContactReunion(res.getString(5));
              R.setID_enrepreneur(res.getInt(6));
              R.setValider(res.getString(7));
              User U = new User();
              U.setId(res.getInt(8));
              R.setId(U);
              Projet P = new Projet();
              P.setId_Projet(res.getInt(9));
              R.setId_projet(P);
                 
            }
        } catch (SQLException ex) {
            Logger.getLogger(serviceReunion.class.getName()).log(Level.SEVERE, null, ex);
        }
       return R ;
    }
    
    

    @Override
    public  reunion readById(int id) {
         reunion R = new reunion();
        try {
            String req="SELECT * FROM reunion WHERE `id_reunion`='"+id+"'";
            Statement ste = cnx.createStatement();
            ResultSet res=ste.executeQuery(req);
            while(res.next()){
              
             R.setId_reunion(res.getInt(1));
              R.setDateReunion(res.getDate(2));
              R.setHeureReunion(res.getString(3));
              R.setLieuReunion(res.getString(4));
              R.setContactReunion(res.getString(5));
              R.setID_enrepreneur(res.getInt(6));
              R.setValider(res.getString(7));
              User U = new User();
              U.setId(res.getInt(8));
              R.setId(U);
              Projet P = new Projet();
              P.setId_Projet(res.getInt(9));
              R.setId_projet(P);
              
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
              R.setDateReunion(res.getDate(2));
              R.setHeureReunion(res.getString(3));
              R.setLieuReunion(res.getString(4));
              R.setContactReunion(res.getString(5));
              R.setID_enrepreneur(res.getInt(6));
              R.setValider(res.getString(7));
              User U = new User();
              U.setId(res.getInt(8));
              R.setId(U);
              Projet P = new Projet();
              P.setId_Projet(res.getInt(9));
              R.setId_projet(P);
              l.add(R);    
            }
        } catch (SQLException ex) {
            Logger.getLogger(serviceReunion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (ArrayList<reunion>)l ;
    }

    

    @Override
    public List<reunion> readBynom(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public reunion readbyd(Date d) {
         reunion R = new reunion();
         int i=0 ;
        try {
            
            String req="SELECT * FROM reunion WHERE `dateReunion`='"+d+"'";
            Statement ste = cnx.createStatement();
            ResultSet res=ste.executeQuery(req);
            while(res.next()){
              
              R.setId_reunion(res.getInt(1));
              R.setDateReunion(res.getDate(2));
              R.setHeureReunion(res.getString(3));
              R.setLieuReunion(res.getString(4));
              R.setContactReunion(res.getString(5));
              R.setID_enrepreneur(res.getInt(6));
              R.setValider(res.getString(7));
              User U = new User();
              U.setId(res.getInt(8));
              R.setId(U);
              Projet P = new Projet();
              P.setId_Projet(res.getInt(9));
              R.setId_projet(P);
              
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(serviceReunion.class.getName()).log(Level.SEVERE, null, ex);
            i++;
            
            
        }
      return R;
      
      
    }

    @Override
    public reunion readByName(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<reunion> afficherjointure() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<reunion> afficherrr() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public reunion readbyName(String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int nbLigne() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public List<reunion> chercherbyid(User id) {
         List<reunion> l=new ArrayList<>();
        try {
            String req="SELECT * FROM `reunion` WHERE `ID_investisseur`='"+id.getId()+"'";
            Statement ste = cnx.createStatement();
            ResultSet res=ste.executeQuery(req);
            while(res.next()){
              reunion R = new reunion();
              R.setId_reunion(res.getInt(1));
              R.setDateReunion(res.getDate(2));
              R.setHeureReunion(res.getString(3));
              R.setLieuReunion(res.getString(4));
              R.setContactReunion(res.getString(5));
              R.setID_enrepreneur(res.getInt(6));
              R.setValider(res.getString(7));
              User U = new User();
              U.setId(res.getInt(8));
              R.setId(U);
              Projet P = new Projet();
              P.setId_Projet(res.getInt(9));
              R.setId_projet(P);
              l.add(R);    
            }
        } catch (SQLException ex) {
            Logger.getLogger(serviceReunion.class.getName()).log(Level.SEVERE, null, ex);
        }
       return (ArrayList<reunion>)l ;
    }
    
    
    public List<reunion> chercherbyidp(Projet p) {
         List<reunion> l=new ArrayList<>();
        try {
            String req="SELECT * FROM `reunion` WHERE `ID_projet`='"+p.getId_Projet()+"'";
            Statement ste = cnx.createStatement();
            ResultSet res=ste.executeQuery(req);
            while(res.next()){
              reunion R = new reunion();
              R.setId_reunion(res.getInt(1));
              R.setDateReunion(res.getDate(2));
              R.setHeureReunion(res.getString(3));
              R.setLieuReunion(res.getString(4));
              R.setContactReunion(res.getString(5));
              R.setID_enrepreneur(res.getInt(6));
              R.setValider(res.getString(7));
              User U = new User();
              U.setId(res.getInt(8));
              R.setId(U);
              Projet P = new Projet();
              P.setId_Projet(res.getInt(9));
              R.setId_projet(P);
              l.add(R);    
            }
        } catch (SQLException ex) {
            Logger.getLogger(serviceReunion.class.getName()).log(Level.SEVERE, null, ex);
        }
       return (ArrayList<reunion>)l ;
    }
    
    
}
