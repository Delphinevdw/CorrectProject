package Logic;

import java.util.ArrayList;
import java.util.Date;

public class Traveller {
  
//INSTANTIEVARIABELEN
  private String passportnr;
  private String country;
  private String lastname;
  private String firstname;
  private String dateofbirth;
  private String gender;
  private boolean mainbooker;


//CONSTRUCTOR
  public Traveller(String passportnr, String country, String lastname, String firstname, String dateofbirth, String gender, boolean mainbooker) {
        this.passportnr = passportnr;
        this.country = country;
        this.lastname = lastname;
        this.firstname = firstname;
        this.dateofbirth = dateofbirth;
        this.gender = gender;
        this.mainbooker = mainbooker;
  }

//GETTERS EN SETTERS
  public String getPassportnr() {
    return passportnr;
  }
                  
  public String getCountry() {
    return country;
  }
  
  public String getLastname() {
    return lastname;
  }
  
  public String getFirstname() {
    return firstname;
  }
  
  public String getGender() {
    return gender;
  }

  public String getDateofbirth() {
    return dateofbirth;
  }
  
  public boolean getMainbooker() {
    return mainbooker;
  }
    
}