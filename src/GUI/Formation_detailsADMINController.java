/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.Formation_modifierController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import Model.Formation;
import services.FormationServices;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class Formation_detailsADMINController implements Initializable {

    @FXML
    private Label titreFor;
    @FXML
    private Label catFor;
    @FXML
    private Label lienFor;
    @FXML
    private Label descri;
    @FXML
    private Label nombre;
    @FXML
    private Label prix;
    @FXML
    private Button retour;
    @FXML
    private Button modifier;
    @FXML
    private Label id;

    FormationServices fs = new FormationServices();
    public Formation f;
    @FXML
    private ImageView image2;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    void getFormation(Formation f){
    id.setText(String.valueOf(f.getId_formation()));
    titreFor.setText(f.getTitre());
    lienFor.setText(f.getLien());
    descri.setText(f.getDescription());
    catFor.setText(f.getCategorie());
    nombre.setText(Integer.toString(f.getNbrPlaces()));   
    prix.setText(Float.toString(f.getPrix()));
    /*Image image = new Image(getClass().getResourceAsStream(f.getImageSrc()));
    image.setImage(image);*/
    Image image = new Image(getClass().getResourceAsStream(f.getImageSrc()));
        image2.setImage(image);

    // Afficher l'image
    /*File imageFile = new File(f.getImageSrc());
    Image image = new Image(imageFile.toURI().toString());
    image.setImage(image);*/
}

    @FXML
    private void retour(ActionEvent event) throws IOException {
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

    @FXML
    private void modifier(ActionEvent event) {
        try {
            
            
            Formation selectedForm =(Formation)
             fs.readById(Integer.valueOf(id.getText()));
            
            
            FXMLLoader loader= new FXMLLoader(getClass().getResource("Formation_modifier.fxml"));
            Parent view_2=loader.load();
            Formation_modifierController ModifierForm=loader.getController();
            ModifierForm.getFormation(selectedForm);
            ModifierForm.f=selectedForm;
            
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Formation_detailsADMINController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}