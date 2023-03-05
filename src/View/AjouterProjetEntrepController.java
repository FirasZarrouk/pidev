/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

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
public class AjouterProjetEntrepController implements Initializable {
    @FXML
    private ImageView imglogo;
    @FXML
    private TextArea txtnomEN;
    @FXML
    private TextArea txtdescriptionEN;
    @FXML
    private TextArea txttechnologieEN;
    @FXML
    private TextArea txtcategorieEN;
    @FXML
    private DatePicker txtdateEN;
    @FXML
    private Button Ajouter_ProjetEN;
    @FXML
    private TextField Id_EquipeEN;
    @FXML
    private Button RetourEN;
    @FXML
    private TextField txtTacheEN;
    Interface_IService ServiceProjet = new ServiceProjet();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    private boolean Validechamp(TextArea T){
         if(T.getText().isEmpty() | T.getLength() <2 ){
          Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur de champ");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez vérifier votre saisie s'il vous plait!!");
            alert.showAndWait();
      return false;
    }return true;
}
    private boolean ValidDate() {
         
        if (txtdateEN.getValue().compareTo(LocalDate.now()) < 0 ){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur de champ");
            alert.setHeaderText(null);
            alert.setContentText("La date ne doit pas etre fixer avant la date actuelle");
            alert.showAndWait();
            return false;
        } return true ;
     }

    @FXML
    private void AjouterProjetEN(ActionEvent event) {
        
        if (Validechamp(txtnomEN) && Validechamp(txtdescriptionEN) && Validechamp(txttechnologieEN) && ValidDate()
                 && Validechamp(txtcategorieEN)){
        
        try {
            Projet P=new Projet();
            P.setNom_Projet(txtnomEN.getText());
            P.setDescription(txtdescriptionEN.getText());
            P.setTechnologie(txttechnologieEN.getText());
            P.setCategorie(txtcategorieEN.getText());
            P.setTache_de_projet(txtTacheEN.getText());
            LocalDate D=txtdateEN.getValue();
            P.setDate_creation(java.sql.Date.valueOf(D));
            Equipe E = new Equipe() ;
            E.setId_Equipe(Integer.parseInt(Id_EquipeEN.getText()));
            P.setId_Equipe(E);
            
            
            ServiceProjet.ajouter(P);
            
            FXMLLoader loader= new FXMLLoader(getClass().getResource("HomeEntrepreneur.fxml"));
            Parent view_2=loader.load();
            
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AjouterProjetEntrepController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
    @FXML
    private void RetourEN(ActionEvent event) {
        
        try {
            FXMLLoader loader= new FXMLLoader(getClass().getResource("HomeEntrepreneur.fxml"));
            Parent view_2=loader.load();
            
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AjouterProjetEntrepController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
