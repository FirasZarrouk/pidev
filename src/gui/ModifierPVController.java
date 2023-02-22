/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.PV;
import models.reunion;
import services.servicePV;

/**
 * FXML Controller class
 *
 * @author afifa
 */
public class ModifierPVController implements Initializable {

    @FXML
    private TextField nompv1;
    @FXML
    private TextField commentairepv1;
    @FXML
    private TextField prenompv1;
    @FXML
    private DatePicker datepv1;
    @FXML
    private Button ajouterpv1;
    @FXML
    private TextField IDpv1;
    @FXML
    private Button retourmodifpv;
    @FXML
    private TextField IDpv2;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void modifierpv(ActionEvent event) {
         PV r = new PV();
        r.setID_PV(Integer.parseInt(IDpv2.getText()));
        r.setNom(nompv1.getText());
        r.setPrenom(prenompv1.getText());
        LocalDate d = datepv1.getValue(); 
        r.setDate(java.sql.Date.valueOf(d));
        r.setCommentaire(commentairepv1.getText());
        reunion re = new reunion();
        re.setId_reunion(Integer.parseInt(IDpv1.getText()));
        r.setId_reunion(re);
           servicePV sr= new servicePV();
           sr.ajouter(r);
//             Alert a = new Alert(Alert.AlertType.CONFIRMATION);
//        a.setTitle("Localisation ajoutée");
//        a.show();
//        
    }

    @FXML
    private void retourauajoutpv(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ajouterPV.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) retourmodifpv.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
}
