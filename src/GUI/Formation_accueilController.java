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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tn.esprit.entity.Formation;
import tn.esprit.interfaces.Interface_IService;
import tn.esprit.services.FormationServices;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class Formation_accueilController implements Initializable {

    @FXML
    private ListView<Formation> list;
    @FXML
    private Button Ajouter_Formation0;
    @FXML
    private Button Modifier_Formation;
    @FXML
    private Button Supprimer_Formation;
    @FXML
    private Button Quitter_Formation;
    @FXML
    private TextField rechercheText;
    @FXML
    private Button Rechercher_Formation;

    /**
     * Initializes the controller class.
     */
    Interface_IService sp= new FormationServices(); 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
         // Set up the list view with custom cell factory
        list.setCellFactory(param -> new ListCell<Formation>() {
            @Override
            protected void updateItem(Formation item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setText(null);
                } else {
setText(item.getNom() + " - " + item.getNbreEtapes() + " - " + item.getDescription() + " - " + item.getStatut());
                }
            }
        });

        // Load the data for the list view
        FormationServices fs = new FormationServices();
        List<Formation> formations = fs.afficher();
        list.getItems().addAll(formations);
    }    

    @FXML
    private void Ajouter_Formation0(ActionEvent event) throws IOException {
          // Charger l'interface suivante à partir de son fichier FXML
         FXMLLoader loader = new FXMLLoader(getClass().getResource("Formation_ajouter.fxml"));

    // Create a new stage for the new view
    Stage stage = new Stage();
    stage.setScene(new Scene(loader.load()));

    // Show the new stage and hide the current stage
    stage.show();
    Stage currentStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    currentStage.hide();
    }

    @FXML
    private void Modifier_Formation(ActionEvent event) throws IOException {
          // Création d'un nouveau pack avec les valeurs saisies   
          FXMLLoader loader = new FXMLLoader(getClass().getResource("Formation_modifier.fxml"));

    // Create a new stage for the new view
    Stage stage = new Stage();
    stage.setScene(new Scene(loader.load()));
    
    Formation selectedFormation=list.getSelectionModel().getSelectedItem();
         Formation_modifierController Formation_modifierController=loader.getController();
        Formation_modifierController.getFormation(selectedFormation);
        Formation_modifierController.f=selectedFormation;
    // Show the new stage and hide the current stage
    stage.show();
    Stage currentStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    currentStage.hide();
    
    }

    @FXML
    private void Supprimer_Formation(ActionEvent event) {
         // Récupérer le pack sélectionné
    Formation formationSelectionne = list.getSelectionModel().getSelectedItem();

    if (formationSelectionne != null) {
        // Appeler le service pour supprimer le pack
        sp.supprimer(formationSelectionne.getId_formation());

        // Retirer le pack de la ListView
        list.getItems().remove(formationSelectionne);
    }
    }


    @FXML
    private void Quitter_Formation(ActionEvent event) {
            // Récupérer le stage actuel et le fermer
    Stage stage = (Stage) Quitter_Formation.getScene().getWindow();
    stage.close();
    }

    @FXML
    private void Rechercher_Formation(ActionEvent event) {
         // Récupérer l'ID de la fomation à rechercher depuis le champ de texte
    int idFormation = Integer.parseInt(rechercheText.getText());

    // Appeler le service pour récupérer la formation correspondant à l'ID
    Formation formationRecherche = (Formation) sp.readById(idFormation);

    if (formationRecherche != null) {
        // Afficher l formation trouvé dans la ListView
        ObservableList<Formation> Formations = FXCollections.observableArrayList(formationRecherche);
        list.setItems(Formations);
    } else {
        // Afficher un message d'erreur si la formation n'a pas été trouvé
        System.out.println("Formation non trouvée");
    }

    }
    
}
