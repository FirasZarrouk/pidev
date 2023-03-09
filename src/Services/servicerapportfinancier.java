/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import Interfaces.Interface_IService;
import Model.reunion;
import Model.rapport_financier;
import Util.MaConnection;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.transaction;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;


//import com.google.api.client.auth.oauth2.Credential;
//import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
//import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
//import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
//import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
//import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
//import com.google.api.client.http.FileContent;
//import com.google.api.client.http.HttpTransport;
//import com.google.api.client.json.JsonFactory;
//import com.google.api.client.json.jackson2.JacksonFactory;
//import com.google.api.services.drive.Drive;
//import com.google.api.services.drive.DriveScopes;
//import com.google.api.services.drive.model.File;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.sun.scenario.effect.ImageData;
import java.io.InputStream;
import java.io.InputStreamReader;


/**
 *
 * @author LENOVO
 */
public class servicerapportfinancier implements Interface_IService <rapport_financier> {
    Connection cnx = MaConnection.getInstance().getCnx();
    

    @Override
   public void ajouter(rapport_financier t) {
          try { 

        //String reqInsertion = "INSERT INTO `rapport_financier`(`date_rap`, `Type_rap`, `Date_debut_T`) VALUES ('"+ t.getDate_rap()+"','"+t.getType_rap()+"','"+t.getDate_debut_T()+"')";
      String reqInsertion = "INSERT INTO `rapport_financier`(`date_rap`, `Type_rap`, `Date_debut_T`, `revenus`, `depences`, `Resultat`, `Taxes`) VALUES ('"+ t.getDate_rap()+"','"+t.getType_rap()+"','"+t.getDate_debut_T()+"','"+t.getRevenus()+"','"+t.getDepences()+"','"+t.getResultat()+"','"+t.getTaxes()+"')";
        Statement stInsertion = cnx.createStatement();
        stInsertion.executeUpdate(reqInsertion);
        System.out.println("Rapport ajouté avec succes");
    } catch (SQLException ex) {
        Logger.getLogger(servicerapportfinancier.class.getName()).log(Level.SEVERE, null, ex);
    }
          
   }
      
   
     
        
   
     public void ajouter1(rapport_financier t) {

  }
   
  
    
        

        @Override
        public void modifier(rapport_financier t) {
    //        try {
    //            String req="UPDATE rapport_financier SET `date_rap`='"+t.getDate_rap()+"',`Type_rap`='"+t.getType_rap()+"',`revenus`='"+t.getRevenus()+"',`depences`='"+t.getDepences()+"',`ID_Trans`='"+t.getTransaction().getID_trans()+"' WHERE (`ID_rap`='"+t.getID_rap()+"' )";
    //            Statement st = cnx.createStatement();
    //            st.executeUpdate(req);
    //            System.out.println("Rapport modifié avec succes");
    //        } catch (SQLException ex) {
    //            Logger.getLogger(servicerapportfinancier.class.getName()).log(Level.SEVERE, null, ex);
    //        }
          try {
            // Effectuer la mise à jour dans la base de données
           

           String req = "UPDATE `rapport_financier` SET `date_rap`='"+t.getDate_rap()+"',`Type_rap`='"+t.getType_rap()+"',`Date_debut_T`='"+t.getDate_debut_T()+"',`revenus`='"+t.getRevenus()+"',`depences`='"+t.getDepences()+"',`Resultat`='"+t.getResultat()+"',`Taxes`='"+t.getTaxes()+"' WHERE (`ID_rap`='"+t.getID_rap()+"' ) ";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Rapport modifié avec succes");
        } catch (SQLException ex) {
            Logger.getLogger(servicerapportfinancier.class.getName()).log(Level.SEVERE, null, ex);
        }
        }

    @Override
    public rapport_financier readByName(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<rapport_financier> readBynom(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public reunion readbyd(Date d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public rapport_financier readbyName(String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int nbLigne() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
        public class HeaderFooter extends PdfPageEventHelper {

    
    private String creationDate;

    public HeaderFooter( String creationDate) {
      
        this.creationDate = creationDate;
    }

 
    public void onEndPage(PdfWriter writer, Document document) {
        PdfContentByte cb = writer.getDirectContent();
        Phrase footer = new Phrase("Créé le " + creationDate, FontFactory.getFont(FontFactory.HELVETICA, 10));
        ColumnText.showTextAligned(cb, Element.ALIGN_CENTER, footer, (document.right() - document.left()) / 2 + document.leftMargin(), document.bottom() - 10, 0);
    }
}
      public void creepdf(int ID, String fileName) throws BadElementException, IOException, DocumentException {
    try {
        // Récupérer les données du rapport financier à supprimer
        String reqSelect = "SELECT * FROM rapport_financier WHERE ID_rap = " + ID;
        Statement stSelect = cnx.createStatement();
        ResultSet rs = stSelect.executeQuery(reqSelect);

   
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(fileName + ".pdf"));

        // Ajouter un en-tête avec le nom de l'entreprise et la date actuelle
       
        String creationDate = LocalDate.now().toString();

        // Créer une instance de HeaderFooter et l'associer au PdfWriter
        HeaderFooter event = new HeaderFooter(creationDate);
        writer.setPageEvent(event);
        document.open();
       
        // Charger l'image à partir du dossier
        
          //  String imagePath = "D:/3eme annee/pi/pidev1/src/image/331939313_908136223642012_3641689149527626504_n.png";
        String imagePath = "C:/Users/MSI/Documents/NetBeansProjects/PiProjet/src/GUI/img/logo ontej.png";

            Image image = Image.getInstance(imagePath);

            // Redimensionner l'image
            image.scaleAbsolute(100f, 100f);

            // Ajouter l'image au document
            document.add(image);
            // Ajouter un en-tête avec le nom de l'entreprise et la date actuelle
        
                // Create header
           // Ajouter un en-tête avec le nom de l'entreprise et la date actuelle
    Paragraph header = new Paragraph("ETAT DE LA SITUATION FINANCIERE DE ONTEJ");
    header.setAlignment(Element.ALIGN_CENTER);
    document.add(header);


          // Define table style
    PdfPTable table = new PdfPTable(8);
    table.setWidthPercentage(100);
    table.setSpacingBefore(10f);
    table.setSpacingAfter(10f);
    table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
    table.setHeaderRows(1);

    // Define table headers
    Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
    PdfPCell cell = new PdfPCell();
    cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
    cell.setPadding(5);

    cell.setPhrase(new Phrase("ID rapport", headerFont));
    table.addCell(cell);

    cell.setPhrase(new Phrase("Date rapport", headerFont));
    table.addCell(cell);

    cell.setPhrase(new Phrase("Type du rapport", headerFont));
    table.addCell(cell);

    cell.setPhrase(new Phrase("Date de transaction", headerFont));
    table.addCell(cell);

    cell.setPhrase(new Phrase("revenus", headerFont));
    table.addCell(cell);

    cell.setPhrase(new Phrase("depences", headerFont));
    table.addCell(cell);

    cell.setPhrase(new Phrase("Resultat", headerFont));
    table.addCell(cell);

    cell.setPhrase(new Phrase("Taxes", headerFont));
    table.addCell(cell);


                while (rs.next()) {
            table.addCell(rs.getString("ID_rap"));
            table.addCell(rs.getString("Date_rap"));
            table.addCell(rs.getString("Type_rap"));
            table.addCell(rs.getString("Date_debut_T"));
            table.addCell(rs.getString("revenus"));
            table.addCell(rs.getString("depences"));
            table.addCell(rs.getString("Resultat"));
            table.addCell(rs.getString("Taxes"));
        }
                    PdfPCell tableCell = new PdfPCell(table);
    tableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
    tableCell.setVerticalAlignment(Element.ALIGN_MIDDLE);

    PdfPTable centeredTable = new PdfPTable(1);
    centeredTable.setWidthPercentage(100);
    PdfPCell wrapperCell = new PdfPCell(centeredTable);
   // wrapperCell.setBorder(Rectangle.NO_BORDER);
    centeredTable.addCell(tableCell);
         // Ajouter les paragraphes correspondants en fonction du résultat financier
        String resultatQuery = "SELECT `Resultat` FROM rapport_financier  WHERE ID_rap = " + ID;
ResultSet resultat = stSelect.executeQuery(resultatQuery);// execute the query using a JDBC connection and get the result set

if (resultat.next()) {
    int columnValue = resultat.getInt("Resultat");
    if (columnValue > 0) {
        document.add(new Paragraph("Résumé des résultats financiers de l'exercice : Nous avons le plaisir de vous annoncer que l'exercice financier s'est terminé avec un résultat positif. Nous avons enregistré des profits plus élevés que prévu, principalement grâce à l'augmentation des ventes et à la maîtrise des coûts."));
        document.add(new Paragraph("Perspectives pour l'avenir : Nous sommes confiants quant à l'avenir et nous prévoyons une croissance continue de nos activités. Nous allons continuer à investir dans notre entreprise et à explorer de nouvelles opportunités de croissance."));
    } else {
        document.add(new Paragraph("Résumé des résultats financiers de l'exercice : Nous regrettons de vous informer que l'exercice financier s'est terminé avec un résultat négatif. Nous avons enregistré des pertes plus importantes que prévu, principalement en raison de la baisse des ventes et de l'augmentation des coûts."));
        document.add(new Paragraph("Perspectives pour l'avenir : Malgré ces résultats décevants, nous sommes déterminés à relever les défis qui se présentent à nous et à remettre notre entreprise sur la voie de la croissance et de la rentabilité. Nous allons mettre en place un plan d'action pour réduire les coûts et augmenter les ventes."));
    }
}
                
       document.add(table);


        

        // Supprimer le rapport financier de la base de données
        String reqDelete = "DELETE FROM rapport_financier WHERE ID_rap = " + ID;
        Statement stDelete = cnx.createStatement();
        stDelete.executeUpdate(reqDelete);

        document.close();
        System.out.println("Rapport financier supprimé et enregistré dans un fichier PDF : " + fileName + ".pdf");
    } catch (SQLException | FileNotFoundException ex) {
        Logger.getLogger(servicerapportfinancier.class.getName()).log(Level.SEVERE, null, ex);
    }
         }
        
         @Override
        public void supprimer(int ID) {
        
         try {
        // Générer un nom de fichier unique pour le rapport financier supprimé
      
        rapport_financier r = readById(ID);
        String fileName = "rapport_financier_supprime_" + r.getDate_rap().toString()+ ".pdf";

        // Appeler la méthode creepdf pour enregistrer les données supprimées dans un fichier PDF avec un nom de fichier unique
        creepdf(ID, fileName);

        // Supprimer le rapport financier de la base de données
        String req = "DELETE FROM rapport_financier WHERE (`ID_rap`='" + ID + "' )";
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
        System.out.println("Rapport supprimé avec succès");
    } catch (SQLException ex) {
        Logger.getLogger(servicerapportfinancier.class.getName()).log(Level.SEVERE, null, ex);
    }   catch (BadElementException ex) {
            Logger.getLogger(servicerapportfinancier.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(servicerapportfinancier.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(servicerapportfinancier.class.getName()).log(Level.SEVERE, null, ex);
        }

}
            
           


        @Override
        public List<rapport_financier> afficher() {
                List<rapport_financier> ra =new ArrayList<>();

            try {
                String req="SELECT * FROM rapport_financier ";
                Statement st = cnx.createStatement();
                ResultSet res=st.executeQuery(req);
                while(res.next()){
                        rapport_financier r = new rapport_financier();
                        //servicetransaction s=new servicetransaction();
                        r.setID_rap(res.getInt(1));
                        r.setDate_rap(res.getDate(2));
                        r.setType_rap(res.getString(3));
                        r.setDate_debut_T(res.getDate(4));
                        r.setRevenus(res.getFloat(5));
                        r.setDepences(res.getFloat(6));
                        r.setResultat(res.getFloat(7));
                        r.setTaxes(res.getFloat(8));
                     

                  
                    ra.add(r);
            
        }} catch (SQLException ex) {
            Logger.getLogger(servicerapportfinancier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (ArrayList<rapport_financier>) ra; 
    }

    @Override
    public rapport_financier readById(int id) {
        rapport_financier r = new rapport_financier();
        try {
            String req="SELECT * FROM rapport_financier WHERE (`ID_rap`='"+id+"' )";
            Statement st = cnx.createStatement();
            ResultSet res=st.executeQuery(req);
            while(res.next()){
                    r.setID_rap(res.getInt(1));
                    r.setDate_rap(res.getDate(2));
                    r.setType_rap(res.getString(3));
                   r.setDate_debut_T(res.getDate(4));
                        r.setRevenus(res.getFloat(5));
                        r.setDepences(res.getFloat(6));
                        r.setResultat(res.getFloat(7));
                        r.setTaxes(res.getFloat(8));
                        
                          }} 
        catch (SQLException ex) {
            Logger.getLogger(servicerapportfinancier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    @Override
    public ArrayList<rapport_financier> sortBy(String nom_column, String Asc_Dsc) {
        List<rapport_financier> ra =new ArrayList<>();
        try {
            String req="SELECT * FROM rapport_financier ORDER BY "+nom_column+" "+Asc_Dsc+"";
            Statement st = cnx.createStatement();
            ResultSet res=st.executeQuery(req);
             while(res.next()){
                    rapport_financier r = new rapport_financier();
                    r.setID_rap(res.getInt(1));
                    r.setDate_rap(res.getDate(2));
                    r.setType_rap(res.getString(3));
                     r.setDate_debut_T(res.getDate(4));
                        r.setRevenus(res.getFloat(5));
                        r.setDepences(res.getFloat(6));
                        r.setResultat(res.getFloat(7));
                        r.setTaxes(res.getFloat(8));
                       
                  
                    ra.add(r);
            
        }
        } catch (SQLException ex) {
            Logger.getLogger(servicerapportfinancier.class.getName()).log(Level.SEVERE, null, ex);
        }
    return (ArrayList<rapport_financier>) ra; 
    }

    @Override
    public List<rapport_financier> afficherrr() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<rapport_financier> afficherjointure() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
