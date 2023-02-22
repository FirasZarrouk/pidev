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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.rapport_financier;
import model.transaction;
import service.servicerapportfinancier;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class Rapport_ajouterController implements Initializable {

    @FXML
    private Label typeRapLabel;
    @FXML
    private Label RevenusLabel;
    @FXML
    private Label DepencesLabel;
    @FXML
    private TextField typeRapText;
    @FXML
    private TextField RevenusText;
    @FXML
    private TextField DepenceText;
    @FXML
    private Button BoutonAjouterRap;
    @FXML
    private Button BoutonRetourRap;
    @FXML
    private Label dateTransLabel;
    @FXML
    private DatePicker dateRapText;
    @FXML
    private Label IDtransRapLabel1;
    @FXML
    private TextField IDtransRapText1;
    servicerapportfinancier srf = new servicerapportfinancier();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjouterRap(ActionEvent event) {
    String dateR = dateRapText.getValue().toString();
    String TypeRap = typeRapText.getText();

    String Revenus = RevenusText.getText();  
    String Depences = DepenceText.getText(); 
    String ID_trans = IDtransRapText1.getText();    



    // Vérifier que les champs ne sont pas vides
    if (dateR.isEmpty() || TypeRap.isEmpty() || Revenus.isEmpty() || Depences.isEmpty() || ID_trans.isEmpty()       ) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez remplir tous les champs");
        alert.showAndWait();
        return;
    }
    
        LocalDate selectedDate = dateRapText.getValue();
    if (selectedDate.isAfter(LocalDate.now())) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText("La date saisie ne peut pas être postérieure à la date actuelle");
        alert.showAndWait();
        return;
    }

    // Vérifier que le tarif est un nombre valide
    float RevenusR;

        try {
        RevenusR = Float.parseFloat(Revenus);
                

        if (RevenusR <= 0) {
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
          // Vérifier que le depences est un nombre valide
   
        float DepencesR;

        try {
        
                DepencesR = Float.parseFloat(Depences);

        if  (DepencesR <= 0) {
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
   
    rapport_financier r = new rapport_financier();
    LocalDate d = dateRapText.getValue(); 
    r.setDate_rap(java.sql.Date.valueOf(d));
    r.setType_rap(TypeRap);
    r.setRevenus(RevenusR);
    r.setDepences(DepencesR);
    
      transaction tr = new transaction();
      tr.setID_trans(Integer.parseInt(ID_trans));
                    
      r.setTransaction(tr);
    
    srf.ajouter(r);

    // Afficher un message de confirmation
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Confirmation");
    alert.setHeaderText(null);
    alert.setContentText("Le rapport a été ajouté avec succès");
    alert.showAndWait();
         
    }

    @FXML
    private void RetourrRap(ActionEvent event) throws IOException {
          // Charger l'interface suivante à partir de son fichier FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Rapport_accueil.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) BoutonRetourRap.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
}
