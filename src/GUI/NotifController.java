/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;





/**
 * FXML Controller class
 *
 * @author afifa
 */
public class NotifController implements Initializable {

    @FXML
    private Button btnnotif;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnnotif(ActionEvent event) {
//        Notifications notifications=Notifications.create();
//        //String imagepath= "\"C:\\Users\\afifa\\OneDrive\\Bureau\\images\\det.png\"";
//        //ImageView imageView = new ImageView(new Image("/C://Users//afifa//OneDrive//Bureau//images//det.png/"));
//        Image image = new Image("file:///C:/Users/afifa/OneDrive/Bureau/images/ontej.png");
//        notifications.graphic(new ImageView(image));
//
//        //ImageView imageView = new ImageView(image);
//
//// Créer la notification et ajouter l'image
//        notifications
//        .title("Notifcation")
//        .text("vous avez des reunion non validées")
//        
//        .showInformation();
//        notifications.hideAfter(Duration.seconds(4));
        
        Image image=new Image("file:///C:/Users/afifa/OneDrive/Bureau/images/ontej.png");

        Notifications notifications=Notifications.create();
        notifications.graphic(new ImageView(image));
        notifications.text("Hello there I'm Dilshan Rajika");
        notifications.title("Success Message");
        notifications.hideAfter(Duration.seconds(4));
        /*notifications.darkStyle();*/
     /*   notifications.position(Pos.BOTTOM_CENTER);*/
        notifications.show();
    }
    
}
