/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Model.Equipe;
import Model.Projet;
import Services.ServiceEquipe;
import Services.ServiceProjet;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class ItemsEquipeController implements Initializable {

    @FXML
    private AnchorPane abcd;
    @FXML
    private Label NomEquipe;
    @FXML
    private ImageView Imgqr;
    @FXML
    private Button deletee;
    @FXML
    private Label Membres;
    @FXML
    private Label DescriptionEquipe;
    
    ServiceEquipe sp = new ServiceEquipe();
    public Equipe Equipe ;
    @FXML
    private Label idEquipe;
    @FXML
    private Label idEquipe1;
    @FXML
    private Button DetailsE;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void getEquipe(Equipe E){
        idEquipe.setText(String.valueOf(E.getId_Equipe()));
        NomEquipe.setText(E.getNom_Equipe());
        
        DescriptionEquipe.setText(E.getDescription());
        Membres.setText(E.getMembre());
        
        
        Equipe=E;
        //System.out.println(Equipe);
    }
    
    Equipe E =new Equipe();
    
    @FXML
    private void deletee(ActionEvent event) {
        
        try {
            sp.supprimer(Equipe.getId_Equipe());
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AceuilProjet.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            
            
            // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
            Stage stage = (Stage) deletee.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ItemsEquipeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    Stage stage;

    @FXML
    private void DetailsEquipe(ActionEvent event) {
        
        try {
            FXMLLoader loader= new FXMLLoader(getClass().getResource("DetailsEquipe.fxml"));
            Parent view_2=loader.load();
            
            DetailsEquipeController detailscontroller= loader.getController();
            detailscontroller.getdetailsE(sp.readByName(NomEquipe.getText()));
            
            
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ItemsEquipeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
