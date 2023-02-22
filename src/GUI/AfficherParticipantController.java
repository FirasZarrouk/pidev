/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Participant;
import services.participantServices;

/**
 * FXML Controller class
 *
 * @author ydorr
 */
public class AfficherParticipantController implements Initializable {
 participantServices ps = new participantServices();
  Participant p = new Participant();
 
    @FXML
    private Label nomParticipantLabel;
    @FXML
    private Button BoutonAjouterParticipant;
    @FXML
    private Button BoutonModifierParticipant;
    @FXML
    private Button BoutonSupprimerEvenemet;
    @FXML
    private Button BoutonQuitterParticipant;
    @FXML
    private Button BoutonAfficherParticipant;
    @FXML
    private Button BoutonRechercheParticipant;
    @FXML
    private ListView<Participant> listviewafficherP;
    @FXML
    private TextField IDParticipantText;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjouterParticipantt(ActionEvent event) throws IOException {
        
        
        // Charger le fichier FXML de la nouvelle interface
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterParticipants.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage)  BoutonAjouterParticipant.getScene().getWindow();
         // Modifier la scène de la fenêtre pour la nouvelle scène
        stage.setScene(scene);
         // Afficher la nouvelle interface
        stage.show();
        
    }

    @FXML
    private void ModifierParticipant(ActionEvent event) throws IOException {
        
        
        // Charger le fichier FXML de la nouvelle interface
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierParticipant.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        Participant selectedParticipant=listviewafficherP.getSelectionModel().getSelectedItem();
         ModifierParticipantsController ModifierParticipantController=loader.getController();
        ModifierParticipantController.getParticipant(selectedParticipant);
        ModifierParticipantController.p =selectedParticipant ;
        
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage)  BoutonModifierParticipant.getScene().getWindow();
         // Modifier la scène de la fenêtre pour la nouvelle scène
        stage.setScene(scene);
         // Afficher la nouvelle interface
        stage.show();
        
    }

    @FXML
    private void SupprimerParticipant(ActionEvent event) {
        
          // Récupérer le evenement sélectionné
    Participant participantSelectionne = listviewafficherP.getSelectionModel().getSelectedItem();

    if (participantSelectionne != null) {
        // Appeler le service pour supprimer le participant
        ps.supprimer(participantSelectionne.getID_part());

        // Retirer le participant de la ListView
        listviewafficherP.getItems().remove(participantSelectionne);
    }
    }

    @FXML
    private void QuitterParticipant(ActionEvent event) {
        Stage stage = (Stage) BoutonQuitterParticipant.getScene().getWindow();
    stage.close();
        
    }

    @FXML
    private void AfficherParticipant(ActionEvent event) {
        
        ObservableList<Participant> Events =FXCollections.observableArrayList(ps.afficher());
       listviewafficherP.setItems(Events);
        
    }

    @FXML
    private void RechercheParticipant(ActionEvent event) {
        
         // Récupérer l'ID du participant à rechercher depuis le champ de texte
    int idParticipant = Integer.parseInt(IDParticipantText.getText());

    // Appeler le service pour récupérer le Participant correspondant à l'ID
    Participant ParticipantsRecherche = (Participant) ps.readById(idParticipant);

    if (ParticipantsRecherche != null) {
        // Afficher le Participants trouvé dans la ListView
        ObservableList<Participant> Participantss = FXCollections.observableArrayList(ParticipantsRecherche);
        listviewafficherP.setItems(Participantss);
    } else {
        // Afficher un message d'erreur si le Participants n'a pas été trouvé dans le label erreurRechercheParticipant
        
           // erreurRechercheParticipant.setText("Le Participant n'existe pas ! ");

         Alert a = new Alert(Alert.AlertType.WARNING);
        a.setTitle("Participant ajoutée");
                 String content = String.format("Le Participant n'existe pas ! ");
        a.setContentText(content);
                              
        a.show();
    }
        
    }
    
}
