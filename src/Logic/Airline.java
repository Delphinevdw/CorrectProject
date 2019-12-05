package Logic;

import java.util.ArrayList;

public class Airline {
  
//INSTANTIEVARIABELEN
  private String companyname;
  private String airlinecode;

//CONSTRUCTOR
    public Airline(String companyname, String airlinecode) {
        this.companyname = companyname;
        this.airlinecode = airlinecode;
  }

//GETTERS EN SETTERS
  public String getAirlinecode() {
    return airlinecode;
  }
                  
  public String getCompanyName() {
    return companyname;
  }
  
  public void setAirlinecode(String airlinecode) {
    this.airlinecode = airlinecode;
  }
    
}