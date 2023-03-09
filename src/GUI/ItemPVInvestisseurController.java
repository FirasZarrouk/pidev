/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Model.PV;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import services.servicePV;


/**
 * FXML Controller class
 *
 * @author MSI
 */
public class ItemPVInvestisseurController implements Initializable {

    @FXML
    private Button verifierPV;
    @FXML
    private Label IDPV;
    @FXML
    private Label verifieritemPV;
    @FXML
    private Label commentaireitemPV;
    @FXML
    private Label dateitemPV;
    @FXML
    private Label IDR;
     public PV PVs;
    servicePV p = new servicePV();
    @FXML
    private AnchorPane add;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void getPV(PV E){


            
           
            commentaireitemPV.setText(E.getCommentaire());
            //this.evenements=EP;
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            String dateEnString = format.format(E.getDatePV()); 
            dateitemPV.setText(dateEnString);
            verifieritemPV.setText(E.getVerifier());


            PVs=E;

    }


    @FXML
    private void verifierPV(ActionEvent event) throws IOException {
        PV selectPVs =(PV) p.readById(PVs.getID_PV());
        selectPVs.setVerifier("Verifiée");
        p.modifier(selectPVs);
                FXMLLoader loader= new FXMLLoader(getClass().getResource("../GUI/afficherPVinvestisseur.fxml"));
                Parent root = loader.load();
        Scene scene = new Scene(root);

         // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage)  verifierPV.getScene().getWindow();
         // Modifier la scène de la fenêtre pour la nouvelle scène
        stage.setScene(scene);
         // Afficher la nouvelle interface
        stage.show();
    }
    
    

    
}
