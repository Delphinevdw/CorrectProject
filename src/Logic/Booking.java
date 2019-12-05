package Logic;

import java.util.ArrayList;

public class Booking {
  
//INSTANTIEVARIABELEN
  private String bookingreference;
  private String origin;
  private String destination;
  private int numberofflights;
  private double price;

//CONSTRUCTOR
    public Booking(String bookingreference, String origin, String destination, int numberofflights, double price) {
        this.bookingreference = bookingreference;
        this.origin = origin;
        this.destination = destination;
        this.numberofflights = numberofflights;
        this.price = price;
  }

//GETTERS EN SETTERS
   
  public String getOrigin() {
    return origin;
  }
                  
  public String getDestination() {
    return destination;
  }
                    
  public int getNumberOfFlights() {
    return numberofflights;
  }
        
  public double getPrice() {
    return price;
  }
  
  public String getBookingreference() {
    return bookingreference;
  }
      
}