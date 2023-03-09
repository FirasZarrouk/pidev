/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import GUI.Formation_modifierController;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import Model.Formation;
import Model.Participation;
import Model.SessionManager;
import Model.User;
import services.FormationServices;
import services.ParticipationServices;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class Formation_detailsController implements Initializable {

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
    private Button participer;
    @FXML
    private Button retour;
    @FXML
    private Label idFor;
    @FXML
    private ImageView image2;

    FormationServices fs = new FormationServices();
    public Formation f;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    
     /*void getFormation(Formation f){
    titreFor.setText(f.getTitre());
    lienFor.setText(f.getLien());
    Image image = new Image(getClass().getResourceAsStream(f.getImageSrc()));
    image.setImage(image);
    File imageFile = new File(f.getImageSrc());
    Image image = new Image(imageFile.toURI().toString());
    image.setImage(image);
    descri.setText(f.getDescription());
    String selectedCategory = (String) catFor.getText();
    f.setCategorie(selectedCategory);
    /*java.sql.Date dateDebut = java.sql.Date.valueOf(dateD_modifier.getValue());
    f.setDate_debut(dateDebut);
    java.sql.Date dateFin = java.sql.Date.valueOf(dateF_modifier.getValue());
    f.setDate_fin(dateFin);
    nombre.setText(Integer.toString(f.getNbrPlaces()));   
    prix.setText(Float.toString(f.getPrix()));
}*/

    void getFormation(Formation f){
    idFor.setText(Integer.toString(f.getId_formation()));
    titreFor.setText(f.getTitre());
    lienFor.setText(f.getLien());
    descri.setText(f.getDescription());
    catFor.setText(f.getCategorie());
    nombre.setText(Integer.toString(f.getNbrPlaces()));   
    prix.setText(Float.toString(f.getPrix()));
    // Afficher l'image
    Image image = new Image(getClass().getResourceAsStream(f.getImageSrc()));
    image2.setImage(image);
}


    
    @FXML
    private void participer(ActionEvent event) throws IOException {
        
        Formation selectedForm =(Formation)
             fs.readById(Integer.valueOf(idFor.getText()));
        
                    //p.setId(SessionManager.getInstance().getCurrentUser());

        
    Participation p = new Participation();
    Formation F = new Formation();
    User U = new User();
    p.setForm(F);
    //F.getId_formation();
    p.setUser(U);
    //U.setId(1); 
    p.setUser(SessionManager.getInstance().getCurrentUser());
    F.setId_formation(Integer.parseInt(idFor.getText()));  
   // Set the date to the Participation object
    /*LocalDate datee = date.getValue();
    Date date = java.sql.Date.valueOf(datee);
    p.setDate(date);*/
    LocalDate d1 = LocalDate.now();
    p.setDate(java.sql.Date.valueOf(d1));

    // Add new participation entry to database
    
    ParticipationServices ps = new ParticipationServices();
    ps.ajouter(p);
    //
     FXMLLoader loader = new FXMLLoader(getClass().getResource("payeeerr.fxml"));
      Parent view_2=loader.load();
      PayeeerrController ModifierForm=loader.getController();
      ModifierForm.getFormation(selectedForm);
      ModifierForm.f=selectedForm;
    // Create a new stage for the new view
    Stage stage = new Stage();
    stage.setScene(new Scene(view_2));

    // Show the new stage and hide the current stage
    stage.show();
    Stage currentStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    currentStage.hide();
    
    }


    @FXML
    private void retour(ActionEvent event) throws IOException {
         // Charger l'interface suivante à partir de son fichier FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Formation_accueil2.fxml"));

    // Create a new stage for the new view
    Stage stage = new Stage();
    stage.setScene(new Scene(loader.load()));

    // Show the new stage and hide the current stage
    stage.show();
    Stage currentStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    currentStage.hide();
    }

    
}
