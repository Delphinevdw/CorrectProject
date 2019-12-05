package Logic;

import java.util.ArrayList;

public class Airport {
  
//INSTANTIEVARIABELEN
  private String airportcode;
  private String airportname;
  private String timezone;

//CONSTRUCTOR
    public Airport(String airportcode, String airportname, String timezone) {
        this.airportcode = airportcode;
        this.airportname = airportname;
        this.timezone = timezone;
    }

//GETTERS EN SETTERS
  public String getAirportCode() {
    return airportcode;
  }
                  
  public String getAirportname() {
    return airportname;
  }
    
    public String getTimezone() {
    return timezone;
  }   
   
}