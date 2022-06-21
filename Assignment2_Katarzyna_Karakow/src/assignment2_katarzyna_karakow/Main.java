package assignment2_katarzyna_karakow;

import content.DisplayStage;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import content.Record;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Main extends Application {

    //ID lebel & text field
    private Label lblID = new Label("ID: ");
    private TextField txtID = new TextField();
    
    //Name lebel & text field
    private Label lblName = new Label("Name: ");
    private TextField txtName = new TextField();
    
    //Address lebel & text field
    private Label lblAddress = new Label("Address: ");
    private TextField txtAddress = new TextField();
    
    //City lebel & text field
    private Label lblCity = new Label("City: ");
    private TextField txtCity = new TextField();
    
    //Add and Display Buttons
    private Button btnAdd = new Button("Add");
    private Button btnDisplay = new Button("Display");

    private Circle circ1 = new Circle(20);
    private ArrayList<Record> recordsList = new ArrayList<>();
    
    
    
    

    @Override
    public void start(Stage stage){
        btnAdd.setOnAction(new AddRecord());
        btnDisplay.setOnAction(new DisplayRecords());

        Scene scene = new Scene(getGrid(), 500, 300);    
        stage.setScene(scene);
        stage.show();    
    }
    
    public class AddRecord implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent t) {
            
            setCircle();
            clearInput(); 
      
                String ID = txtID.getText();
                String name = txtName.getText();
                String address = txtAddress.getText();
                String city = txtCity.getText();
                
                Record one = new Record();
                one.setID(ID);
                one.setName(name);
                one.setAddress(address);
                one.setCity(city);
                
                recordsList.add(one);
                

        }
        
    }
    
    
    public class DisplayRecords implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent t) {
           
           DisplayStage recordsStage = new DisplayStage(recordsList);
           recordsStage.show();
        }
        
    }
    
    private void clearInput(){
        txtID.clear();
        txtName.clear();
        txtAddress.clear();
        txtCity.clear();
        txtID.requestFocus();
    }

    private void setCircle(){
        circ1.setFill(Color.RED);
    }

    private GridPane getGrid(){
    GridPane pane = new GridPane(); 
        
        pane.setHgap(30);
        pane.setVgap(15); 
        pane.add(lblID, 0, 0);
        pane.add(txtID, 1, 0);        
        pane.add(lblName, 0, 1);
        pane.add(txtName, 1, 1);        
        pane.add(lblAddress, 0, 2);
        pane.add(txtAddress, 1, 2);
        pane.add(lblCity, 0, 3);
        pane.add(txtCity, 1, 3);
        pane.add(btnAdd, 0, 4);
        pane.add(btnDisplay, 1, 4);
      
        return pane;
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}
