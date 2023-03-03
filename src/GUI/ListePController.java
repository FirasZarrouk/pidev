


package GUI;

import Interfaces.Interface_IService;
import Model.Projet;
import Services.ServiceProjet;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class ListePController implements Initializable {
    
        Interface_IService ServiceProjet = new ServiceProjet();


    @FXML
    private Button Modifier;
    @FXML
    private Button Supprimer;
    @FXML
    private Button AfficherP;
    @FXML
    private Button AjouterP;
    @FXML
    private ListView<Projet> Afficher;
    @FXML
    private Button Quitter;
    @FXML
    private AnchorPane scenePane;
    @FXML
    private Button Recherche;
    @FXML
    private TextField Idrechercher;
    @FXML
    private Button listeEquipe;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
                 

    }    
    
    @FXML
    private void Ajouter_Projet(ActionEvent event) {
        
            try {
                FXMLLoader loader= new FXMLLoader(getClass().getResource("AjouterP.fxml"));
                Parent view_2=loader.load();
                
                Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                Scene scene = new Scene(view_2);
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ListePController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }

    @FXML
    private void Modifier_Projet(ActionEvent event) {
        
            try {
                Projet selectedProjet=Afficher.getSelectionModel().getSelectedItem();
                
                
                FXMLLoader loader= new FXMLLoader(getClass().getResource("ModifierP.fxml"));
                Parent view_2=loader.load();
                ModifierPController ModifierPController=loader.getController();
                ModifierPController.getProjet(selectedProjet);
                ModifierPController.p=selectedProjet;
                Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                Scene scene = new Scene(view_2);
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ListePController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void Supprimer_Projet(ActionEvent event) {
        
        int selectedId= Afficher.getSelectionModel().getSelectedItem().getId_Projet();
        ServiceProjet.supprimer(selectedId);
        Afficher_Projet(event);
    }

    @FXML
    private void Afficher_Projet(ActionEvent event) {
        
        ObservableList<Projet> Projets =FXCollections.observableArrayList(ServiceProjet.afficher());
       Afficher.setItems(Projets);
        
        
    }
    Stage stage;

    @FXML
    private void Quitter_Projet(ActionEvent event) {
        
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Quitter");
        alert.setHeaderText("Vous êtes sur de quitter!");
        
        
        if(alert.showAndWait().get()== ButtonType.OK){
        stage = (Stage) scenePane.getScene().getWindow();
        System.out.println("Quitter avec succès");
        stage.close();
        }
    }

    @FXML
    private void Rechercher_Projet(ActionEvent event) {
        
        String Nom_Projet = (Idrechercher.getText());
        
        Projet Projetrecherche = (Projet) ServiceProjet.readByName(Nom_Projet);
        
        if(Projetrecherche != null) {
            
            ObservableList<Projet> Projets = FXCollections.observableArrayList(Projetrecherche);
        Afficher.setItems(Projets);
            
        }else {
            System.out.println("projet non trouvé");
        }
    }

    @FXML
    private void Voir_listeEquipe(ActionEvent event) {
        
            try {
                FXMLLoader loader= new FXMLLoader(getClass().getResource("ListeEquipe.fxml"));
                Parent view_2=loader.load();
                
                Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                Scene scene = new Scene(view_2);
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ListePController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
    }
    
   
 
         
    
    



    
    
}
