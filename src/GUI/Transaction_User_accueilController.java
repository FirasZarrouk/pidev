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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Model.transaction;
import services.servicetransaction;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class Transaction_User_accueilController implements Initializable {

    @FXML
    private Button BoutonTrierTrans1;
    @FXML
    private Button BoutonQuitterTrans;
    @FXML
    private VBox scenepane;
    
       ArrayList<transaction> Transaction = new ArrayList<>();
    
    Interface_IService tr = new servicetransaction();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
           // TODO
        servicetransaction st = new servicetransaction();
           
       Transaction.addAll(st.afficher());
        // TODO
       
        
        Node [] nodes = new  Node[15];
        
        
        
        for(int i = 0; i<Transaction.size() ; i++)
        {
             
                
           
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Transaction_User.fxml"));
                AnchorPane abc = fxmlLoader.load();
                Transaction_UserController itemcontroller = fxmlLoader.getController();
                itemcontroller.getTrans(Transaction.get(i));
                scenepane.getChildren().add(abc);
            } catch (IOException ex) {
                Logger.getLogger(Transaction_accueilController.class.getName()).log(Level.SEVERE, null, ex);
            }
           
                
    
    }
    }    

    @FXML
    private void TrierTrans(ActionEvent event) {
         // Trier les transactions par date
    ArrayList<transaction> transactions = tr.sortBy("Date_trans", "ASC");

    // Effacer la vue actuelle des transactions
    scenepane.getChildren().clear();

    // Ajouter les transactions triées dans la vue
    for(int i = 0; i < transactions.size(); i++) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("Transaction_User.fxml"));
            AnchorPane abc = fxmlLoader.load();
            Transaction_UserController itemcontroller = fxmlLoader.getController();
            itemcontroller.getTrans(transactions.get(i));
            scenepane.getChildren().add(abc);
        } catch (IOException ex) {
            Logger.getLogger(Transaction_accueilController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
    

    @FXML
    private void QuitterTrans(ActionEvent event) throws IOException {
                // Charger l'interface suivante à partir de son fichier FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu_User.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) BoutonQuitterTrans.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
}
