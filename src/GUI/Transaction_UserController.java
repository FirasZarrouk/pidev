/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import Model.transaction;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class Transaction_UserController implements Initializable {

    @FXML
    private TextField montantTrans;
    @FXML
    private TextField typeTransChoice;
    @FXML
    private TextField Date_Trans;
    @FXML
    private AnchorPane abc;

    /**
     * Initializes the controller class.
     */
     void getTrans(transaction t){
         
   
    Date_Trans.setText(t.getDate_trans().toLocalDate().toString());
        montantTrans.setText(Float.toString(t.getMontant()));
    typeTransChoice.setText(t.getType_trans());
    //typeTransChoiceBox.setValue(t.getType_trans());
    
  }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
