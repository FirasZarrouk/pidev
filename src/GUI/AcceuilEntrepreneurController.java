/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import static javafx.scene.media.MediaPlayer.Status.PLAYING;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ydorr
 */
public class AcceuilEntrepreneurController implements Initializable {

    @FXML
    private Button bntPARTICIPANT;
    @FXML
    private Button btnSPONSOR;
    @FXML
    private Button btnACCEUIL;
    @FXML
    private MediaView mv;
    @FXML
    private Button btnPlay;
    @FXML
 private Button btnPause;
MediaPlayer mediaPlayer ;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         // TODO
          String Vurl ="file:/C:/Users/MSI/Documents/NetBeansProjects/PiProjet/src/images/Events.mp4";
        Media media = new Media(Vurl) ;
       mediaPlayer = new MediaPlayer(media);
        mv.setFitHeight(550);
       mv.setFitWidth(710);
        mv.setMediaPlayer(mediaPlayer);
        // TODO
    }    

    @FXML
    private void BTNparticipants(ActionEvent event) throws IOException {
   
                // Charger le fichier FXML de la nouvelle interface
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeParticipants.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage)  bntPARTICIPANT.getScene().getWindow();
         // Modifier la scène de la fenêtre pour la nouvelle scène
        stage.setScene(scene);
         // Afficher la nouvelle interface
        stage.show();
            
            }

    @FXML
    private void BTNsponsor(ActionEvent event) throws IOException {
        // Charger le fichier FXML de la nouvelle interface
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeSponsors.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage)  btnSPONSOR.getScene().getWindow();
         // Modifier la scène de la fenêtre pour la nouvelle scène
        stage.setScene(scene);
         // Afficher la nouvelle interface
        stage.show();
    }

    @FXML
    private void BTNAcceuil(ActionEvent event) throws IOException {
        // Charger le fichier FXML de la nouvelle interface
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/ADMINHOMEENTR.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage)  btnACCEUIL.getScene().getWindow();
         // Modifier la scène de la fenêtre pour la nouvelle scène
        stage.setScene(scene);
         // Afficher la nouvelle interface
        stage.show();
    }

    @FXML
    private void playBTN(ActionEvent event) {
                 if(mediaPlayer.getStatus()==PLAYING )
        {
            mediaPlayer.stop();
            mediaPlayer.play();
        } else {mediaPlayer.play();}
    }

    @FXML
    private void pauseBTN(ActionEvent event) {
             mediaPlayer.stop();
    }

    
    
}