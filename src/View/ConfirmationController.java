/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

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
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import static javafx.scene.media.MediaPlayer.Status.PLAYING;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import Model.Formation;
import services.FormationServices;

/**
 * FXML Controller class
 *
 * @author ydorr
 */
public class ConfirmationController implements Initializable {
    
    MediaPlayer mediaPlayer ;
    
   
    @FXML
    private MediaView mv;
    @FXML
    private Button btnPlay;
    @FXML
    private Button btnPause;
    @FXML
    private Button accueil;
    @FXML
    private Label id;
    FormationServices fs =new FormationServices();
    
    public Formation f;
    
   
    /**
     * Initializes the controller class.
     */
     void getFormation(Formation f){
    id.setText(Integer.toString(f.getId_formation()));
   
    //video.setText(f.getVideo());
    
}
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          String Vurl ="file:/C:/Users/MSI/Documents/NetBeansProjects/PiProjet/src/images_yosra/marketing.mp4";//f.getVideo();
        Media media = new Media(Vurl) ;
       mediaPlayer = new MediaPlayer(media);
        mv.setFitHeight(550);
       mv.setFitWidth(710);
        mv.setMediaPlayer(mediaPlayer);
        
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
    private void accueil(ActionEvent event) throws IOException {
         // Charger l'interface suivante à partir de son fichier FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Formation_accueil2.fxml"));

    // Create a new stage for the new view
    Stage stage = new Stage();
    stage.setScene(new Scene(loader.load()));

    // Show the new stage and hide the current stage
    stage.show();
    Stage currentStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    currentStage.hide();
    }
    
}
