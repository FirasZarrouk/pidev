/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Util.MaConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class StatController implements Initializable {

    @FXML
    private AnchorPane ChartNode;
    
    /*
    @FXML
    private Button retour;
    */
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //PieChart.Data slice1 = new PieChart.Data("Slice 1", 25);
    //PieChart.Data slice2 = new PieChart.Data("Slice 2", 30);
    //PieChart.Data slice3 = new PieChart.Data("Slice 3", 45);
    //PieChart.getData().addAll(slice1, slice2, slice3);
    
    detailleBonPlan();
    }    
    
    public ObservableList buildData(){
 
        List<PieChart.Data> myList = new ArrayList<PieChart.Data>();
        ResultSet rs = null;
        PieChart.Data d;
        ObservableList observableList = null;
        try {
        String requete3="select count(projet.categorie) , projet.categorie  from projet group by categorie";
            Statement st = MaConnection.getInstance().getCnx().createStatement();
        rs = st.executeQuery(requete3);
             while (rs.next())
             {
               d = new PieChart.Data(rs.getString(2),rs.getInt(1));
             myList.add(d);
             }
             observableList = FXCollections.observableArrayList(myList);

            return observableList;
        }
        catch(Exception e) {

            System.out.println("Error on DB connection");
            System.out.println(e.getStackTrace());
            System.out.println(e.getMessage());

        }
        return observableList;
    }

     private void detailleBonPlan() {
     double total = 0;
        DecimalFormat df2 = new DecimalFormat(".##");
        Stage stage = new Stage();
        Scene scene = new Scene(new Group());
        stage.setTitle("Statistiques des projets par categories");
        stage.setWidth(600);
        stage.setHeight(600);

        final PieChart chart = new PieChart(buildData());
        final Label caption = new Label("");
        caption.setTextFill(Color.DARKORANGE);
        caption.setStyle("-fx-font: 24 arial;");

        for (final PieChart.Data data : chart.getData()) {
            total = total + data.getPieValue();
        }
        final double totalFinal = total;

        for (final PieChart.Data data : chart.getData()) {
            data.setName(((data.getName() + " " + df2.format((data.getPieValue() / totalFinal) * 100))) + "%");
          data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED,
                 new EventHandler<MouseEvent>() {
                     @Override
                     public void handle(MouseEvent e) {
                         
                         caption.setTranslateX(e.getSceneX());
                         caption.setTranslateY(e.getSceneY());
                         caption.setText(String.valueOf(df2.format((data.getPieValue() / totalFinal) * 100)) + "%");
                         if (!((Group) scene.getRoot()).getChildren().contains(caption)) {
                             ((Group) scene.getRoot()).getChildren().add(caption);
                         }
                     }
                 });
        }

        chart.setTitle("Statistiques des projets par categories");
        ((Group) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
        ChartNode.getChildren().clear();
        ChartNode.getChildren().setAll(chart);
     
     
     }
     
     
   
     /*
    
    @FXML
    private void Retour(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage) retour.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("AceuilProjet.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    } */
    
}
