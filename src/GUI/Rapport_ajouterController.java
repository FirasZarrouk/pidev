/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Interfaces.Interface_IService;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import Model.rapport_financier;
import Model.transaction;
import services.servicerapportfinancier;
import services.servicetransaction;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class Rapport_ajouterController implements Initializable {

    @FXML
    private Label typeRapLabel;
    private TextField typeRapText;
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
    private TextField IDtransRapText1;
    servicerapportfinancier srf = new servicerapportfinancier();
    @FXML
    private ChoiceBox<String> typeRapChoiceBox;
    @FXML
    private DatePicker date_debut_T_text;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {


        
     typeRapChoiceBox.getItems().add("Bilan annuel");
     typeRapChoiceBox.getItems().add("Bilan mensuel");
        // TODO
    }    
//     private Date ajouterAnnee(Date date) {
//    Calendar calendar = Calendar.getInstance();
//    calendar.setTime(date);
//    calendar.add(Calendar.YEAR, 1);
//    return new Date(calendar.getTimeInMillis());
//}
private LocalDate ajouterAnnee(LocalDate date) {
    return date.plusYears(1);
}
private LocalDate ajouterMois(LocalDate date) {
    return date.plusMonths(1);
}
//private Date ajouterMois(Date date) {
//    Calendar calendar = Calendar.getInstance();
//    calendar.setTime(date);
//    calendar.add(Calendar.MONTH, 1);
//    return new Date(calendar.getTimeInMillis());
//}
    @FXML
    private void AjouterRap(ActionEvent event) {
        

        
         
        
        try {
            String dateR = dateRapText.getValue().toString();
            String TypeRap = typeRapChoiceBox.getValue();
            String date_debut_T = date_debut_T_text.getValue().toString();
            
            
            // String Revenus = RevenusText.getText();
            //String Depences = DepenceText.getText();
            // String ID_trans = IDtransRapText1.getText();
            
            
            
            // Vérifier que les champs ne sont pas vides
            if (dateR.isEmpty() || TypeRap.isEmpty() || date_debut_T.isEmpty()       ) {
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
            LocalDate selectedDate1 = date_debut_T_text.getValue();
            if (selectedDate1.isAfter(LocalDate.now())) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText(null);
                alert.setContentText("La date saisie ne peut pas être postérieure à la date actuelle");
                alert.showAndWait();
                return;
            }
            
            
            // Créer un nouveau rapport et l'ajouter avec le servicerapport
            servicetransaction tr = new servicetransaction();
            rapport_financier r = new rapport_financier();
            Float Montant_revenus= tr.chercher_revenue(Date.valueOf(date_debut_T), TypeRap);
           
            System.out.println(Montant_revenus);
                Float Montant_depenses= tr.chercher_depense(Date.valueOf(date_debut_T), TypeRap);
            System.out.println(Montant_depenses);
           
           
            
            
    LocalDate d = dateRapText.getValue();
    r.setDate_rap(java.sql.Date.valueOf(d));
    r.setType_rap(TypeRap);
     LocalDate d1 = date_debut_T_text.getValue(); 
    r.setDate_debut_T(java.sql.Date.valueOf(d1));
    r.setDepences(Montant_depenses);
    r.setRevenus(Montant_revenus);
    Float resultat =Montant_revenus-Montant_depenses;
    r.setResultat(resultat);
    Float taxes = resultat*0.15f;
    r.setTaxes(taxes);
    srf.ajouter(r);



// Afficher un message de confirmation
Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Confirmation");
alert.setHeaderText(null);
alert.setContentText("Le rapport a été ajouté avec succès");
alert.showAndWait();
        } catch (SQLException ex) {
            Logger.getLogger(Rapport_ajouterController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
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
    

