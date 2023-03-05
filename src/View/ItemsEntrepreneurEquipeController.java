/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import GUI.DetailsEquipeController;
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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class ItemsEntrepreneurEquipeController implements Initializable {

    @FXML
    private ImageView Imgqr;
    @FXML
    private Label NomEquipeEN;
    @FXML
    private Label MembresEN;
    @FXML
    private Label DescriptionEquipeEN;
    @FXML
    private Button DetailsEEN;
    @FXML
    private AnchorPane abcdd;
    
    ServiceEquipe sp = new ServiceEquipe();
    public Equipe Equipe ;
    @FXML
    private Label idEquipeEN;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    public void getEquipe(Equipe E){
        idEquipeEN.setText(String.valueOf(E.getId_Equipe()));
        NomEquipeEN.setText(E.getNom_Equipe());
        
        DescriptionEquipeEN.setText(E.getDescription());
        MembresEN.setText(E.getMembre());
        
        
        Equipe=E;
        //System.out.println(Equipe);
    }
    
    Equipe E =new Equipe();
    
    

    @FXML
    private void DetailsEquipeEN(ActionEvent event) {
        
        try {
            FXMLLoader loader= new FXMLLoader(getClass().getResource("DetailsENequipe.fxml"));
            Parent view_2=loader.load();
            
            DetailsENequipeController detailscontroller= loader.getController();
            detailscontroller.getdetailsE(sp.readByName(NomEquipeEN.getText()));
            
            
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ItemsEntrepreneurEquipeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
}
