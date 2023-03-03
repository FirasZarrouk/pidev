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
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class DetailsEquipeController implements Initializable {

    @FXML
    private Label Nom_de_Equipe;
    @FXML
    private Label Membre_equipe;
    @FXML
    private Label Description_Equipe;
    @FXML
    private Button Retourrrr;
    @FXML
    private Button ModifierEE;
    ServiceEquipe sp = new ServiceEquipe();
    @FXML
    private Label iddetailsEquipe;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    public void getdetailsE(Equipe E){
        
        iddetailsEquipe.setText(String.valueOf(E.getId_Equipe()));
        Nom_de_Equipe.setText(E.getNom_Equipe());
        Membre_equipe.setText(E.getMembre());
        Description_Equipe.setText(E.getDescription());
        
       
        
    }

    @FXML
    private void RetourEE(ActionEvent event) {
        
        try {
            FXMLLoader loader= new FXMLLoader(getClass().getResource("AceuilEquipe.fxml"));
            Parent view_2=loader.load();
            
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(DetailsEquipeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ModifierEquipee(ActionEvent event) {
        
        try {
            Equipe selectedEquipe =(Equipe)
                    sp.readById(Integer.valueOf(iddetailsEquipe.getText()));
            
            
            FXMLLoader loader= new FXMLLoader(getClass().getResource("ModifierEquipe.fxml"));
            Parent view_2=loader.load();
            ModifierEquipeController ModifierEController=loader.getController();
            ModifierEController.getEquipe(selectedEquipe);
            ModifierEController.E=selectedEquipe;
            
            
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(DetailsEquipeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
