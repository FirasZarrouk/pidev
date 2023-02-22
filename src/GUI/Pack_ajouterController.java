/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Pack;
import service.servicePack;
import Interface.Interface_IService;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class Pack_ajouterController implements Initializable {

    @FXML
    private Label nomPackLabel;
    @FXML
    private Label categoriePackLabel;
    @FXML
    private Label TarifPackLabel;
    @FXML
    private TextField nomPackText;
    @FXML
    private TextField categoriePackText;
    @FXML
    private TextField tarifPackText;
    @FXML
    private Button BoutonAjouterPack;
    servicePack sp = new servicePack();
    @FXML
    private Button BoutonRetourPack1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjouterPack(ActionEvent event) throws IOException {
        
//         Pack p = new Pack();
//              p.setNomPack(nomPackText.getText());
//              p.setCategorie(categoriePackText.getText());
//              p.setTarif(Float.parseFloat(tarifPackText.getText()));
//              sp.ajouter(p);

 // Récupérer les valeurs entrées dans les champs de texte
    String nom = nomPackText.getText();
    String categorie = categoriePackText.getText();
    String tarifStr = tarifPackText.getText();

    // Vérifier que les champs ne sont pas vides
    if (nom.isEmpty() || categorie.isEmpty() || tarifStr.isEmpty()) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez remplir tous les champs");
        alert.showAndWait();
        return;
    }

    // Vérifier que le tarif est un nombre valide
    float tarif;
        try {
        tarif = Float.parseFloat(tarifStr);
        if (tarif <= 0) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Le tarif doit être supérieur à zéro.");
            alert.showAndWait();
            return;
        }
    } catch (NumberFormatException e) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText("Le tarif doit être un nombre");
        alert.showAndWait();
        return;
    }

    // Créer un nouveau Pack et l'ajouter avec le servicePack
    Pack p = new Pack();
    p.setNomPack(nom);
    p.setCategorie(categorie);
    p.setTarif(tarif);
    sp.ajouter(p);

    // Afficher un message de confirmation
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Confirmation");
    alert.setHeaderText(null);
    alert.setContentText("Le pack a été ajouté avec succès");
    alert.showAndWait();
         
        
    }

    @FXML
    private void RetourrPack(ActionEvent event) throws IOException {
          // Charger l'interface suivante à partir de son fichier FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Pack_acceuil.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) BoutonRetourPack1.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
}
