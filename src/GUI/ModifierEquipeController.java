/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Model.Equipe;
import Services.ServiceEquipe;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class ModifierEquipeController implements Initializable {
    
    @FXML
    private TextField ModifierEquipe;
    @FXML
    private TextField ModifierDesription;
    
    @FXML
    private TextField ModifierMembre;
    
    @FXML
    private Button Modifier_Equipe;
    @FXML
    private Button Annuler;
    
    private AnchorPane scenePane;
    public Equipe Equipe;
    Equipe E ;
    ServiceEquipe serviceEquipe = new ServiceEquipe();
    @FXML
    private ImageView imglogo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    void getEquipe(Equipe E){
        ModifierEquipe.setText(E.getNom_Equipe());
        ModifierDesription.setText(E.getDescription());
        ModifierMembre.setText(E.getMembre());
        
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
    private void Modifier_Equipe(ActionEvent event) {
        
        if (Validechamp(ModifierEquipe) &&Validechamp(ModifierDesription) &&Validechamp(ModifierMembre)){
        
        try {
            E.setNom_Equipe(ModifierEquipe.getText());
            E.setDescription(ModifierDesription.getText());
            E.setMembre(ModifierMembre.getText());
            
            
            serviceEquipe.modifier(E);
            
            FXMLLoader loader= new FXMLLoader(getClass().getResource("AceuilProjet.fxml"));
            Parent view_2=loader.load();
            Scene scene = new Scene(view_2);
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ModifierEquipeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }
    }
    
    Stage stage;

    @FXML
    private void Annuler(ActionEvent event) {
        
        try {
            
            
            FXMLLoader loader= new FXMLLoader(getClass().getResource("AceuilProjet.fxml"));
            Parent view_2=loader.load();
            
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ModifierEquipeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
