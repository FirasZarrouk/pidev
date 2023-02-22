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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tn.esprit.services.FormationServices;
import tn.esprit.entity.Formation;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class Formation_modifierController implements Initializable {

    @FXML
    private TextField nom_modifier;
    @FXML
    private TextField nbre_modifier;
    @FXML
    private TextField description_modifier;
    @FXML
    private TextField statut_modifier;
    @FXML
    private Button retour_modifier;
    @FXML
    private Button modifier_modifier;
     Formation f = new Formation();

    /**
     * Initializes the controller class.
     */
    FormationServices sp = new FormationServices();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    void getFormation(Formation f){
    nom_modifier.setText(f.getNom());
    nbre_modifier.setText(Integer.toString(f.getNbreEtapes()));   
    description_modifier.setText(f.getDescription());
    statut_modifier.setText(f.getStatut());
}
    
    @FXML
    private void retour_modifier(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("Formation_accueil.fxml"));

    // Create a new stage for the new view
    Stage stage = new Stage();
    stage.setScene(new Scene(loader.load()));

    // Show the new stage and hide the current stage
    stage.show();
    Stage currentStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    currentStage.hide();
    }

    @FXML
    private void modifier_modifier(ActionEvent event) {
          // Récupérer les valeurs entrées dans les champs de texte
    String Nom = nom_modifier.getText();
    String nbreEtapes = nbre_modifier.getText();
    String Description = description_modifier.getText();
    String statut = statut_modifier.getText();

    // Vérifier que les champs ne sont pas vides
    if (Nom.isEmpty() || nbreEtapes.isEmpty() || Description.isEmpty()  || statut.isEmpty()) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez remplir tous les champs");
        alert.showAndWait();
        return;
    }

    // Vérifier que le nombre d etapes est un nombre valide
    int nbre;
        try {
nbre = Integer.parseInt(nbreEtapes);
        if (nbre <= 0) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Le nombre d etapes doit être supérieur à zéro.");
            alert.showAndWait();
            return;
        }
    } catch (NumberFormatException e) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText("Le nombre d etapes doit être un nombre");
        alert.showAndWait();
        return;
    }

    // Créer une nouvelle formation et l'ajouter avec le FormationServices
    f.setNom(Nom);
    f.setNbreEtapes(nbre);
    f.setDescription(Description);
    f.setStatut(statut);
    sp.modifier(f);

    // Afficher un message de confirmation
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Confirmation");
    alert.setHeaderText(null);
    alert.setContentText("La formation a été modifié avec succès");
    alert.showAndWait();
    }
    
}
