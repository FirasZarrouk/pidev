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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tn.esprit.entity.Formation;
import tn.esprit.services.FormationServices;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class Formation_ajouterController implements Initializable {

    @FXML
    private TextField nom_formation;
    @FXML
    private TextField NbreEtapes;
    @FXML
    private TextField Description;
    @FXML
    private TextField statut;
    @FXML
    private Button ajouter_Formation;
    @FXML
    private Button Retour_Formation;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouter_Formation(ActionEvent event) {
        Formation f = new Formation();
       
        f.setNom(nom_formation.getText());
        int nbreEtapes = Integer.parseInt(NbreEtapes.getText());
        f.setNbreEtapes(nbreEtapes);
        f.setDescription(Description.getText());
        f.setStatut(statut.getText());
        
           FormationServices fs= new FormationServices();
           fs.ajouter(f);
    }

    @FXML
    private void Retour_Formation(ActionEvent event) throws IOException {
         // Charger l'interface suivante à partir de son fichier FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Formation_accueil.fxml"));

    // Create a new stage for the new view
    Stage stage = new Stage();
    stage.setScene(new Scene(loader.load()));

    // Show the new stage and hide the current stage
    stage.show();
    Stage currentStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    currentStage.hide();
    }


    
}
