/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import GUI.DetailsController;
import GUI.ItemsController;
import Model.Projet;
import Services.ServiceProjet;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import org.controlsfx.control.Rating;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class ItemsEntrepreneurProjetController implements Initializable {

    @FXML
    private AnchorPane abcde;
    @FXML
    private Label NomProjettEN;
    @FXML
    private Label CategorieProjettEN;
    @FXML
    private Label TechnologieProjettEN;
    @FXML
    private ImageView Imgqr;
    @FXML
    private Button detailsEN;
    @FXML
    private Button deleteEN;
    @FXML
    private Label datecreationEN;
    @FXML
    private Rating ratingEN;
    ServiceProjet sp = new ServiceProjet();
    public Projet projet ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
            NomProjettEN.setText(P.getNom_Projet());
            //Description.setText(P.getDescription());
            TechnologieProjettEN.setText(P.getTechnologie());
            CategorieProjettEN.setText(P.getCategorie());
            
            //this.projet= P;
            LocalDate d=P.getDate_creation().toLocalDate();
            datecreationEN.setText(d.toString());
            projet=P;
            String str="Le nom de Projet est  "+projet.getNom_Projet()+" avec le categorie " +projet.getCategorie();
            Imgqr.setImage(generateQRCodeImage("Le nom de Projet est:  "+projet.getNom_Projet()+" avec la categorie est : " +projet.getCategorie()+" et la description est :"+projet.getDescription(), 300, 300));
            //System.out.println(projet);
        } catch (WriterException ex) {
            Logger.getLogger(ItemsController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ItemsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    Projet P=new Projet();

    @FXML
    private void btndetailsEN(ActionEvent event) {
        
        try {
            FXMLLoader loader= new FXMLLoader(getClass().getResource("DetailsENprojet.fxml"));
            Parent view_2=loader.load();
            
            DetailsENprojetController detailscontroller= loader.getController();
            detailscontroller.getdetails(sp.readByName(NomProjettEN.getText()));
            
            
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ItemsEntrepreneurProjetController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void deleteEN(ActionEvent event) {
        
        try {
            sp.supprimer(projet.getId_Projet());
            FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeEntrepreneur.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            
            
            // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
            Stage stage = (Stage) deleteEN.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ItemsEntrepreneurProjetController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    Stage stage;

    @FXML
    private void rating(MouseEvent event) {
        
        System.out.println("Le Rating De Projet est : " +ratingEN.getRating());
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        
        alert.setHeaderText("Merci Pour Votre Rating");
        
        
        if(alert.showAndWait().get()== ButtonType.OK){
        
        
        stage.close();
        }
    }
    
}
