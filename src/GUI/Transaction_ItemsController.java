/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Interfaces.Interface_IService;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import Model.transaction;
import services.servicetransaction;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class Transaction_ItemsController implements Initializable {

    @FXML
    private Label IDRap;
    @FXML
    private DatePicker DateTrans;
    @FXML
    private Button BouttonSupp;
    @FXML
    private AnchorPane abc;
    //private ChoiceBox<String> typeTransChoiceBox;
    @FXML
    private TextField montantTrans;
        Interface_IService st= new servicetransaction();
    @FXML
    private TextField typeTransChoice;


    /**
     * Initializes the controller class.
     */
     void getTrans(transaction t){
         
    IDRap.setText(String.valueOf(t.getID_trans()));
    DateTrans.setValue(t.getDate_trans().toLocalDate());
        montantTrans.setText(Float.toString(t.getMontant()));
    typeTransChoice.setText(t.getType_trans());
    //typeTransChoiceBox.setValue(t.getType_trans());
    
  }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void SuppItems(ActionEvent event) throws IOException {
         st.supprimer(Integer.valueOf(IDRap.getText()));
         
       FXMLLoader loader = new FXMLLoader(getClass().getResource("Transaction_accueil.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
       
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) BouttonSupp.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    private void bouttonMod(ActionEvent event) throws IOException {
     
        transaction selectedtransaction= (transaction) 
                st.readById(Integer.valueOf(IDRap.getText()));
        
        
        //bonPlanService.update(bonPlanService.readById(selectedId));
        FXMLLoader loader= new FXMLLoader(getClass().getResource("Transaction_modifier.fxml"));
        Parent view_2=loader.load();
        Transaction_modifierController ModifierController=loader.getController();
        ModifierController.gettransaction(selectedtransaction);
        ModifierController.t=selectedtransaction;
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(view_2);
        stage.setScene(scene);
        stage.show();
   
    }
    }
    

