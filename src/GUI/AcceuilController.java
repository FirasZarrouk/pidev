/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Model.SessionManager;
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
public class AcceuilController implements Initializable {


    @FXML
    private Button part_acc;
    @FXML
    private Button sopn_acceil;
    private Button ev_acceuil;
    @FXML
    private Button btnPlay;
    @FXML
    private Button btnPause;
    @FXML
    private MediaView mv;
    /**
     * Initializes the controller class.
     */
     MediaPlayer mediaPlayer ;
    @FXML
    private Button BTN_acceuil;
    @FXML
    private Button ev_acceuil1;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String Vurl ="file:/C:/Users/MSI/Documents/NetBeansProjects/PiProjet/src/images/Events.mp4";
        Media media = new Media(Vurl) ;
       mediaPlayer = new MediaPlayer(media);
        mv.setFitHeight(550);
       mv.setFitWidth(710);
        mv.setMediaPlayer(mediaPlayer);
        
        
    }    
    
    @FXML
    private void acceuilParticipants(ActionEvent event) throws IOException {
        
        
         // Charger le fichier FXML de la nouvelle interface
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AcceuilParticipants.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage)  part_acc.getScene().getWindow();
         // Modifier la scène de la fenêtre pour la nouvelle scène
        stage.setScene(scene);
         // Afficher la nouvelle interface
        stage.show();
    }

    @FXML
    private void acceuilSpon(ActionEvent event) throws IOException {
      
        
         // Charger le fichier FXML de la nouvelle interface
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AcceuilSponsor.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage)  sopn_acceil.getScene().getWindow();
         // Modifier la scène de la fenêtre pour la nouvelle scène
        stage.setScene(scene);
         // Afficher la nouvelle interface
        stage.show();
    }

    @FXML
    private void acceuilUtili(ActionEvent event) throws IOException {
        
         // Charger le fichier FXML de la nouvelle interface
        FXMLLoader loader = new FXMLLoader(getClass().getResource("homeEvenement.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage)  BTN_acceuil.getScene().getWindow();
         // Modifier la scène de la fenêtre pour la nouvelle scène
        stage.setScene(scene);
         // Afficher la nouvelle interface
        stage.show();
    }

    @FXML
    private void playBTN(ActionEvent event) {
//           String Vurl ="file:/C:/Users/ydorr/Downloads/Events.mp4";
//        Media media = new Media(Vurl) ;
//        MediaPlayer mediaPlayer = new MediaPlayer(media);
////         mv.setFitHeight(710);
////        mv.setFitWidth(550);
//        mv.setMediaPlayer(mediaPlayer);
        if(mediaPlayer.getStatus()==PLAYING )
        {
            mediaPlayer.stop();
            mediaPlayer.play();
        } else {mediaPlayer.play();}
    }

    @FXML
    private void pauseBTN(ActionEvent event) {
//         String Vurl ="file:/C:/Users/ydorr/Downloads/Events.mp4";
//        Media media = new Media(Vurl) ;
//        MediaPlayer mediaPlayer = new MediaPlayer(media);
////         mv.setFitHeight(710);
////        mv.setFitWidth(550);
//        mv.setMediaPlayer(mediaPlayer);
        
        mediaPlayer.stop();
    }

    @FXML
    private void acceuilEven(ActionEvent event) throws IOException {
         // Charger le fichier FXML de la nouvelle interface
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ADMINHOME.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage)  ev_acceuil1.getScene().getWindow();
         // Modifier la scène de la fenêtre pour la nouvelle scène
        stage.setScene(scene);
         // Afficher la nouvelle interface
        stage.show();
        }

}
