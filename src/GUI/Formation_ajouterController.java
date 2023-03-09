/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.sql.Date;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Model.Formation;
import services.FormationServices;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class Formation_ajouterController implements Initializable {

    
    @FXML
    private TextField Description;

    @FXML
    private Button ajouter_Formation;
    @FXML
    private Button Retour_Formation;
    @FXML
    private TextField titre_formation;
    @FXML
    private TextField NbrePlaces;
    @FXML
    private TextField prix;
    @FXML
    private ComboBox categorie_formation;
    @FXML
    private TextField lien;
    @FXML
    private TextField image;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> items = FXCollections.observableArrayList("Marketing", "Art","developpement web","Design Graphique","Cinema");

        // Set the items to the ComboBox
        categorie_formation.setItems(items);
    }    

   @FXML
private void ajouter_Formation(ActionEvent event) {
    Formation f = new Formation();
   
    f.setTitre(titre_formation.getText());
    f.setLien(lien.getText());
    f.setImageSrc(image.getText());
    f.setDescription(Description.getText());
    String selectedCategory = (String) categorie_formation.getValue();
    f.setCategorie(selectedCategory);
    int nbrePlaces = Integer.parseInt(NbrePlaces.getText());
    f.setNbrPlaces(nbrePlaces);
    float priix = Float.parseFloat(prix.getText());
    f.setPrix(priix);

    FormationServices fs= new FormationServices();
    fs.ajouter(f);
}


    @FXML
    private void Retour_Formation(ActionEvent event) throws IOException {
         // Charger l'interface suivante à partir de son fichier FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Formation_accueilAD.fxml"));

    // Create a new stage for the new view
    Stage stage = new Stage();
    stage.setScene(new Scene(loader.load()));

    // Show the new stage and hide the current stage
    stage.show();
    Stage currentStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    currentStage.hide();
    }


    
}