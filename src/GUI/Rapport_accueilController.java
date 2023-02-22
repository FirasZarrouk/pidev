/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Interface.Interface_IService;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.rapport_financier;
import service.servicerapportfinancier;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class Rapport_accueilController implements Initializable {

    @FXML
    private Label nomPackLabel;
    @FXML
    private Button BoutonAjouterRapport;
    @FXML
    private ListView<rapport_financier> listviewafficherR;
    @FXML
    private Button BoutonModifierRapport;
    @FXML
    private Button BoutonSupprimerRapport;
    @FXML
    private Button BoutonQuitterRapport;
    @FXML
    private Button BoutonAfficherRapport;
    @FXML
    private Button BoutonRechercheRapport;
    @FXML
    private TextField IDRapportText;
       Interface_IService sr= new servicerapportfinancier(); 


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjouterRapport(ActionEvent event) throws IOException {
           // Charger l'interface suivante à partir de son fichier FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Rapport_ajouter.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) BoutonAjouterRapport.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void ModifierRapport(ActionEvent event) throws IOException {
        // Charger l'interface suivante à partir de son fichier FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Rapport_modifier.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        rapport_financier selectedrapport_financier = listviewafficherR.getSelectionModel().getSelectedItem();
        Rapport_modifierController Rapport_modifierController=loader.getController();
        Rapport_modifierController.getRapport(selectedrapport_financier);
        Rapport_modifierController.r=selectedrapport_financier;
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) BoutonModifierRapport.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void SupprimerRapport(ActionEvent event) {
          // Récupérer le pack sélectionné
    rapport_financier rapport_financierSelectionne = listviewafficherR.getSelectionModel().getSelectedItem();

    if (rapport_financierSelectionne != null) {
        // Appeler le service pour supprimer le pack
        sr.supprimer(rapport_financierSelectionne.getID_rap());

        // Retirer le pack de la ListView
        listviewafficherR.getItems().remove(rapport_financierSelectionne);
    }
    }

    @FXML
    private void QuitterRapporr(ActionEvent event) {
            // Récupérer le stage actuel et le fermer
    Stage stage = (Stage) BoutonQuitterRapport.getScene().getWindow();
    stage.close();
    }

    @FXML
    private void AfficherRapport(ActionEvent event) {
           ObservableList<rapport_financier> rapport_financiers =FXCollections.observableArrayList(sr.afficher());
       listviewafficherR.setItems(rapport_financiers);

    }

    @FXML
    private void RechercheRapport(ActionEvent event) {
          // Récupérer l'ID du pack à rechercher depuis le champ de texte
    int idRapport = Integer.parseInt(IDRapportText.getText());

    // Appeler le service pour récupérer le pack correspondant à l'ID
    rapport_financier rapport_financierRecherche = (rapport_financier) sr.readById(idRapport);

    if (rapport_financierRecherche != null) {
        // Afficher le pack trouvé dans la ListView
        ObservableList<rapport_financier> rapport_financiers = FXCollections.observableArrayList(rapport_financierRecherche);
        listviewafficherR.setItems(rapport_financiers);
    } else {
        // Afficher un message d'erreur si le pack n'a pas été trouvé
        System.out.println("Rapport financier non trouvé");
    }
    }
    
}
