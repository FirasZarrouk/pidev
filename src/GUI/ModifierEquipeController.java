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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
    private TextField ModifierTache;
    
    @FXML
    private Button Modifier_Equipe;
    @FXML
    private Button Annuler;
    
    private AnchorPane scenePane;
    
    Equipe E ;
    ServiceEquipe serviceEquipe = new ServiceEquipe();

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
        ModifierTache.setText(E.getTache());
    }

    @FXML
    private void Modifier_Equipe(ActionEvent event) {
        
        try {
            E.setNom_Equipe(ModifierEquipe.getText());
            E.setDescription(ModifierDesription.getText());
            E.setMembre(ModifierMembre.getText());
            E.setTache(ModifierTache.getText());
            
            serviceEquipe.modifier(E);
            
            FXMLLoader loader= new FXMLLoader(getClass().getResource("ListeEquipe.fxml"));
            Parent view_2=loader.load();
            Scene scene = new Scene(view_2);
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ModifierEquipeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    Stage stage;

    @FXML
    private void Annuler(ActionEvent event) {
        
        try {
            
            
            FXMLLoader loader= new FXMLLoader(getClass().getResource("listeEquipe.fxml"));
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
