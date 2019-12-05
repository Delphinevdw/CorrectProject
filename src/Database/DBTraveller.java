package Database;

//IMPORTS
import Logic.Traveller;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

//METHODES
//Tabellen zijn al aangemaakt in MySQL

public class DBTraveller {
  
    public static Traveller getTraveller(String pasNum) throws DBException {
    Connection con = null;
    try {
      con = DBConnector.getConnection();
      Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
      
      String sql = "SELECT passportnr, country, lastname, firstname, dateofbirth, gender, mainbooker "
	+ "FROM traveller "
	+ "WHERE passportnr = " + pasNum;

      ResultSet srs = stmt.executeQuery(sql);
      String passportnr, country, lastname, firstname, dateofbirth, gender; //Dateofbirth als string? want het wordt als "date" ingegeven in Mysql OF doet het er niet toe dat het type hetzelfde is in java en Mysql?
      boolean mainbooker;
      
      if (srs.next()) {
	passportnr = srs.getString("passportnr");
	country = srs.getString("country");
	lastname = srs.getString("lastname");
	firstname = srs.getString("fistname");
	dateofbirth = srs.getString("dateofbirth");
        gender = srs.getString("gender");
        mainbooker = srs.getBoolean("mainbooker");
      } 
      
      else {// we verwachten slechts 1 rij...
	DBConnector.closeConnection(con);
	return null;
      }
      
      Traveller traveller = new Traveller(passportnr, country, lastname, firstname, dateofbirth, gender, mainbooker);
      DBConnector.closeConnection(con);
      return traveller;
    } 
    
    catch (Exception ex) {
      ex.printStackTrace();
      DBConnector.closeConnection(con);
      throw new DBException(ex);
    }
    }
  
    //METHODE MET 2 DELEN: update een traveller en maak een nieuwe traveller aan
    public static void save(Traveller t) throws DBException {
    Connection con = null;
    try {
      con = DBConnector.getConnection();
      Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
      
      String sql = "SELECT passportnr "
              + "FROM traveller "
              + "WHERE number = " + t.getPassportnr();
      ResultSet srs = stmt.executeQuery(sql);
      
      // UPDATE
      if (srs.next()) {
        //Getters moeten worden aangemaakt bij logic?
	sql = "UPDATE traveller "
                + "SET country = '" + t.getCountry() + "'"
		+ ", lastname = " + t.getLastname()
		+ ", fistname = " + t.getFirstname()
                + ", gender = " + t.getGender()
		+ ", dateofbirth = " + t.getDateofbirth()
		+ ", mainbooker = '" + t.getMainbooker() + "'"
                + "WHERE number = " + t.getPassportnr();
        stmt.executeUpdate(sql);
      } 
      
      // INSERT
      else {
	sql = "INSERT into traveller "
                + "(passportnr, country, lastname, firstname, dateofbirth, gender, mainbooker) "
		+ "VALUES (" + t.getPassportnr()
		+ ", '" + t.getCountry() + "'"
		+ ", " + t.getLastname()
                + ", " + t.getFirstname()
                + ", " + t.getDateofbirth()
                + ", " + t.getGender()
		+ ", '" + t.getMainbooker() + "')";
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
  
    //RETOURNEERT EEN ARRAY LIST VAN TRAVELLERS
    public static ArrayList<Traveller> getTraveller() throws DBException {
    Connection con = null;
    try {
      con = DBConnector.getConnection();
      Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
      
      String sql = "SELECT passportnr "
              + "FROM traveller";
      
      ResultSet srs = stmt.executeQuery(sql);
      
      ArrayList<Traveller> travellers = new ArrayList<Traveller>();
      
      while (srs.next())
        travellers.add(getTraveller(srs.getString("passportnr")));
      
      DBConnector.closeConnection(con);
      
      return travellers;
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
  
    //HAALT ALLE TRAVELLERS OP WAAR Mainbooker = true       NOG DOEN!!!!
    /* public static ArrayList<Student> getGraduates() throws DBException {
    Connection con = null;
    try {
      con = DBConnector.getConnection();
      Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
      
      String sql = "SELECT number "
              + "FROM Students "
              + "WHERE graduate=" + true;
      ResultSet srs = stmt.executeQuery(sql);
      
      ArrayList<Student> studenten = new ArrayList<Student>();
      while (srs.next())
        studenten.add(getStudent(srs.getInt("number")));
      DBConnector.closeConnection(con);
      return studenten;
    } catch (DBException dbe) {
      dbe.printStackTrace();
      DBConnector.closeConnection(con);
      throw dbe;
    } catch (Exception ex) {
      ex.printStackTrace();
      DBConnector.closeConnection(con);
      throw new DBException(ex);
    } */

}