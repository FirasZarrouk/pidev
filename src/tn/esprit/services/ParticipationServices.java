/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tn.esprit.services;

/**
 *
 * @author ASUS
 */
import tn.esprit.interfaces.Interface_IService;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import tn.esprit.entity.Participation;
import tn.esprit.tools.MyConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import tn.esprit.entity.Formation;
/**
 *
 * @author adelb
 */
public class ParticipationServices implements Interface_IService<Participation>{
    //var
    Connection cnx = MyConnection.getInstance().getCnx();
    
    @Override
    public void ajouter(Participation t) {
            try {
                String req = "INSERT INTO `participation`(`idU`,`niveau`,`etat`,`id_formation`) VALUES ('"+ t.getIdU()+"','"+t.getNiveau()+"','"+t.getEtat()+"',"+t.getId_formation().getId_formation()+")";
                Statement st = cnx.createStatement();
                st.executeUpdate(req);
                System.out.println("Participation ajouter avec succes");
            } catch (SQLException ex) {
                Logger.getLogger(ParticipationServices.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @Override
    public void supprimer(int id) {
            try {
                String req="DELETE FROM participation WHERE (`id_participation`='"+id+"' )";
                Statement st = cnx.createStatement();
                st.executeUpdate(req);
                System.out.println("Participation supprimé avec succes");
            } catch (SQLException ex) {
                Logger.getLogger(ParticipationServices.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @Override
    public void modifier(Participation t) {
            try {
                String req="UPDATE participation SET `idU`='"+t.getIdU()+"',`niveau`='"+t.getNiveau()+"',`etat`='"+t.getEtat()+"' WHERE (`id`='"+t.getId_participation()+"' )";
                Statement st = cnx.createStatement();
                st.executeUpdate(req);
                System.out.println("Participation modifié avec succes");
            } catch (SQLException ex) {
                Logger.getLogger(ParticipationServices.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @Override
    public List<Participation> afficher() {
         List<Participation> pa=new ArrayList<>();    
        try {
               
                String req="SELECT * FROM participation";
                Statement st = cnx.createStatement();
                ResultSet res=st.executeQuery(req);
                while(res.next()){
                    Participation p=new Participation();
                    p.setId_participation(res.getInt(1));
                    p.setIdU(res.getInt(2));
                    p.setNiveau(res.getString(3));
                    p.setEtat(res.getString(4));
                    Formation F = new Formation();
                    F.setId_formation(res.getInt(5));
                    p.setId_formation(F);
                  
                    pa.add(p);
                }       } catch (SQLException ex) {
                Logger.getLogger(FormationServices.class.getName()).log(Level.SEVERE, null, ex);
            }
         return (ArrayList<Participation>) pa;
}

    @Override
    public Participation readById(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
   Participation P = new Participation();
        try {
            String req="SELECT * FROM participation WHERE `id_participation`='"+id+"'";
            Statement ste = cnx.createStatement();
            ResultSet res=ste.executeQuery(req);
            while(res.next()){
                FormationServices se = new FormationServices();
               
              P.setId_participation(res.getInt(1));
              P.setIdU(res.getInt(2));
              P.setNiveau(res.getString(3));
              P.setEtat(res.getString(4));
              Formation F = se.readById(res.getInt(5));
              P.setId_formation(F);
              
                  
            }
        } catch (SQLException ex) {
            Logger.getLogger(ParticipationServices.class.getName()).log(Level.SEVERE, null, ex);
        }
       return P;
    }

    @Override
    public ArrayList<Participation> sortBy(String nom_column, String Asc_Dsc) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
      List<Participation> ta =new ArrayList<>();
                try {
                    String req="SELECT * FROM participation ORDER BY "+nom_column+" "+Asc_Dsc+"";
                    Statement ste = cnx.createStatement();
                    ResultSet res=ste.executeQuery(req);
                      while(res.next()){
                          FormationServices se = new FormationServices();
                    Participation pr = new Participation();
                    pr.setId_participation(res.getInt(1));
                    pr.setIdU(res.getInt(2));
                    pr.setNiveau(res.getString(3));
                    pr.setEtat(res.getString(4));
                    Formation F = se.readById(res.getInt(5));
                    pr.setId_formation(F);
                   
                  
                    ta.add(pr);
                }}
                catch (SQLException ex) {
                    Logger.getLogger(ParticipationServices.class.getName()).log(Level.SEVERE, null, ex);
                }
         return (ArrayList<Participation>) ta; 

    }
}
