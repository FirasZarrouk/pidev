/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import GUI.ItemADMINController;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import Model.Formation;
import Model.Participation;
import services.FormationServices;
import services.ParticipationServices;
import Util.MaConnection;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ItemPARController implements Initializable {

    @FXML
    private Label datePar;
    @FXML
    private Label titrePar;
    @FXML
    private Label idPar;
    @FXML
    private Label catPar;
    @FXML
    private Button annuler;
    
    private Participation par;
    private Calendar calendar = Calendar.getInstance(); 
 
    /**
     * Initializes the controller class.
     */
    
    ParticipationServices ps = new ParticipationServices();
    @FXML
    private Label idFor;
    @FXML
    private TextField nb_like_dislike;
    @FXML
    private Button btn_like;
    @FXML
    private Button btn_dislike;
    
   public void setData(Participation par) throws SQLException {
    this.par = par;
    idPar.setText(String.valueOf(par.getId_participation()));
    idFor.setText(String.valueOf(par.getForm().getId_formation()));
    titrePar.setText(par.getForm().getTitre());
    catPar.setText(par.getForm().getCategorie());
    /*SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    String dateString = formatter.format(par.getDate());
    datePar.setText(dateString);*/
  /* java.util.Date date = (java.util.Date) par.getDate();
   SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
   String formattedDate = dateFormatter.format(date);
   datePar.setText(formattedDate);*/      
 // Define the SQL query to select the date from the participation table
 Connection cnx = MaConnection.getInstance().getCnx();
String query = "SELECT date FROM participation WHERE id_participation = " + par.getId_participation();

// Create a Statement object with the query
Statement statement = cnx.createStatement();

// Execute the query and get the result set
ResultSet resultSet = statement.executeQuery(query);

// Check if the result set has a row
if (resultSet.next()) {
    // Get the date value as a java.sql.Date object
    java.sql.Date dateValue = resultSet.getDate("date");

    // Convert the java.sql.Date to a LocalDate object
    LocalDate localDate = dateValue.toLocalDate();

    // Format the LocalDate as a string using a DateTimeFormatter
    String dateString = localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

    // Set the string value as the text of the Label
    datePar.setText(dateString);
}

// Close the Statement object and release resources
statement.close();

}

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void annuler(ActionEvent event) {
         try {
        ps.supprimer(Integer.valueOf(idPar.getText()));
        FXMLLoader loader= new FXMLLoader(getClass().getResource("Participation_accueil2.fxml"));
        Parent view_2=loader.load();
        
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(view_2);
        stage.setScene(scene);
        stage.show();
        // afficher_garage(event);
    } catch (IOException ex) {
        Logger.getLogger(ItemPARController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @FXML
    private void LikeE(ActionEvent event) {
        
        ParticipationServices ps = new ParticipationServices();
        int currentVote=par.getVote();
        nb_like_dislike.setText(String.valueOf(currentVote+1));
        par.setVote(currentVote+1);
        ps.likeEvent(par);
    }

    @FXML
    private void DislikeE(ActionEvent event) {
         ParticipationServices ps = new ParticipationServices();
        int currentVote=par.getVote();
        nb_like_dislike.setText(String.valueOf(currentVote-1));
        par.setVote(currentVote-1);
        ps.DislikeEvent(par);
    }

    
}
