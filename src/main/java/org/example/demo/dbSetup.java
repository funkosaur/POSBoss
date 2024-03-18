package org.example.demo;

import java.sql.*;
import java.util.ArrayList;


class dbSetup 
{
    private static String[] sqlStatements = {

        "drop table if exists productsTable",
        "create table productsTable ("+
            "name           Varchar(50), " +
            "cost           Float, " +
            "productType    Varchar(20), " +
            "description    Varchar(100))",
      
        "insert into productsTable values " +
           "('CocaCola', 4.50, 'DRINK', 'Soft non-alcoholic drink')",
        "insert into productsTable values " +
           "('Stella', 7.00, 'DRINK', 'Beer light alcoholic drink')",
        "insert into productsTable values " +
           "('Hamburger', 9.00, 'FOOD', 'Classic hamburger')",
        "insert into productsTable values " +
           "('FishNChips', 11.20, 'FOOD', 'Fried fish with chips on the side')",
        "insert into productsTable values " +
           "('WhiteWine', 5.50, 'DRINK', 'A glass of white wine')",
        "insert into productsTable values " +
           "('RedWine', 5.50, 'DRINK', 'Glass of red wine')",
        "insert into productsTable values " +
           "('Peanuts', 2.25, 'MISCELLANEOUS', 'Peanuts snack')",
        "insert into productsTable values " +
           "('Pepsi', 4.50, 'DRINK', 'Non-alcoholic soft drink')",
      
        "drop table if exists stockTable",
        "create table stockTable ("+
            "name           Varchar(50), " +
            "quantity       Integer)",
      
        "insert into stockTable values " +
           "('CocaCola', 7)",
        "insert into stockTable values " +
           "('Stella', 22)",
        "insert into stockTable values " +
           "('Hamburger', 9)",
        "insert into stockTable values " +
           "('FishNChips', 41)",
        "insert into stockTable values " +
           "('WhiteWine', 23)",
        "insert into stockTable values " +
           "('RedWine', 50)",
        "insert into stockTable values " +
           "('Peanuts', 21)",
        "insert into stockTable values " +
           "('Pepsi', 92)",
      
        "select * from stockTable, productsTable " +
                " where stockTable.name = productsTable.name"
      
       };

  public static void main(String[] args)
  {
    Connection theCon    = null;      // Connection to database
    dbAccess   acs  = new dbAccess();
    Statement theStmt = null;
    
    System.out.println("Setup Setup POSBoss database items");
    
    try {
        
        acs.loadDriver(); // Load the JDBC driver
        theCon = DriverManager.getConnection(acs.urlOfDatabase(), acs.username(), acs.password());
        theStmt = theCon.createStatement();
        theCon.setAutoCommit(true);
    }
    catch (SQLException e) {
        System.err.println("Problem with connection to " + acs.urlOfDatabase());
        e.printStackTrace();
        System.out.println("SQLException: " + e.getMessage());
        System.out.println("SQLState:     " + e.getSQLState());
        System.out.println("VendorError:  " + e.getErrorCode());
        System.exit(-1);
    }
    catch ( Exception e )
    {
        System.err.println("Can not load JDBC/ODBC driver.");
        System.exit( -1 );
    }

    Statement stmt = null;
    try {
        stmt = theCon.createStatement();
    } catch (Exception e) {
        System.err.println("problems creating statement object" );
    }

    // execute SQL commands to create table, insert data
    for ( String sqlStatement : sqlStatements )
    {
      try
      {
        System.out.println( sqlStatement );
        switch ( sqlStatement.charAt(0) )
        {
           case '/' :
             System.out.println("------------------------------");
             break;
           case 's' :
           case 'f' :
             query( stmt, acs.urlOfDatabase(), sqlStatement );
             break;
           case '*' :
             if ( sqlStatement.length() >= 2 )
               switch( sqlStatement.charAt(1)  )
               {
                 case 'c' :
                   theCon.commit();
                   break;
                 case 'r' :
                   theCon.rollback();
                   break;
                 case '+' :
                   theCon.setAutoCommit( true );
                   break;
                 case '-' :
                   theCon.setAutoCommit( false );
                   break;
                }
              break;
           default :
            stmt.execute(sqlStatement);
        }
        //System.out.println();
      } catch (Exception e)
      {
        System.out.println("problems with SQL sent to " +
                           acs.urlOfDatabase() +
                           "\n" + sqlStatement + "\n" + e.getMessage());
      }
    }

    try {
      theCon.close();
    } catch (Exception e)
    {
      System.err.println("problems with close " +
                         ": "+e.getMessage());
    }

  }


  private static void query( Statement stmt, String url, String stm )
  {
    try
    {
      ResultSet res = stmt.executeQuery( stm );
      
      ArrayList<String> names = new ArrayList<>(10);

      ResultSetMetaData md = res.getMetaData();
      int cols = md.getColumnCount();

      for ( int j=1; j<=cols; j++ )
      {
        String name = md.getColumnName(j);
        System.out.printf( "%-14.14s ", name );
        names.add( name );
      }
      System.out.println();

      for ( int j=1; j<=cols; j++ )
      {
        System.out.printf( "%-14.14s ",  md.getColumnTypeName(j)  );
      }
      System.out.println();

      while ( res.next() )
      {
        for ( int j=0; j<cols; j++ )
        {
          String name = names.get(j);
          System.out.printf( "%-14.14s ", res.getString( name )  );
        }
        System.out.println();
      }


    } catch (Exception e)
    {
      System.err.println("problems with SQL sent to "+url+
                         "\n" + e.getMessage());
    }
  }
  
  private static String m( int len, String s )
  {
    if ( s.length() >= len )
    {
      return s.substring( 0, len-1 ) + " ";
    }
    else
    {
      StringBuilder res = new StringBuilder( len );
      res.append( s );
      for ( int i = s.length(); i<len; i++ )
        res.append( ' ' );
      return res.toString();
    }
  }

}
