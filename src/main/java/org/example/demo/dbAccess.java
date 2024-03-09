package org.example.demo;


public class dbAccess
{
  public void loadDriver() throws Exception
  {
    // Load MySQL JDBC driver
    Class.forName("com.mysql.cj.jdbc.Driver");
    
  }

  public String urlOfDatabase()
  {

    return "jdbc:mysql://178.128.37.54:3306/as2491_POS";
  }

  public String username()
  {
    return "as2491_POS";
  }

  public String password()
  {
    return "PosBOSS420";
  }
}
