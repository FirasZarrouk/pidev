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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
public class AcceuilUtilisateurController implements Initializable {
 MediaPlayer mediaPlayer ;
    private Button part_acc;
    private Button sopn_acceil;
    @FXML
    private MediaView mv;
    @FXML
    private Button btnPlay;
    @FXML
    private Button btnPause;
//    @FXML
//    private ImageView BTNAcceuilU;
    private Button Uti_acceil1;
    @FXML
    private Button part_accee;
    @FXML
    private Button sopn_acceilll;
    @FXML
    private Button Uti_acceil111;
    

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
        
    }    

    @FXML
    private void acceuilParticipants(ActionEvent event) throws IOException {
         // Charger le fichier FXML de la nouvelle interface
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeParticipants.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage)  part_accee.getScene().getWindow();
         // Modifier la scène de la fenêtre pour la nouvelle scène
        stage.setScene(scene);
         // Afficher la nouvelle interface
        stage.show();
    }

    @FXML
    private void acceuilSpon(ActionEvent event) throws IOException {
         // Charger le fichier FXML de la nouvelle interface
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeSponsors.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage)  sopn_acceilll.getScene().getWindow();
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

    

    @FXML
    private void acceuilUtilisateur(ActionEvent event) throws IOException {
        
        
        
        
        // Charger le fichier FXML de la nouvelle interface
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../ViewInves/ADMINHOMEINVES.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage)  Uti_acceil111.getScene().getWindow();
         // Modifier la scène de la fenêtre pour la nouvelle scène
        stage.setScene(scene);
         // Afficher la nouvelle interface
        stage.show();}
        
        
        

    
    }
    
    

//    @FXML
//    private void acceuilUt(MouseEvent event) throws IOException {
//        String role = SessionManager.getInstance().getCurrentUser().getRole();
////        
////        
//        if(role=="Investisseur"){
//        
//        // Charger le fichier FXML de la nouvelle interface
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("../ViewInves/ADMINHOMEINVES.fxml"));
//        Parent root = loader.load();
//        Scene scene = new Scene(root);
//        
//        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
//        Stage stage = (Stage)  Uti_acceil1.getScene().getWindow();
//         // Modifier la scène de la fenêtre pour la nouvelle scène
//        stage.setScene(scene);
//         // Afficher la nouvelle interface
//        stage.show();}
//        
//        else 
//            if (role=="Entrepreneur"){
//        
//// Charger le fichier FXML de la nouvelle interface
//        FXMLLoader loaders = new FXMLLoader(getClass().getResource("../View/ADMINHOMEENTR.fxml"));
//        Parent roots;
//        roots = loaders.load();
//        Scene scenes = new Scene(roots);
//        
//        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
//        Stage stages = (Stage)  Uti_acceil111.getScene().getWindow();
//         // Modifier la scène de la fenêtre pour la nouvelle scène
//        stages.setScene(scenes);
//         // Afficher la nouvelle interface
//        stages.show();
//    }
//    }

//    @FXML
//    private void acceuilUtilisateur(ActionEvent event) {
//        
//        
//        
//    }



