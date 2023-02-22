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
import model.transaction;
import service.servicetransaction;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class Transaction_accueilController implements Initializable {

    @FXML
    private Label nomPackLabel;
   
    @FXML
    private Button BoutonRechercheTrans;
    @FXML
    private TextField IDTransText;
    @FXML
    private Button BoutonAjouterTrans;
    @FXML
    private Button BoutonModifierTrans;
    @FXML
    private Button BoutonSupprimerTrans;
    @FXML
    private Button BoutonQuitterTrans;
    @FXML
    private Button BoutonAfficherTrans;
    @FXML
    private ListView<transaction> listviewafficherT;
    Interface_IService tr = new servicetransaction();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

  
   

    @FXML
    private void AjouterTrans(ActionEvent event) throws IOException {
          // Charger l'interface suivante à partir de son fichier FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Transaction_ajouter.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) BoutonAjouterTrans.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void ModifierTrans(ActionEvent event) throws IOException {
        
        // Charger l'interface suivante à partir de son fichier FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Transaction_modifier.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        transaction selectedtransaction=listviewafficherT.getSelectionModel().getSelectedItem();
         Transaction_modifierController Transaction_modifierController=loader.getController();
        Transaction_modifierController.gettransaction(selectedtransaction);
        Transaction_modifierController.t=selectedtransaction;
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) BoutonModifierTrans.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void SupprimerTrans(ActionEvent event) {
            // Récupérer le pack sélectionné
    transaction transactionSelectionne = listviewafficherT.getSelectionModel().getSelectedItem();

    if (transactionSelectionne != null) {
        // Appeler le service pour supprimer le pack
        tr.supprimer(transactionSelectionne.getID_trans());

        // Retirer le pack de la ListView
        listviewafficherT.getItems().remove(transactionSelectionne);
    }
    }

    @FXML
    private void QuitterTrans(ActionEvent event) {
           // Récupérer le stage actuel et le fermer
    Stage stage = (Stage) BoutonQuitterTrans.getScene().getWindow();
    stage.close();
    }

    @FXML
    private void AfficherTrans(ActionEvent event) {
          ObservableList<transaction> transactions =FXCollections.observableArrayList(tr.afficher());
       listviewafficherT.setItems(transactions);
    }
     @FXML
    private void RechercheTrans(ActionEvent event) {
         // Récupérer l'ID du pack à rechercher depuis le champ de texte
    int idTrans = Integer.parseInt(IDTransText.getText());

    // Appeler le service pour récupérer le pack correspondant à l'ID
    transaction transactionRecherche = (transaction) tr.readById(idTrans);

    if (transactionRecherche != null) {
        // Afficher le pack trouvé dans la ListView
        ObservableList<transaction> transactions =FXCollections.observableArrayList(transactionRecherche);
       listviewafficherT.setItems(transactions);
    } else {
        // Afficher un message d'erreur si le pack n'a pas été trouvé
        System.out.println("Transaction non trouvée");
    }
    }

}
