import java.sql.*;


public class DB {
	
  public static Connection connection;
  private String sql = "select * from reminders";
  ResultSet rs;
  Statement statement;
	
  public DB() throws Exception{
	  db();
	  statement = connection.createStatement();
	  rs = statement.executeQuery(sql);
  }
  
  public static void db() throws Exception {
    String driverName = "com.mysql.jdbc.Driver";
    Class.forName(driverName);

    String serverName = "localhost";
    String mydatabase = "zmanim";
    String url = "jdbc:mysql://" + serverName + "/" + mydatabase; 

    String username = "root";
    String password = "";
    connection = DriverManager.getConnection(url, username, password);
  }
  
}