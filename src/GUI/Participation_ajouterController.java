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
public class Participation_ajouterController implements Initializable {

    @FXML
    private TextField niveau;
    @FXML
    private TextField etat;
    @FXML
    private Button retour_participation;
    @FXML
    private Button ajouter_Participation;
    @FXML
    private TextField id_formation_Par;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void retour_participation(ActionEvent event) throws IOException {
           // Charger l'interface suivante à partir de son fichier FXML
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
    private void ajouter_Participation(ActionEvent event) {
         Participation p = new Participation();
       
        p.setNiveau(niveau.getText());
        p.setEtat(etat.getText());
        Formation F = new Formation();
        F.setId_formation(Integer.parseInt(id_formation_Par.getText()));
        p.setId_formation(F);
        
           ParticipationServices ps= new ParticipationServices();
           ps.ajouter(p);
    }
    
}
