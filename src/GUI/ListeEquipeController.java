

package GUI;

import Interfaces.Interface_IService;
import Model.Equipe;
import Model.Projet;
import Services.ServiceEquipe;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class ListeEquipeController implements Initializable {
    
    Interface_IService ServiceEquipe = new ServiceEquipe();

    @FXML
    private ListView<Equipe> AfficherE;
    @FXML
    private Button AjouterEquipe;
    @FXML
    private Button AfficherEquipe;
    @FXML
    private Button SupprimerE;
    @FXML
    private Button ModifierE;
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
    private void Ajouter_Equipe(ActionEvent event) {
        
        try {
            FXMLLoader loader= new FXMLLoader(getClass().getResource("AjouterEquipe.fxml"));
            Parent view_2=loader.load();
            
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
        } catch (IOException ex) {
            Logger.getLogger(ListeEquipeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @FXML
    private void Afficher_Equipe(ActionEvent event) {
        
        ObservableList<Equipe> Equipes =FXCollections.observableArrayList(ServiceEquipe.afficher());
       AfficherE.setItems(Equipes);
    }

    @FXML
    private void Supprimer_Equipe(ActionEvent event) {
        
        int selectedId= AfficherE.getSelectionModel().getSelectedItem().getId_Equipe();
        ServiceEquipe.supprimer(selectedId);
        Afficher_Equipe(event);
    }

    @FXML
    private void Modifier_Equipe(ActionEvent event) {
        
        try {
            Equipe selectedEquipe=AfficherE.getSelectionModel().getSelectedItem();
            
            
            FXMLLoader loader= new FXMLLoader(getClass().getResource("ModifierEquipe.fxml"));
            Parent view_2=loader.load();
            ModifierEquipeController ModifierEquipeController=loader.getController();
            ModifierEquipeController.getEquipe(selectedEquipe);
            ModifierEquipeController.E=selectedEquipe;
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListeEquipeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Retour(ActionEvent event) {
        
        try {
            FXMLLoader loader= new FXMLLoader(getClass().getResource("ListeP.fxml"));
            Parent view_2=loader.load();
            
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListeEquipeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
