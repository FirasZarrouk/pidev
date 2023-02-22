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
import models.evenements;
import services.EventService ;

/**
 * FXML Controller class
 *
 * @author ydorr
 */
public class AfficheEvenementController implements Initializable {
 EventService es= new EventService();
    @FXML
    private Label nomEvenementLabel;
    @FXML
    private Button BoutonAjouterEvenement;
    @FXML
    private ListView<evenements> listviewafficherE;
    @FXML
    private Button BoutonModifierEvenement;
    @FXML
    private Button BoutonSupprimerEvenemet;
    @FXML
    private Button BoutonQuitterEvenement;
    @FXML
    private Button BoutonAfficherEvenement;
    @FXML
    private Button BoutonRechercheEvenement;
    @FXML
    private TextField IDEvent1Text;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjouterEvenementt(ActionEvent event) throws IOException {
        
        // Charger le fichier FXML de la nouvelle interface
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ajouterEvenement.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage)  BoutonAfficherEvenement.getScene().getWindow();
         // Modifier la scène de la fenêtre pour la nouvelle scène
        stage.setScene(scene);
         // Afficher la nouvelle interface
        stage.show();
        
        
    }

    @FXML
    private void ModifierEvenement(ActionEvent event) throws IOException  {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("modifierEvenement.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        evenements selectedEvenemet=listviewafficherE.getSelectionModel().getSelectedItem();
         ModifierEvenementController ModifierEvenementController=loader.getController();
        ModifierEvenementController.getEvenement(selectedEvenemet);
        ModifierEvenementController.e=selectedEvenemet;
        
        
        
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage)  BoutonModifierEvenement.getScene().getWindow();
         // Modifier la scène de la fenêtre pour la nouvelle scène
        stage.setScene(scene);
         // Afficher la nouvelle interface
        stage.show();
    
    }
    

    @FXML
    private void SupprimerEvenement(ActionEvent event) {
        
         // Récupérer le evenement sélectionné
    evenements eventSelectionne = listviewafficherE.getSelectionModel().getSelectedItem();

    if (eventSelectionne != null) {
        // Appeler le service pour supprimer le event
        es.supprimer(eventSelectionne.getID_ev());

        // Retirer le event de la ListView
        listviewafficherE.getItems().remove(eventSelectionne);
        
    }}

    @FXML
    private void QuitterEvenement(ActionEvent event) {
   Stage stage = (Stage) BoutonQuitterEvenement.getScene().getWindow();
    stage.close();
    }

    @FXML
    private void AfficherEvenement(ActionEvent event) {
        
            ObservableList<evenements> Events =FXCollections.observableArrayList(es.afficher());
       listviewafficherE.setItems(Events);
        
    }

    @FXML
    private void RechercheEvenement(ActionEvent event) {
           // Récupérer l'ID du evenement à rechercher depuis le champ de texte
    int idevenement = Integer.parseInt(IDEvent1Text.getText());

    // Appeler le service pour récupérer le evenement correspondant à l'ID
    evenements evenementsRecherche = (evenements) es.readById(idevenement);

    if (evenementsRecherche != null) {
        // Afficher le evenements trouvé dans la ListView
        ObservableList<evenements> evenementss = FXCollections.observableArrayList(evenementsRecherche);
        listviewafficherE.setItems(evenementss);
    } else {
        // Afficher un message d'erreur si le evenements n'a pas été trouvé dans le label erreurRechercheevenement
        
           // erreurRechercheevenement.setText("Le evenement n'existe pas ! ");

         Alert a = new Alert(Alert.AlertType.WARNING);
        a.setTitle("Evenement ajoutée");
                 String content = String.format("Le evenement n'existe pas ! ");
        a.setContentText(content);
                              
        a.show();
    }
    
    }
}
