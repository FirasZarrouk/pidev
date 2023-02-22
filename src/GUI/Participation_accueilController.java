/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tn.esprit.entity.Formation;
import tn.esprit.entity.Participation;
import tn.esprit.interfaces.Interface_IService;
import tn.esprit.services.FormationServices;
import tn.esprit.services.ParticipationServices;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class Participation_accueilController implements Initializable {

    @FXML
    private TextField recherche_text_par;
    @FXML
    private ListView<Participation> list2;
    @FXML
    private Button recherche_par;
    @FXML
    private Button ajouter_par;
    @FXML
    private Button modifier_par;
    @FXML
    private Button supprimer_par;
    @FXML
    private Button quitter_par;

    /**
     * Initializes the controller class.
     */
    Interface_IService sp= new ParticipationServices(); 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        list2.setCellFactory(param -> new ListCell<Participation>() {
            @Override
            protected void updateItem(Participation item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setText(null);
                } else {
setText(item.getNiveau()+ " - " + item.getEtat());
                }
            }
        });

        // Load the data for the list view
        ParticipationServices ps = new ParticipationServices();
        List<Participation> participations = ps.afficher();
        list2.getItems().addAll(participations);
    }    

    @FXML
    private void recherche_par(ActionEvent event) {
            // Récupérer l'ID de la fomation à rechercher depuis le champ de texte
    int idParticipation = Integer.parseInt(recherche_text_par.getText());

    // Appeler le service pour récupérer la formation correspondant à l'ID
    Participation participationRecherche = (Participation) sp.readById(idParticipation);

    if (participationRecherche != null) {
        // Afficher l formation trouvé dans la ListView
        ObservableList<Participation> Participations = FXCollections.observableArrayList(participationRecherche);
        list2.setItems(Participations);
    } else {
        // Afficher un message d'erreur si la formation n'a pas été trouvé
        System.out.println("Participation non trouvée");
    }
    }

    @FXML
    private void ajouter_par(ActionEvent event) throws IOException {
         // Charger l'interface suivante à partir de son fichier FXML
         FXMLLoader loader = new FXMLLoader(getClass().getResource("Participation_ajouter.fxml"));

    // Create a new stage for the new view
    Stage stage = new Stage();
    stage.setScene(new Scene(loader.load()));

    // Show the new stage and hide the current stage
    stage.show();
    Stage currentStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    currentStage.hide();
    }

    @FXML
    private void modifier_par(ActionEvent event) throws IOException {
        // Création d'un nouveau pack avec les valeurs saisies   
          FXMLLoader loader = new FXMLLoader(getClass().getResource("Participation_modifier.fxml"));

    // Create a new stage for the new view
    Stage stage = new Stage();
    stage.setScene(new Scene(loader.load()));
    
    Participation selectedParticipation=list2.getSelectionModel().getSelectedItem();
        Participation_modifierController Participation_modifierController=loader.getController();
        Participation_modifierController.getParticipation(selectedParticipation);
        Participation_modifierController.p=selectedParticipation;
    // Show the new stage and hide the current stage
    stage.show();
    Stage currentStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    currentStage.hide();
    }

    @FXML
    private void supprimer_par(ActionEvent event) {
         Participation participationSelectionne = list2.getSelectionModel().getSelectedItem();

    if (participationSelectionne != null) {
        // Appeler le service pour supprimer le pack
        sp.supprimer(participationSelectionne.getId_participation());

        // Retirer le pack de la ListView
        list2.getItems().remove(participationSelectionne);
    }
    }

    @FXML
    private void quitter_par(ActionEvent event) {
          // Récupérer le stage actuel et le fermer
    Stage stage = (Stage) quitter_par.getScene().getWindow();
    stage.close();
    }
    
}
