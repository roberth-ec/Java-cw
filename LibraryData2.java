/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.sql.*; // DB handling package
/**
 *
 * @author sandra.fernando
 */
public class LibraryData2 {
  private static Connection con = null;
   private static Statement stmt = null;
    
     //   private static Connection argos;
  //  private static Statement stmt;
    /**
     * @param args the command line arguments
     */
      static { 
        
         try {
            // Create a variable for the connection string.
            String connectionUrl = "jdbc:sqlserver://rhine:1433;"
                   + "databaseName=sandra.fernando;user=sandra.fernando;password=password";

         
              
// ************  For userName user your user ID  ***************
            
            // Establish the connection.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);

            System.out.println("Connected");
        } // Handle any errors that may have occurred.
        catch (SQLException sqle) {
            System.out.println("Sql Exception :" + sqle.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found Exception :" + e.getMessage());
        }
        
        // TODO code application logic here
    }
        
      public static String listAll() {
        String output = "";
        try {
            stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM Stocktbl");
            while (res.next()) { // there is a result
                // the name field is the thrid one in the ResultSet
                // Note that with  ResultSet we count the fields starting from 1
                output += res.getString(1) + " " + res.getString(2) + " - "
                        + res.getString(3) + " " + res.getString(4) + " "
                        + res.getString(5) + "\n";
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return output;
    }

    public static String getName(String key) {
        try {
      /*     NOTE: you cannot use key as a column name, it is a reserved word
             with SQL Server. Instead ID will be used
             Need single quote marks ' around the key field in SQL. 
             This is easy to get wrong! For instance if key was "04" the 
             SELECT statement would be:
             SELECT * FROM LibraryTable WHERE key = '04'      */
            stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM Stocktbl WHERE Id = '" + key + "'");
            if (res.next()) { // there is a result
                // the name field is the second one in the ResultSet
                // Note that with  ResultSet we count the fields starting from 1
                return res.getString(2);
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static String getArtist(String key) {
        // Similar to getName - use res.getString(3). If no result, return null
        return null;
    }

    public static int getRating(String key) {
        // Similar to getName - use res.getInt(4). If no result, return -1
        return -1;
    }

    public static int getPlayCount(String key) {
        // Similar to getName - use res.getInt(5). If no result, return -1
        return -1;
    }

    public static void setRating(String key, int rating) {
        /* SQL UPDATE statement required. For instance if rating is 5 and key is "04" then updateStr is
         UPDATE Libary SET rating = 5 WHERE ID = '04'*/
        String updateStr = "UPDATE Stocktbl SET rating = " + rating + " WHERE ID = '" + key + "'";
        System.out.println(updateStr);
        try {
            stmt.executeUpdate(updateStr);
        } catch (Exception e) {
            System.out.println(e);
        }
}}

//this is a comment 