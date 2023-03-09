/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import services.FormationServices;
import Model.Formation;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class Formation_modifierController implements Initializable {

  
    @FXML
    private TextField nbre_modifier;
    @FXML
    private TextField description_modifier;
    
    @FXML
    private Button retour_modifier;
    @FXML
    private Button modifier_modifier;
     @FXML
    private TextField titre_modifier;
    @FXML
    private TextField prix_modifier;
    @FXML
    private ComboBox combo_modifier;
    
     Formation f = new Formation();
     FormationServices sp = new FormationServices();
     
    @FXML
    private TextField lien_modifier;
    @FXML
    private TextField image_modifier;
    
   ObservableList<String> items = FXCollections.observableArrayList("Marketing", "Art","developpement web","Design Graphique","Cinema");
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         //ObservableList<String> items = FXCollections.observableArrayList("Marketing", "Art","developpement web","Design Graphique","Cinema");

        // Set the items to the ComboBox
        combo_modifier.setItems(items);
    }    

    void getFormation(Formation f){
    titre_modifier.setText(f.getTitre());
    lien_modifier.setText(f.getLien());
    image_modifier.setText(f.getImageSrc());
    description_modifier.setText(f.getDescription());
    /*String selectedCategory = (String) combo_modifier.getValue();
    f.setCategorie(selectedCategory);*/
    combo_modifier.setValue(f.getCategorie());
    /*java.sql.Date dateDebut = java.sql.Date.valueOf(dateD_modifier.getValue());
    f.setDate_debut(dateDebut);
    java.sql.Date dateFin = java.sql.Date.valueOf(dateF_modifier.getValue());
    f.setDate_fin(dateFin);*/
    nbre_modifier.setText(Integer.toString(f.getNbrPlaces()));   
    prix_modifier.setText(Float.toString(f.getPrix()));
}
    
    @FXML
    private void retour_modifier(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("Formation_detailsADMIN.fxml"));

    // Create a new stage for the new view
    Stage stage = new Stage();
    stage.setScene(new Scene(loader.load()));

    // Show the new stage and hide the current stage
    stage.show();
    Stage currentStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    currentStage.hide();
    }

    @FXML
    private void modifier_modifier(ActionEvent event) {
          // Récupérer les valeurs entrées dans les champs de texte
    String Titre = titre_modifier.getText();
    String lien = lien_modifier.getText();
    String image = image_modifier.getText();
    String Description = description_modifier.getText();
    String selectedCategory = (String) combo_modifier.getValue();
    String nbrPlaces = nbre_modifier.getText();
    String prix = prix_modifier.getText();

    // Vérifier que les champs ne sont pas vides
    if (Titre.isEmpty() || lien.isEmpty() || image.isEmpty()|| Description.isEmpty() || nbrPlaces.isEmpty()  || prix.isEmpty() || selectedCategory.isEmpty()) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez remplir tous les champs");
        alert.showAndWait();
        return;
    }

    // Vérifier que le nombre de places est un nombre valide
    int nbre;
        try {
nbre = Integer.parseInt(nbrPlaces);
        if (nbre <= 0) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Le nombre de places doit être supérieur à zéro.");
            alert.showAndWait();
            return;
        }
    } catch (NumberFormatException e) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText("Le nombre de places doit être un nombre");
        alert.showAndWait();
        return;
    }
        float priix;
        priix = Float.parseFloat(prix);
        
        // Récupérer les valeurs des champs de date
    /*java.sql.Date dateDebut = java.sql.Date.valueOf(dateD_modifier.getValue());
    java.sql.Date dateFin = java.sql.Date.valueOf(dateF_modifier.getValue());*/
    
    // Créer une nouvelle formation et l'ajouter avec le FormationServices
    f.setTitre(Titre);
    f.setLien(lien);
    f.setImageSrc(image);
    f.setDescription(Description);
    f.setCategorie(selectedCategory);
    /*f.setDate_debut(dateDebut);
    f.setDate_fin(dateFin);*/
    f.setNbrPlaces(nbre);
    f.setPrix(priix);
    sp.modifier(f);

    // Afficher un message de confirmation
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Confirmation");
    alert.setHeaderText(null);
    alert.setContentText("La formation a été modifié avec succès");
    alert.showAndWait();
    }
    
}
