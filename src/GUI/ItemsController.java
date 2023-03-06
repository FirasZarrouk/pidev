/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Interfaces.Interface_IService;
import Model.Equipe;
import Model.Projet;
import Services.ServiceProjet;
import Util.MaConnection;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import org.controlsfx.control.Rating;




/**
 * FXML Controller class
 *
 * @author MSI
 */

public class ItemsController implements Initializable {

    @FXML
        private Label CategorieProjett;
    @FXML
    private Label TechnologieProjett;
    @FXML
    private Label NomProjett;
    @FXML
    private  Button delete;
    private Label Description;
    
    ServiceProjet sp = new ServiceProjet();
    public Projet projet ;
    @FXML
    private ImageView Imgqr;
    @FXML
    private Label datecreation;
    @FXML
    private Rating rating;
    @FXML
    private AnchorPane abc;
    @FXML
    private Button details;
    
    
    
    
    
    
    
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       /* try {
            Imgqr.setImage(generateQRCodeImage("code", 75, 75));
            
        } catch (WriterException ex) {
            Logger.getLogger(ItemsController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ItemsController.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
        

    }   
    private Image generateQRCodeImage(String text, int width, int height) throws WriterException, IOException {

    QRCodeWriter qrCodeWriter = new QRCodeWriter();
    BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
    BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
   ByteArrayOutputStream out = new ByteArrayOutputStream();
    ImageIO.write(bufferedImage, "png", out);
    out.flush();
    ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
    return new Image(in);
    }
    
    
    
    
    public void getProjet(Projet P){
        
        try {
            NomProjett.setText(P.getNom_Projet());
            //Description.setText(P.getDescription());
            TechnologieProjett.setText(P.getTechnologie());
            CategorieProjett.setText(P.getCategorie());
            
            //this.projet= P;
            LocalDate d=P.getDate_creation().toLocalDate();
            datecreation.setText(d.toString());
            projet=P;
            //String str="Le nom de Projet est  "+projet.getNom_Projet()+" avec le categorie " +projet.getCategorie();
            Imgqr.setImage(generateQRCodeImage("Le nom de Projet est:  "+projet.getNom_Projet()+" avec la categorie est : " +projet.getCategorie()+" et la description est :"+projet.getDescription(), 300, 300));
            //System.out.println(projet);
        } catch (WriterException ex) {
            Logger.getLogger(ItemsController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ItemsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setdataProjet(Projet p){
         
                
        NomProjett.setText(String.valueOf(p.getNom_Projet()));
        CategorieProjett.setText(String.valueOf(p.getCategorie()));
        TechnologieProjett. setText(p.getTechnologie());
        Description.setText(String.valueOf(p.getDescription()));

    }
    
    
    
    
    
    
    
    Projet P=new Projet();
    
    
    
    

    

    @FXML
    private void btndetails(ActionEvent event) throws IOException {
        {    
            try {
                
                

        FXMLLoader loader= new FXMLLoader(getClass().getResource("Details.fxml"));
                Parent view_2=loader.load();
                
                DetailsController detailscontroller= loader.getController();
                detailscontroller.getdetails(sp.readByName(NomProjett.getText()));
                
                
                Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                Scene scene = new Scene(view_2);
                stage.setScene(scene);
                stage.show();
            }catch (IOException ex) {
            Logger.getLogger(ItemsController.class.getName()).log(Level.SEVERE, null, ex);
        }
                }
        
    }

    @FXML
    private void delete() {
        
        try {
            sp.supprimer(projet.getId_Projet());
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AceuilProjet.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            
            
            // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
            Stage stage = (Stage) delete.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ItemsController.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
    Stage stage;

    @FXML
    private void rating(MouseEvent event) {
        
        System.out.println("Le Rating De Projet est : " +rating.getRating());
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        
        alert.setHeaderText("Merci Pour Votre Rating");
        
        
        if(alert.showAndWait().get()== ButtonType.OK){
        
        
        stage.close();
        }
    }
    
//    @FXML
//    private void onRatingChanged() {
//    double newRating = rating.getRating();
//    // Enregistrer la nouvelle note dans la base de données
//    sp.updateRating(projet.getId_Projet(), newRating);




    
//    }
    
}
