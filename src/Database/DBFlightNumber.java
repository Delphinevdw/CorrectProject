//NOG DOEN

package Database;

//IMPORTS
import Logic.FlightNumber;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

//METHODES
//Tabellen zijn al aangemaakt in MySQL

public class DBFlightNumber {

    public static Flightnumber getFlightnumber(String reference) throws DBException {
    Connection con = null;
    try {
      con = DBConnector.getConnection();
      Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
      
      String sql = "SELECT bookingreference, origin, destination, numberofflights, price "
	+ "FROM booking "
	+ "WHERE bookingreference = " + reference;

      ResultSet srs = stmt.executeQuery(sql);
      String bookingreference, origin, destination; 
      int numberofflights;
      double price;

      
      if (srs.next()) {
	bookingreference = srs.getString("bookingreference");
	origin = srs.getString("origin");
	destination = srs.getString("destination");
	numberofflights = srs.getInt("numberofflights");
	price = srs.getDouble("price");
      } 
      
      else {// we verwachten slechts 1 rij...
	DBConnector.closeConnection(con);
	return null;
      }
      
      Booking booking = new Booking(bookingreference, origin, destination, numberofflights, price);
      DBConnector.closeConnection(con);
      return booking;
    } 
    
    catch (Exception ex) {
      ex.printStackTrace();
      DBConnector.closeConnection(con);
      throw new DBException(ex);
    }
    }

    public static void save(Booking b) throws DBException {
    Connection con = null;
    try {
      con = DBConnector.getConnection();
      Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
      
      String sql = "SELECT bookingrefernce "
              + "FROM booking "
              + "WHERE number = " + b.getBooking();
      ResultSet srs = stmt.executeQuery(sql);
      if (srs.next()) {
        // UPDATE
	sql = "UPDATE booking "
                + "SET origin = '" + b.getOrigin() + "'"
		+ ", destination = " + b.getDestination()
		+ ", numberofflights = " + b.getNumberOfFlights()
		+ ", price = '" + b.getPrice() + "'"
                + "WHERE number = " + b.getBooking();
        stmt.executeUpdate(sql);
      } else {
	// INSERT
	sql = "INSERT into Booking "
                + "(bookingreference, origin, destination, numberofflights, price) "
		+ "VALUES (" + b.getBooking()
		+ ", '" + b.getbookingreference() + "'"
		+ ", " + b.getOrigin()
                + ", " + b.getDestination()
		+ ", '" + b.getNumberOfFlights() 
                + "' ')" + b.getPrice();
        stmt.executeUpdate(sql);
      }
      DBConnector.closeConnection(con);
    } catch (Exception ex) {
      ex.printStackTrace();
      DBConnector.closeConnection(con);
      throw new DBException(ex);
    }
  }
  
  public static ArrayList<Booking> getBooking() throws DBException {
    Connection con = null;
    try {
      con = DBConnector.getConnection();
      Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
      
      String sql = "SELECT bookingreference "
              + "FROM booking";
      ResultSet srs = stmt.executeQuery(sql);
      ArrayList<Booking> bookings = new ArrayList<Student>();
      while (srs.next())
        bookings.add(getBooking(srs.getString("bookingreference")));
      DBConnector.closeConnection(con);
      return bookings;
    } catch (DBException dbe) {
      dbe.printStackTrace();
      DBConnector.closeConnection(con);
      throw dbe;
    } catch (Exception ex) {
      ex.printStackTrace();
      DBConnector.closeConnection(con);
      throw new DBException(ex);
    }
  }
  
  public static void main(String[] args){
    try {
      DBTraveller.save(new Booking("StudentA", 1, true, true, "Test1"));
    } catch (DBException ex) {
      Logger.getLogger(DBBooking.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}    
    

}