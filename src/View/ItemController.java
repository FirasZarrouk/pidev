/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
public class ItemController implements Initializable {

    @FXML
    private ImageView image_item;
    @FXML
    private Label titre_item;
    @FXML
    private Label nbre_item;

    private Formation form;
    @FXML
    private Label cat_item;
    @FXML
    private Button decouvrir;
    /**
     * Initializes the controller class.
     */
    
    FormationServices fs = new FormationServices();
    @FXML
    private TextField vote;
    
    public void setData(Formation form){
        this.form=form;
        titre_item.setText(form.getTitre());
        nbre_item.setText(Integer.toString(form.getNbrPlaces()));
        Image image = new Image(getClass().getResourceAsStream(form.getImageSrc()));
        image_item.setImage(image);
        cat_item.setText(form.getCategorie());
        int totalVotes = fs.getTotalVotes(form);
        vote.setText(Integer.toString(totalVotes));
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void decouvrir(ActionEvent event) throws IOException {
          // Charger l'interface suivante à partir de son fichier FXML
         FXMLLoader loader = new FXMLLoader(getClass().getResource("Formation_details.fxml"));
         
    // Create a new stage for the new view
    Stage stage = new Stage();
    stage.setScene(new Scene(loader.load()));
    
    Formation_detailsController detailsController= loader.getController();
    detailsController.getFormation(fs.readByName(titre_item.getText()));

    // Show the new stage and hide the current stage
    stage.show();
    Stage currentStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    currentStage.hide();
    }
    
}
