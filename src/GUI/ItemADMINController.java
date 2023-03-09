/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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
public class ItemADMINController implements Initializable {

    @FXML
    private ImageView image_item;
    @FXML
    private Label titre_item;
    @FXML
    private Label nbre_item;
    @FXML
    private Label cat_item;
    @FXML
    private Button details;
    
    private Formation form;

    /**
     * Initializes the controller class.
     */
     FormationServices fs = new FormationServices();
    @FXML
    private Button supprimer_item;
    @FXML
    private Label id_item;
     
    public void setData(Formation form){
        this.form=form;
        id_item.setText(String.valueOf(form.getId_formation()));
        titre_item.setText(form.getTitre());
        nbre_item.setText(Integer.toString(form.getNbrPlaces()));
              Image image = new Image(getClass().getResourceAsStream(form.getImageSrc()));
       image_item.setImage(image);
        cat_item.setText(form.getCategorie());
   }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void details(ActionEvent event) throws IOException {
         // Charger l'interface suivante à partir de son fichier FXML
         FXMLLoader loader = new FXMLLoader(getClass().getResource("Formation_detailsADMIN.fxml"));
         
    // Create a new stage for the new view
    Stage stage = new Stage();
    stage.setScene(new Scene(loader.load()));
    
    GUI.Formation_detailsADMINController detailsController= loader.getController();
    detailsController.getFormation(fs.readByName(titre_item.getText()));

    // Show the new stage and hide the current stage
    stage.show();
    Stage currentStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    currentStage.hide();
    }

    @FXML
    private void supprimer_item(ActionEvent event) {
         try {
        fs.supprimer(Integer.valueOf(id_item.getText()));
        FXMLLoader loader= new FXMLLoader(getClass().getResource("Formation_accueilAD.fxml"));
        Parent view_2=loader.load();
        
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(view_2);
        stage.setScene(scene);
        stage.show();
        // afficher_garage(event);
    } catch (IOException ex) {
        Logger.getLogger(ItemADMINController.class.getName()).log(Level.SEVERE, null, ex);
    }
   
    }
    
}
