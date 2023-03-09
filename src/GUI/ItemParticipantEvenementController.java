/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import Model.evenements;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;
import services.EventService;

/**
 * FXML Controller class
 *
 * @author ydorr
 */
public class ItemParticipantEvenementController implements Initializable {

    @FXML
    private AnchorPane abc;
    @FXML
    private Label NomEvenementss;
    @FXML
    private Label TypeEvenetss;
    @FXML
    private Label DescEvents;
    @FXML
    private ImageView Imgqr;
    @FXML
    private Button details1;
    @FXML
    private Label dateEvs;
    @FXML
    private Label LieuEvss;
    @FXML
    private Label TarifEvenetss1;
    @FXML
    private Label IDeven;
 public evenements Event ;
 
  evenements E = new evenements();
     EventService es= new EventService();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
public void getEvent(evenements E){
        
        
        try {
            NomEvenementss.setText(E.getNom_ev());
            //Description.setText(P.getDescription());
            TypeEvenetss.setText(E.getType_ev());
            DescEvents.setText(E.getDescription());
            LieuEvss.setText(E.getLieu_ev());
            TarifEvenetss1.setText(E.getTarif_Ev());
            //this.evenements=EP;
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            String dateEnString = format.format(E.getDate_ev()); 
            dateEvs.setText(dateEnString);
            
           
            Event=E;
            
            Imgqr.setImage(generateQRCodeImage("houri anis", 300, 300));
        } catch (WriterException ex) {
            Logger.getLogger(ItemParticipantEvenementController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ItemParticipantEvenementController.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }

    @FXML
    private void btndetailsEv(ActionEvent event) throws IOException, ParseException {
        
        evenements selectedEvenements =(evenements) es.readById(Event.getID_ev());
         
         FXMLLoader loader = new FXMLLoader(getClass().getResource("DetailEvenement.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        DetailEvenementController ModifierEventController=loader.getController();
        ModifierEventController.getEvenement(selectedEvenements);
        ModifierEventController.e=selectedEvenements;
        
        
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage)  details1.getScene().getWindow();
         // Modifier la scène de la fenêtre pour la nouvelle scène
        stage.setScene(scene);
         // Afficher la nouvelle interface
        stage.show();
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

    
}
