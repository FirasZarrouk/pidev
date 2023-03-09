/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Interfaces.Interface_IService;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Model.rapport_financier;
import services.servicerapportfinancier;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class Rapport_accueilController implements Initializable {

    @FXML
    private Button BoutonAjouterRapport;
    @FXML
    private Button BoutonQuitterRapport;
       Interface_IService sr= new servicerapportfinancier(); 
       ArrayList<rapport_financier> Rapport = new ArrayList<>();
    
    @FXML
    private VBox scenepane;
    @FXML
    private Button BouttonTrier;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        servicerapportfinancier srf = new servicerapportfinancier ();
           
       Rapport.addAll(srf.afficher());
        // TODO
       
        
        Node [] nodes = new  Node[15];
        
        
        
        for(int i = 0; i<Rapport.size() ; i++)
        {
             
                
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Rapport_Items.fxml"));
                AnchorPane abc = fxmlLoader.load();
                Rapport_ItemsController itemcontroller = fxmlLoader.getController();
                itemcontroller.getRapport(Rapport.get(i));
                scenepane.getChildren().add(abc);
            }
            // TODO
            catch (IOException ex) {
                Logger.getLogger(Rapport_accueilController.class.getName()).log(Level.SEVERE, null, ex);
            }
                
    
           
        }  
        
        
        
        
    }    

    @FXML
    private void AjouterRapport(ActionEvent event) throws IOException {
           // Charger l'interface suivante à partir de son fichier FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Rapport_ajouter.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) BoutonAjouterRapport.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
   
    @FXML
    private void QuitterRapporr(ActionEvent event) throws IOException {
          // Charger l'interface suivante à partir de son fichier FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Admin_menu.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) BoutonQuitterRapport.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void TrierRapp(ActionEvent event) {
    // Trier les transactions par date
    ArrayList<rapport_financier> Rapport = sr.sortBy("date_rap", "ASC");

    // Effacer la vue actuelle des transactions
    scenepane.getChildren().clear();

    // Ajouter les transactions triées dans la vue
    for(int i = 0; i < Rapport.size(); i++) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("Rapport_Items.fxml"));
            AnchorPane abc = fxmlLoader.load();
            Rapport_ItemsController itemcontroller = fxmlLoader.getController();
            itemcontroller.getRapport(Rapport.get(i));
            scenepane.getChildren().add(abc);
        } catch (IOException ex) {
            Logger.getLogger(Transaction_accueilController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
        
        
        
    }

    

