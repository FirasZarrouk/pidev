/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionListener;
import org.controlsfx.control.Notifications;

import javafx.application.Platform;


/**
 *
 * @author afifa
 */
public class FXMain extends Application {
    
   @Override
    public void start(Stage primaryStage) {
       Parent root ;
       try {
       root = FXMLLoader.load(getClass().getResource("../gui/notif.fxml"));
       
       Scene scene = new Scene (root) ;
       primaryStage.setTitle("Gestion_reunion");
       primaryStage.setScene(scene);
       primaryStage.show();
     Notifications notif = Notifications.create();
       }catch (IOException ex){
       Logger.getLogger(FXMain.class.getName()).log(Level.SEVERE , null , ex);
       }
    }

    /**
     * @param args the command line arguments
     */
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
