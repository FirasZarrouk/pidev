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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Participant;
import models.evenements;
import services.participantServices;


/**
 * FXML Controller class
 *
 * @author ydorr
 */
public class AjouterParticipantsController implements Initializable {
    
    
    participantServices ps = new participantServices();
  Participant p = new Participant();
    
    @FXML
    private TextField NomParticipant;
    @FXML
    private TextField PrenomParticipant;
    @FXML
    private TextField RoleParticipant;
    @FXML
    private TextField NomEvenementP;
    @FXML
    private TextField IdEvenementParticipant;
    @FXML
    private Button RetournerP;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
      private boolean Validechamp(TextField T){
         if(T.getText().isEmpty() | T.getLength() <2 ){
          Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur de champ");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez vérifier votre saisie s'il vous plait!!");
            alert.showAndWait();
      return false;
    }return true;
}

    @FXML
    private void AjouterParticipant(ActionEvent event) {
        if (Validechamp(NomParticipant ) &&Validechamp(PrenomParticipant) &&Validechamp(RoleParticipant) &&Validechamp(NomEvenementP)){
        
        p.setNom(NomParticipant.getText());
        p.setPrenom(PrenomParticipant.getText());
        p.setRole(RoleParticipant.getText());
        
        evenements e = new evenements() ;
        e.setNom_ev(NomEvenementP.getText() );
        e.setID_ev(Integer.parseInt(IdEvenementParticipant.getText()));
        
        p.setNom_event(e);
        p.setEvent(e);
        ps.ajouter(p);
        
         Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Participant ajoutée");
                 String content = String.format("Le participant est ajoutée avec succés.");
        a.setContentText(content);
                              
        a.show();
        
        }
        
        
        
        
    }

    @FXML
    private void RetournerParticipantA(ActionEvent event) throws IOException {
        
        // Charger le fichier FXML de la nouvelle interface
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherParticipant.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) RetournerP.getScene().getWindow();
         // Modifier la scène de la fenêtre pour la nouvelle scène
        stage.setScene(scene);
         // Afficher la nouvelle interface
        stage.show();
        
        
    }
    
}
