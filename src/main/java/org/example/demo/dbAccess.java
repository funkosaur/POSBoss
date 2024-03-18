package org.example.demo;


public class dbAccess
{
  public void loadDriver() throws Exception
  {
    System.out.println("loading linux access driver");
    try {
      // Class.forName("com.mysql.cj.jdbc.Driver");
      Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
      // Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Driver loaded successfully");
    } catch (Exception e) {
      System.out.println("Failed to load driver");
      System.out.println("Failed to load driver: " + e.getMessage());
      throw e;
    }
  }

  public String urlOfDatabase()
  {
    System.out.println("loading linux access database url");
    // String url = "jdbc:mysql://165.227.235.122:3306/mb1868_POS";
    String url = "jdbc:derby:catshop.db";
    System.out.println("Database URL: " + url);
    return url;
  }

  public String username()
  {
    String username = "mb1868_POS";
    System.out.println("Username: " + username);
    return username;
  }

  public String password()
  {
    // String password = "PosBOSS420";
    String password = "posboss4201";
    System.out.println("Password: " + password);
    return password;
  }
}
