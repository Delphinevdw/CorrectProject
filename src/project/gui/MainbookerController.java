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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
/**
 * FXML Controller class
 *
 * @author delph
 */
public class MainbookerController implements Initializable 
{

    @FXML
    private TextField txtPhoneNumber; 
    @FXML
    private TextField txtEmailAddress; 
    @FXML
    private Button submitbtn; 
    @FXML
    private AnchorPane dataPane;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    }    
    
    /*public void addMainbooker(ActionEvent event)
    {
        try
        {
            String phoneNumber = txtPhoneNumber.getText();
            String emailAddress = txtEmailAddress.getText();
        }
        
        catch()
        {
        
        }
    }*/
    
}
