package org.example.demo;

public class derbyAccess {
    private static final String URLdb =
                 "jdbc:derby:catshop.db";
  private static final String DRIVER =
                 "org.apache.derby.jdbc.EmbeddedDriver";

  /**
   * Load the Apache Derby database driver
   */
  public void loadDriver() throws Exception
  {
    System.out.println("loading derby driver");
    Class.forName(DRIVER).newInstance();
  }

  /**
   * Return the url to access the database
   * @return url to database
   */
  public String urlOfDatabase()
  {
    System.out.println("loading derby dabase url");
    return URLdb;
  }
}
