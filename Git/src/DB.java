import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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
    String driverName = "org.gjt.mm.mysql.Driver";
    Class.forName(driverName);

    String serverName = "localhost";
    String mydatabase = "zmanim";
    String url = "jdbc:mysql://" + serverName + "/" + mydatabase; 

    String username = "Admin";
    String password = "sa";
    connection = DriverManager.getConnection(url, username, password);
  }
}