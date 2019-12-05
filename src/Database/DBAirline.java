package Database;

//IMPORTS
import Logic.Airline;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

//METHODES
//Tabellen zijn al aangemaakt in MySQL

public class DBAirline {
    
    public static Airline getAirline(String compName) throws DBException {
    Connection con = null;
    try {
      con = DBConnector.getConnection();
      Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
      
      String sql = "SELECT companyname, airlinecode "
	+ "FROM airline "
	+ "WHERE companyname = " + compName;

      ResultSet srs = stmt.executeQuery(sql);
      String companyname, airlinecode;

      
      if (srs.next()) {
	companyname = srs.getString("companyname");
	airlinecode = srs.getString("airlinecode");
      } 
      
      else {// we verwachten slechts 1 rij...
	DBConnector.closeConnection(con);
	return null;
      }
      
      Airline airline = new Airline(companyname, airlinecode);
      DBConnector.closeConnection(con);
      return airline;
    } 
    
    catch (Exception ex) {
      ex.printStackTrace();
      DBConnector.closeConnection(con);
      throw new DBException(ex);
    }
    }
  
    //METHODE MET 2 DELEN: update een traveller en maak een nieuwe traveller aan
    public static void save(Airline a) throws DBException {
    Connection con = null;
    try {
      con = DBConnector.getConnection();
      Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
      
      String sql = "SELECT companyname "
              + "FROM airline "
              + "WHERE number = " + a.getCompanyName();
      ResultSet srs = stmt.executeQuery(sql);
      
      // UPDATE
      if (srs.next()) {
        //Getters moeten worden aangemaakt bij logic?
	sql = "UPDATE airline "
                + "SET airlinecode = '" + a.getAirlinecode() + "'"
                + "WHERE number = " + a.getCompanyName();
        stmt.executeUpdate(sql);
      } 
      
      // INSERT
      else {
	sql = "INSERT into airline "
                + "(companyname, airlinecode) "
		+ "VALUES (" + a.getCompanyName()
		+ ", '" + a.getAirlinecode() + "')";
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
  
    //RETOURNEERT EEN ARRAY LIST VAN AIRLINES
    public static ArrayList<Airline> getAirline() throws DBException {
    Connection con = null;
    try {
      con = DBConnector.getConnection();
      Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
      
      String sql = "SELECT companyname "
              + "FROM airline";
      
      ResultSet srs = stmt.executeQuery(sql);
      
      ArrayList<Airline> airlines = new ArrayList<Airline>();
      
      while (srs.next())
        airlines.add(getAirline(srs.getString("companyname")));
      
      DBConnector.closeConnection(con);
      
      return airlines;
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