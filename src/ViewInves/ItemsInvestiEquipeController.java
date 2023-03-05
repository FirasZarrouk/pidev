/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewInves;

import Model.Equipe;
import Services.ServiceEquipe;
import View.DetailsENequipeController;
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
public class ItemsInvestiEquipeController implements Initializable {

    @FXML
    private ImageView Imgqr;
    @FXML
    private Label NomEquipeIN;
    @FXML
    private Label MembresIN;
    @FXML
    private Label DescriptionEquipeIN;
    @FXML
    private Label idEquipeIN;
    @FXML
    private Button DetailsEIN;
    @FXML
    private AnchorPane abcddd;
    
    ServiceEquipe sp = new ServiceEquipe();
    public Equipe Equipe ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void getEquipe(Equipe E){
        idEquipeIN.setText(String.valueOf(E.getId_Equipe()));
        NomEquipeIN.setText(E.getNom_Equipe());
        
        DescriptionEquipeIN.setText(E.getDescription());
        MembresIN.setText(E.getMembre());
        
        
        Equipe=E;
        //System.out.println(Equipe);
    }
    
    Equipe E =new Equipe();

    @FXML
    private void DetailsEquipeIN(ActionEvent event) {
        
        try {
            FXMLLoader loader= new FXMLLoader(getClass().getResource("DetailsINequipe.fxml"));
            Parent view_2=loader.load();
            
            DetailsINequipeController detailscontroller= loader.getController();
            detailscontroller.getdetailsE(sp.readByName(NomEquipeIN.getText()));
            
            
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ItemsInvestiEquipeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}