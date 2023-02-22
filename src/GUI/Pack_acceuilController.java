/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Interface.Interface_IService;
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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Pack;
import service.servicePack;


/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class Pack_acceuilController implements Initializable {

    @FXML
    private Label nomPackLabel;
    @FXML
    private Button BoutonAjouterPack;
    @FXML
    private Button BoutonModifierPack1;
    @FXML
    private Button BoutonSupprimerPack11;
    @FXML
    private Button BoutonQuitterPack111;
    @FXML
    private Button BoutonAfficherPack112;
   
   Interface_IService sp= new servicePack(); 
   
    @FXML
    private ListView<Pack> listviewafficher;
    @FXML
    private Button BoutonRecherchePack;
    @FXML
    private TextField IDPackText;
    
    


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      
    }    

    @FXML
    private void AjouterPack(ActionEvent event) throws IOException {
        // Charger l'interface suivante à partir de son fichier FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Pack_ajouter.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) BoutonAjouterPack.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void ModifierPack(ActionEvent event) throws IOException {
       
       

// Charger l'interface suivante à partir de son fichier FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Pack_modifier.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Pack selectedPack=listviewafficher.getSelectionModel().getSelectedItem();
         Pack_modifierController Pack_modifierController=loader.getController();
        Pack_modifierController.getPack(selectedPack);
        Pack_modifierController.p=selectedPack;
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) BoutonModifierPack1.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void SupprimerPack(ActionEvent event) {
         // Récupérer le pack sélectionné
    Pack packSelectionne = listviewafficher.getSelectionModel().getSelectedItem();

    if (packSelectionne != null) {
        // Appeler le service pour supprimer le pack
        sp.supprimer(packSelectionne.getID_Pack());

        // Retirer le pack de la ListView
        listviewafficher.getItems().remove(packSelectionne);
    }
    }

    @FXML
    private void QuitterPack(ActionEvent event) {
        // Récupérer le stage actuel et le fermer
    Stage stage = (Stage) BoutonQuitterPack111.getScene().getWindow();
    stage.close();
    }

    @FXML
    private void AfficherPack(ActionEvent event) {
        ObservableList<Pack> Packs =FXCollections.observableArrayList(sp.afficher());
       listviewafficher.setItems(Packs);

       
    }

    @FXML
    private void RecherchePack(ActionEvent event) {
         // Récupérer l'ID du pack à rechercher depuis le champ de texte
    int idPack = Integer.parseInt(IDPackText.getText());

    // Appeler le service pour récupérer le pack correspondant à l'ID
    Pack packRecherche = (Pack) sp.readById(idPack);

    if (packRecherche != null) {
        // Afficher le pack trouvé dans la ListView
        ObservableList<Pack> Packs = FXCollections.observableArrayList(packRecherche);
        listviewafficher.setItems(Packs);
    } else {
        // Afficher un message d'erreur si le pack n'a pas été trouvé
        System.out.println("Pack non trouvé");
    }
    }
    
}
