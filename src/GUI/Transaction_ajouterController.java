/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Model.SessionManager;

import Model.transaction;
import services.servicetransaction;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class Transaction_ajouterController implements Initializable {

    @FXML
    private Label dateTransLabel;
    @FXML
    private Label MontantTransLabel;
    @FXML
    private Label TypeTransLabel;
    @FXML
    private DatePicker dateTransText;
    @FXML
    private TextField MontantTransText;
    private TextField TypeTransText;
    @FXML
    private Button BoutonAjouterTrans;
    @FXML
    private Button BoutonRetourTrans;
    servicetransaction st = new servicetransaction();
    @FXML
    private ChoiceBox<String> TypeTransChoiceBox;
    


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    TypeTransChoiceBox.getItems().add("Transaction de revenus");
    TypeTransChoiceBox.getItems().add("Transaction de depenses");

        // TODO
    }    

    @FXML
    private void AjouterTransaction(ActionEvent event) {
     
    String date = dateTransText.getValue().toString();
    
    String montantTrans = MontantTransText.getText();    
    String TypeTrans = TypeTransChoiceBox.getValue();
    

    // Vérifier que les champs ne sont pas vides
    if (date.isEmpty() || montantTrans.isEmpty() || TypeTrans.isEmpty()) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez remplir tous les champs");
        alert.showAndWait();
        return;
    }
    
      LocalDate selectedDate = dateTransText.getValue();
    if (selectedDate.isAfter(LocalDate.now())) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText("La date saisie ne peut pas être postérieure à la date actuelle");
        alert.showAndWait();
        return;
    }

    // Vérifier que le tarif est un nombre valide
    float montant;
        try {
        montant = Float.parseFloat(montantTrans);
        if (montant <= 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Le montant doit être supérieur à zéro.");
            alert.showAndWait();
            return;
        }
    } catch (NumberFormatException e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText("Le montant doit être un nombre");
        alert.showAndWait();
        return;
    }

    // Créer un nouveau Pack et l'ajouter avec le servicePack
    transaction t = new transaction();
    LocalDate d = dateTransText.getValue(); 
    t.setDate_trans(java.sql.Date.valueOf(d));
    t.setMontant(montant);
    t.setType_trans(TypeTrans);
//    Wallet w = new Wallet();
//    int id = Integer.parseInt(ID_W);
//    w.setId_wallet(id);
//    t.setWallet(w);
    t.setId(SessionManager.getInstance().getCurrentUser());
    
   
    
   
    st.ajouter(t);

       
    // Afficher un message de confirmation
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Confirmation");
    alert.setHeaderText(null);
    alert.setContentText("La transaction a été ajoutée avec succès");
    alert.showAndWait();
         
    }

    @FXML
    private void RetourTrans(ActionEvent event) throws IOException {
           // Charger l'interface suivante à partir de son fichier FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Transaction_accueil.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) BoutonRetourTrans.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
         
    }
    
}
