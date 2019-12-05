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
public class FlightRequirementsController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField txtFrom;
    @FXML
    private TextField txtTo; 
    @FXML
    private DatePicker leavingDate; 
    @FXML
    private DatePicker returnDate;
    @FXML
    private TextField txtAdults; 
    @FXML 
    private TextField txtChildren; 
    @FXML 
    private TextField txtBabies; 
    @FXML
    private Button searchBookingbtn; 
    @FXML
    private CheckBox CBDuration; 
    @FXML
    private CheckBox CBPrice; 
    @FXML
    private CheckBox CBCO2; 
    @FXML 
    private CheckBox CBTransfers; 
    
    private Booking model;
    @FXML
    private AnchorPane dataPane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        
    }    
    
    @FXML
    private void loadOptionSingleFlightpane(ActionEvent event) 
    {
      try 
      {          
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("/project/gui/OptionSingleFlight.fxml"));
        dataPane.getChildren().setAll(pane);           
      } 
      catch (IOException ex) 
      {
        Logger.getLogger(BookingController.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    
    /*@FXML
    private void SearchBooking(ActionEvent event)
    {
        try
        {
            String origin = txtFrom.getText();
            String destination = txtTo.getText();
            int numberOfAdults = Integer.parseInt(txtAdults.getText());
            int numberOfChildren = Integer.parseInt(txtChildren.getText());
            int numberOfBabies = Integer.parseInt(txtBabies.getText());
            boolean duration = CBDuration.isSelected();
            boolean price = CBPrice.isSelected();
            boolean CO2 = CBCO2.isSelected();
            boolean transfers = CBTransfers.isSelected();
            
            
            
            
        }
        catch (IOException ex) 
        {
            Logger.getLogger(FlightRequirementsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
}
