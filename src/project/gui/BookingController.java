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
import javafx.scene.layout.Pane;
import Logic.Booking;
/**
 * FXML Controller class
 *
 * @author delph
 */
public class BookingController implements Initializable {

    
  @FXML
    private Button Flight; 
  @FXML
    private Button CustomerService; 
  @FXML
    private Button Report;
  @FXML
  private AnchorPane dataPane; 
  /*@FXML
  private Button FlightRequirementsbtn;
  @FXML
  private Button OptionSingleFlightbtn;
  @FXML
  private Button OptionReturnFlightbtn;
  @FXML
  private Button SummaryFlightbtn; 
  @FXML
  private Button PassengerInfobtn; 
  @FXML
  private Button Mainbooker; 
  
  private Booking booking;
  @FXML
  private AnchorPane dataPane;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        //booking = Booking.getInstance();
    }    
    
    @FXML
    private void loadFlightRequirementspane(ActionEvent event) 
    {
      try 
      {          
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("/project/gui/FlightRequirenments.fxml"));
        dataPane.getChildren().setAll(pane);           
      } 
      catch (IOException ex) 
      {
        Logger.getLogger(BookingController.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    
    
    
    
    
    @FXML
    private void loadCustomerServicepane(ActionEvent event) 
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
    
    @FXML
    private void loadReportpane(ActionEvent event) 
    {
      try 
      {          
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("/project/gui/OptionReturnFlight.fxml"));
        dataPane.getChildren().setAll(pane);           
      } 
      catch (IOException ex) 
      {
        Logger.getLogger(BookingController.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
        
   
}
