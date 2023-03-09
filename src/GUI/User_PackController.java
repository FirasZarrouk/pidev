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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Model.Pack;
import Model.SessionManager;
import services.servicePack;


/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class User_PackController implements Initializable {

    private Button BoutonQuitterPack111;
    @FXML
    private VBox scenepane;
    Interface_IService sp= new servicePack(); 
   ArrayList<Pack> Pack = new ArrayList<>();
   Pack p = new Pack();
    @FXML
    private Button BoutonQuitterPack1111;
//    private ChoiceBox<String> RoleUChoiceBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//     RoleUChoiceBox.getItems().add("Entrepreneur");
//     RoleUChoiceBox.getItems().add("Investisseur");
//        // TODO
          servicePack spp = new servicePack();
          String role = SessionManager.getInstance().getCurrentUser().getRole();

       Pack.addAll(spp.readByROLE(role));
        // TODO
       scenepane.getChildren().clear();
        
        Node [] nodes = new  Node[15];
        
        
        
        
        
            for (int i=0; i<Pack.size(); i++)
        {
             
                
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("User_Pack_Items.fxml"));
                AnchorPane abc = fxmlLoader.load();
                User_Pack_ItemsController itemcontroller = fxmlLoader.getController();
                itemcontroller.getPack(Pack.get(i));
                scenepane.getChildren().add(abc);
            }
            // TODO
            catch (IOException ex) {
                Logger.getLogger(Rapport_accueilController.class.getName()).log(Level.SEVERE, null, ex);
            }
                
    
           
        } 
    }    

    @FXML
    private void QuitterPack(ActionEvent event) throws IOException {
     FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu_User.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) BoutonQuitterPack1111.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    

    
}
