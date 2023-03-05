/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Projet;
import Services.ServiceProjet;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class ModifierProjetEntrepController implements Initializable {
    @FXML
    private ImageView imglogo;
    @FXML
    private TextField txtNomEN;
    @FXML
    private TextField txtDescriptionEN;
    @FXML
    private TextField txttechnologieEN;
    @FXML
    private TextField txtcategorieEN;
    @FXML
    private Button Modifier_ProjetEN;
    @FXML
    private TextField txttacheEN;
    @FXML
    private Button AnnulerEN;
    
    public Projet p;
    public Projet projet ;
    
    ServiceProjet serviceProjet=new ServiceProjet();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void getProjet(Projet P){
        
        txtNomEN.setText(P.getNom_Projet());
        txtDescriptionEN.setText(P.getDescription());
        txttechnologieEN.setText(P.getTechnologie());
        txtcategorieEN.setText(P.getCategorie());
        txttacheEN.setText(P.getTache_de_projet());
        
        
    }
    
    private boolean Validechamp(TextField T){
         if(T.getText().isEmpty() | T.getLength() <2 ){
          Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur de champ");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez vérifier votre saisie s'il vous plait!!");
            alert.showAndWait();
      return false;
    }return true;
}

    @FXML
    private void Modifier_ProjetEN(ActionEvent event) {
        
        if (Validechamp(txtNomEN) &&Validechamp(txtDescriptionEN) &&Validechamp(txttechnologieEN)
                &&Validechamp(txtcategorieEN)&&Validechamp(txttacheEN)){
        
        try {
            p.setNom_Projet(txtNomEN.getText());
            p.setDescription(txtDescriptionEN.getText());
            p.setTechnologie(txttechnologieEN.getText());
            p.setCategorie(txtcategorieEN.getText());
            p.setTache_de_projet(txttacheEN.getText());
            
            serviceProjet.modifier(p);
            
            FXMLLoader loader= new FXMLLoader(getClass().getResource("HomeEntrepreneur.fxml"));
            Parent view_2=loader.load();
            Scene scene = new Scene(view_2);
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ModifierProjetEntrepController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
    
    Stage stage;

    @FXML
    private void Annuler_ProjetEN(ActionEvent event) {
        
        try {
            FXMLLoader loader= new FXMLLoader(getClass().getResource("HomeEntrepreneur.fxml"));
            Parent view_2=loader.load();
            
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ModifierProjetEntrepController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
