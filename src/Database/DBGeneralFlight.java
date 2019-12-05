// NOG DOEN

package Database;

//IMPORTS
import Logic.GeneralFlight;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBGeneralFlight {

//METHODES
//Tabellen zijn al aangemaakt in MySQL

public class DBGeneralFlight {

    public static GeneralFlight getGeneralFlight(String Flightnumber) throws DBException {
    Connection con = null;
    try {
      con = DBConnector.getConnection();
      Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
      
      String sql = "SELECT flightnr, duration, co2, arrivalairport, destinationairport "
	+ "FROM generalflight "
	+ "WHERE flightnr = " + Flightnumber;

      ResultSet srs = stmt.executeQuery(sql);
      String flightnr, arrivalairport, destinationairport; 
      int duration, co2;

      
      if (srs.next()) {
	flightnr = srs.getString("flightnr");
	duration = srs.getInt("duration");
	co2 = srs.getInt("co2");
	arrivalairport = srs.getString("arrivalairport");
	destinationairport = srs.getString("destinationairport");
      } 
      
      else {// we verwachten slechts 1 rij...
	DBConnector.closeConnection(con);
	return null;
      }
      
      GeneralFlight generalflight = new GeneralFlight(flightnr, duration, co2, arrivalairport, destinationairport);
      DBConnector.closeConnection(con);
      return generalflight;
    } 
    
    catch (Exception ex) {
      ex.printStackTrace();
      DBConnector.closeConnection(con);
      throw new DBException(ex);
    }
    }

    public static void save(GeneralFlight g) throws DBException {
    Connection con = null;
    try {
      con = DBConnector.getConnection();
      Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
      
      String sql = "SELECT flightnr "
              + "FROM generalflight "
              + "WHERE number = " + g.getGeneralFlight();
      ResultSet srs = stmt.executeQuery(sql);
      if (srs.next()) {
        // UPDATE
	sql = "UPDATE generalflight "
                + "SET duration = '" + g.getDuration() + "'"
		+ ", co2 = " + g.getCo2()
		+ ", arrivalairport = " + g.getArrivalAirport()
		+ ", destinationairport = '" + g.getDestinatinoAirport() + "'"
                + "WHERE number = " + g.getGeneralFlight();
        stmt.executeUpdate(sql);
      } else {
	// INSERT
	sql = "INSERT into generalflight "
                + "(flightnr, duration, co2, arrivalairport, destinationairport) "
		+ "VALUES (" + g.getGeneralFlight()
		+ ", '" + g.getDuration() + "'"
		+ ", " + g.getCo2()
                + ", " + g.getArrivalAirport()
		+ ", '" + g.getDestinatinoAirport() 
        stmt.executeUpdate(sql);
      }
      DBConnector.closeConnection(con);
    } catch (Exception ex) {
      ex.printStackTrace();
      DBConnector.closeConnection(con);
      throw new DBException(ex);
    }
  }
  
  public static ArrayList<GeneralFlight> getGeneralFlight() throws DBException {
    Connection con = null;
    try {
      con = DBConnector.getConnection();
      Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
      
      String sql = "SELECT flightnr "
              + "FROM generalflight";
      ResultSet srs = stmt.executeQuery(sql);
      ArrayList<GeneralFlight> generalflights = new ArrayList<GeneralFlight>();
      while (srs.next())
        generalflights.add(getGeneralFlight(srs.getString("flightnr")));
      DBConnector.closeConnection(con);
      return generalflights;
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
  
  }
}  