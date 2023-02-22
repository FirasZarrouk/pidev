/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class ModifierPController implements Initializable {

    @FXML
    private TextField txtNomP;
    @FXML
    private TextField txtDescriptionP;
    @FXML
    private TextField txttechnologieP;
    @FXML
    private TextField txtcategorieP;
    @FXML
    private Button Modifier_Projet;
    Projet p;
    
    ServiceProjet serviceProjet=new ServiceProjet();
    @FXML
    private Button Annuler;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    void getProjet(Projet P){
        
        txtNomP.setText(P.getNom_Projet());
        txtDescriptionP.setText(P.getDescription());
        txttechnologieP.setText(P.getTechnologie());
        txtcategorieP.setText(P.getCategorie());
        
    }

    @FXML
    private void Modifier_Projet(ActionEvent event) {
        
        try {
            p.setNom_Projet(txtNomP.getText());
            p.setDescription(txtDescriptionP.getText());
            p.setTechnologie(txttechnologieP.getText());
            p.setCategorie(txtcategorieP.getText());
            
            serviceProjet.modifier(p);
            
            FXMLLoader loader= new FXMLLoader(getClass().getResource("listeP.fxml"));
            Parent view_2=loader.load();
            Scene scene = new Scene(view_2);
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ModifierPController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        Stage stage;
    @FXML
    private void Annuler_Projet(ActionEvent event) {
        
        try {
            
            
            FXMLLoader loader= new FXMLLoader(getClass().getResource("listeP.fxml"));
            Parent view_2=loader.load();
            
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ModifierPController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
