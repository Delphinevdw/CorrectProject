/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.gui;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import Logic.Booking;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
/**
 * FXML Controller class
 *
 * @author delph
 */
public class PassengerInfoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField txtFirstName; 
    @FXML
    private TextField txtLastName; 
    @FXML
    private TextField txtDateOfBirth; 
    @FXML
    private CheckBox CBMale; 
    @FXML
    private CheckBox CBFemale; 
    @FXML
    private CheckBox CBX; 
    @FXML
    private TextField txtPassportNumber; 
    @FXML
    private TextField txtNationality; 
    @FXML
    private Button Submitbtn; 
    @FXML
    private CheckBox CBMainbooker;
            
    @FXML
    private AnchorPane dataPane;
      
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    }    
    
    @FXML
    public void addPassenger(ActionEvent event)
    {
        String firstName = txtFirstName.getText();
        String lastName = txtLastName.getText();
        String dateOfBirth = txtDateOfBirth.getText();
        boolean male = CBMale.isSelected();
        boolean female = CBFemale.isSelected();
        boolean x = CBX.isSelected();
        String passportNumber = txtPassportNumber.getText();
        String nationality = txtNationality.getText();
        boolean mainbooker = CBMainbooker.isSelected();              
    }
    
    @FXML
    private void loadMainbookerpane(ActionEvent event) 
    {
      try 
      {          
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("/project/gui/Mainbooker.fxml"));
        dataPane.getChildren().setAll(pane);           
      } 
      catch (IOException ex) 
      {
        Logger.getLogger(BookingController.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
}
