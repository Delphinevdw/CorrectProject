package Database;

//IMPORTS
import Logic.Airport;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

//METHODES
//Tabellen zijn al aangemaakt in MySQL

public class DBAirport {
    
    public static Airport getAirport(String airpCode) throws DBException {
    Connection con = null;
    try {
      con = DBConnector.getConnection();
      Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
      
      String sql = "SELECT airportcode, airportname, timezone "
	+ "FROM airport "
	+ "WHERE airportcode = " + airpCode;

      ResultSet srs = stmt.executeQuery(sql);
      String airportcode, airportname, timezone;

      
      if (srs.next()) {
	airportcode = srs.getString("airportcode");
	airportname = srs.getString("airportname");
        timezone = srs.getString("timezone");
      } 
      
      else {// we verwachten slechts 1 rij...
	DBConnector.closeConnection(con);
	return null;
      }
      
      Airport airport = new Airport(airportcode, airportname, timezone);
      DBConnector.closeConnection(con);
      return airport;
    } 
    
    catch (Exception ex) {
      ex.printStackTrace();
      DBConnector.closeConnection(con);
      throw new DBException(ex);
    }
    }
  
    //METHODE MET 2 DELEN: update een traveller en maak een nieuwe traveller aan
    public static void save(Airport a) throws DBException {
    Connection con = null;
    try {
      con = DBConnector.getConnection();
      Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
      
      String sql = "SELECT airportcode "
              + "FROM airport "
              + "WHERE number = " + a.getAirportCode();
      ResultSet srs = stmt.executeQuery(sql);
      
      // UPDATE
 
      if (srs.next()) {
        //Getters moeten worden aangemaakt bij logic?
	sql = "UPDATE airport "
                + "SET airportname = '" + a.getAirportname() + "'"
                + ", timezone = '" + a.getTimezone() + "'"
                + "WHERE number = " + a.getAirportCode();
        stmt.executeUpdate(sql);
      } 
      
      // INSERT
 
      else {
	sql = "INSERT into airport "
                + "(airportcode, airportname, timezone) "
		+ "VALUES (" + a.getAirportCode()
		+ ", '" + a.getAirportname() + "'"
		+ ", '" + a.getTimezone() + "')";
        stmt.executeUpdate(sql);
      }
      
      DBConnector.closeConnection(con);
    } 
    
    catch (Exception ex) {
      ex.printStackTrace();
      DBConnector.closeConnection(con);
      throw new DBException(ex);
    }
    }
  
    //RETOURNEERT EEN ARRAY LIST VAN AIRPORTS
    public static ArrayList<Airport> getAirport() throws DBException {
    Connection con = null;
    try {
      con = DBConnector.getConnection();
      Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
      
      String sql = "SELECT airportcode "
              + "FROM airport";
      
      ResultSet srs = stmt.executeQuery(sql);
      
      ArrayList<Airport> airports = new ArrayList<Airport>();
      
      while (srs.next())
        airports.add(getAirport(srs.getString("airportcode")));
      
      DBConnector.closeConnection(con);
      
      return airports;
    } 
    
    catch (DBException dbe) {
      dbe.printStackTrace();
      DBConnector.closeConnection(con);
      throw dbe;
    } 
    
    catch (Exception ex) {
      ex.printStackTrace();
      DBConnector.closeConnection(con);
      throw new DBException(ex);
    }
    }

}