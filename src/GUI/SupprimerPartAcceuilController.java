/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Participant;
import services.participantServices;

/**
 * FXML Controller class
 *
 * @author ydorr
 */
public class SupprimerPartAcceuilController implements Initializable {

    @FXML
    private Label IDsuppEV;
    @FXML
    private Button SuppEvid;
    @FXML
    private Button btnSUPPev;
    @FXML
    private TextField ChercheSupprime;
    @FXML
    private Label ErreurRechercheS;
    @FXML
    private Button cherchebtnupp;
  participantServices ps = new participantServices();
  Participant p = new Participant();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void SupprimerEvAcc(ActionEvent event) {
        
        int idev = Integer.parseInt(IDsuppEV.getText());
      p.setID_part(idev);
       if (p != null) { 
     

//
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Confirmation de suppression");
            alert.setHeaderText(null);
            alert.setContentText("Êtes-vous sûr de vouloir annuler votre participation ?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {


               // EventService ps = new EventService();
           //   for (String email : emails) {

                


                
           ps.supprimer(p.getID_part());
          
          Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Participation annulé");
                 String content = String.format("Participation est annulé avec succès.");
        a.setContentText(content);
                              
        a.show();
            }}}
    

    @FXML
    private void RetourBTNsupp(ActionEvent event) throws IOException {
        // Charger le fichier FXML de la nouvelle interface
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeParticipants.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage)  btnSUPPev.getScene().getWindow();
         // Modifier la scène de la fenêtre pour la nouvelle scène
        stage.setScene(scene);
         // Afficher la nouvelle interface
        stage.show();
    }

    @FXML
    private void chercherBTNSupp(ActionEvent event) {
        String name =   ChercheSupprime.getText();
        p=ps.readbyName(name);
   if (p.getID_part() != 0  ) {IDsuppEV.setText(String.valueOf(p.getID_part()));
 

       String d ="Vous etes participer a l'evenement "+p.getNom_event().getNom_ev();
      ErreurRechercheS.setText(d); 
      }
    
   else {
     String d ="Vous n'etes pas participer encore! ";
    ErreurRechercheS.setText(d); 
}
    }
    
}
