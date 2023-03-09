/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class Admin_menuController implements Initializable {

    @FXML
    private Label nomPackLabel;
    @FXML
    private Button Menu_Pack;
    @FXML
    private Button Menu_Facture;
    @FXML
    private Button Menu_Etat_financier;
    @FXML
    private Button Menu_Quitter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Menu_PackA(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Pack_acceuil.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) Menu_Pack.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void Menu_FactureA(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("Transaction_accueil.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) Menu_Facture.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void Menu_Etat_financierA(ActionEvent event) throws IOException {
             FXMLLoader loader = new FXMLLoader(getClass().getResource("Rapport_accueil.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) Menu_Etat_financier.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void Menu_QuitterA(ActionEvent event) throws IOException {
                // Récupérer le stage actuel et le fermer
    FXMLLoader loader = new FXMLLoader(getClass().getResource("ADMINHOME.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) Menu_Quitter.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
}
