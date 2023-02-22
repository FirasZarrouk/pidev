/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Interfaces.Interface_IService;
import Model.Equipe;
import Model.Projet;
import Services.ServiceProjet;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author MSI
 */
public class AjouterPController implements Initializable {
    Interface_IService ServiceProjet = new ServiceProjet();


    @FXML
    private TextArea txtnom;
    @FXML
    private TextArea txtdescription;
    @FXML
    private TextArea txttechnologie;
    @FXML
    private TextArea txtcategorie;
    @FXML
    private DatePicker txtdate;
    @FXML
    private Button Ajouter_Projet;
    @FXML
    private ImageView imglogo;
    @FXML
    private TextField Id_Equipe;
    @FXML
    private Button Retour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    

    @FXML
    private void AjouterProjet(ActionEvent event) {
        
        if (txtnom.getText().length() == 0||txtdescription.getText().length() == 0||txttechnologie.getText().length() == 0||txtcategorie.getText().length() == 0||txtdate.getValue().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
            alert.setContentText("Please remplir tous les champs"+ "");
            alert.show();
            
        }else {
            try {
                Projet P=new Projet();
                P.setNom_Projet(txtnom.getText());
                P.setDescription(txtdescription.getText());
                P.setTechnologie(txttechnologie.getText());
                P.setCategorie(txtcategorie.getText());
                LocalDate D=txtdate.getValue();
                P.setDate_creation(java.sql.Date.valueOf(D));
                Equipe E = new Equipe() ;
                E.setId_Equipe(Integer.parseInt(Id_Equipe.getText()));
                P.setId_Equipe(E);
                
                
                ServiceProjet.ajouter(P);
                
                FXMLLoader loader= new FXMLLoader(getClass().getResource("listeP.fxml"));
                Parent view_2=loader.load();
                
                Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                Scene scene = new Scene(view_2);
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AjouterPController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }

    @FXML
    private void RetourA(ActionEvent event) {
        
        try {
            FXMLLoader loader= new FXMLLoader(getClass().getResource("ListeP.fxml"));
            Parent view_2=loader.load();
            
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AjouterPController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
