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
import services.sponsorService ;
import models.sponsors;
/**
 * FXML Controller class
 *
 * @author ydorr
 */
public class AfficheSponsorController implements Initializable {
     services.sponsorService ss= new services.sponsorService();
    @FXML
    private Label nomSponsorLabel;
    @FXML
    private Button BoutonAjouterSponsor;
    @FXML
    private ListView<sponsors> listviewafficherS;
    @FXML
    private Button BoutonModifierSponsor;
    @FXML
    private Button BoutonSupprimerEvenemet;
    @FXML
    private Button BoutonQuitterSponsor;
    @FXML
    private Button BoutonAfficherSponsor;
    @FXML
    private Button BoutonRechercheSponsor;
    @FXML
    private TextField IDSponsorText;
    @FXML
    private Label erreurRechercheSponsor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjouterSponsort(ActionEvent event) throws IOException {
        
          FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterSponsor.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage)  BoutonAjouterSponsor.getScene().getWindow();
         // Modifier la scène de la fenêtre pour la nouvelle scène
        stage.setScene(scene);
         // Afficher la nouvelle interface
        stage.show();
                
        
        
    }

    @FXML
    private void ModifierSponsor(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierSponsor.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        sponsors selectedSponsor=listviewafficherS.getSelectionModel().getSelectedItem();
         ModifierSponsorController ModifierSponsorController=loader.getController();
        ModifierSponsorController.getSponsor(selectedSponsor);
        ModifierSponsorController.s =selectedSponsor ;
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage)  BoutonAjouterSponsor.getScene().getWindow();
         // Modifier la scène de la fenêtre pour la nouvelle scène
        stage.setScene(scene);
         // Afficher la nouvelle interface
        stage.show();
                

    }

    @FXML
    private void SupprimerSponsor(ActionEvent event) {
        // Récupérer le evenement sélectionné
    sponsors eventSelectionne = listviewafficherS.getSelectionModel().getSelectedItem();

    if (eventSelectionne != null) {
        // Appeler le service pour supprimer le event
        ss.supprimer(eventSelectionne.getID_sponsors());

        // Retirer le event de la ListView
        listviewafficherS.getItems().remove(eventSelectionne);}
    }

    @FXML
    private void QuitterSponsor(ActionEvent event) {
        Stage stage = (Stage) BoutonQuitterSponsor.getScene().getWindow();
    stage.close();
    }

    @FXML
    private void AfficherSponsor(ActionEvent event) {
        
        ObservableList<sponsors> Spons =FXCollections.observableArrayList(ss.afficher());
       listviewafficherS.setItems(Spons);
        
    }

    @FXML
    private void RechercheSponsor(ActionEvent event) {
          // Récupérer l'ID du sponsor à rechercher depuis le champ de texte
    int idSponsor = Integer.parseInt(IDSponsorText.getText());

    // Appeler le service pour récupérer le sponsor correspondant à l'ID
    sponsors sponsorsRecherche = (sponsors) ss.readById(idSponsor);

    if (sponsorsRecherche != null) {
        // Afficher le sponsors trouvé dans la ListView
        ObservableList<sponsors> sponsorss = FXCollections.observableArrayList(sponsorsRecherche);
        listviewafficherS.setItems(sponsorss);
    } else {
        // Afficher un message d'erreur si le sponsors n'a pas été trouvé dans le label erreurRechercheSponsor
        
            erreurRechercheSponsor.setText("Le sponsor n'existe pas ! ");

//         Alert a = new Alert(Alert.AlertType.WARNING);
//        a.setTitle("Evenement ajoutée");
//                 String content = String.format("Le sponsor n'existe pas ! ");
//        a.setContentText(content);
//                              
//        a.show();
        
        
    }
    }
    }
    

