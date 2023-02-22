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
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tn.esprit.entity.Formation;
import tn.esprit.entity.Participation;
import tn.esprit.services.FormationServices;
import tn.esprit.services.ParticipationServices;



/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class Participation_modifierController implements Initializable {

    @FXML
    private TextField niveau_modifier;
    @FXML
    private TextField etat_modifier;
    @FXML
    private Button retour_modifierPar;
    @FXML
    private Button modifier_modifierPar;
    
Participation p = new Participation();

    /**
     * Initializes the controller class.
     */
ParticipationServices sp = new ParticipationServices();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    void getParticipation(Participation p){
    niveau_modifier.setText(p.getNiveau());
    etat_modifier.setText(p.getEtat());
}

    @FXML
    private void retour_modifierPar(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("Participation_accueil.fxml"));

    // Create a new stage for the new view
    Stage stage = new Stage();
    stage.setScene(new Scene(loader.load()));

    // Show the new stage and hide the current stage
    stage.show();
    Stage currentStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    currentStage.hide();
    }

    @FXML
    private void modifier_modifierPar(ActionEvent event) {
          // Récupérer les valeurs entrées dans les champs de texte
    String niveau = niveau_modifier.getText();
    String etat = etat_modifier.getText();

    // Vérifier que les champs ne sont pas vides
    if (niveau.isEmpty() || etat.isEmpty() ) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez remplir tous les champs");
        alert.showAndWait();
        return;
    }

    // Créer une nouvelle participation et l'ajouter avec le ParticipationServices
    p.setNiveau(niveau);
    p.setEtat(etat);
    sp.modifier(p);

    // Afficher un message de confirmation
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Confirmation");
    alert.setHeaderText(null);
    alert.setContentText("La participation a été modifié avec succès");
    alert.showAndWait();
    }
    
}
