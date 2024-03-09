package org.example.demo;


public class dbAccess
{
  public void loadDriver() throws Exception
  {
    System.out.println("loading linux access driver");
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
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
    String url = "jdbc:mysql://178.128.37.54:3306/as2491_POS";
    System.out.println("Database URL: " + url);
    return url;
  }

  public String username()
  {
    String username = "as2491_POS";
    System.out.println("Username: " + username);
    return username;
  }

  public String password()
  {
    String password = "PosBOSS420";
    System.out.println("Password: " + password);
    return password;
    // String password = "Deoareceichtyandro123";
  }
}
