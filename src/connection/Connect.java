package connection;
import java.sql.*;


public class Connect {
    
    public static Connection con;
    public static Statement st;
    
    public static void getConnection()
    {
             
        try
            {
            //loads JDBC driver of type 4 into memory . Driver code initialises Drive Manager with type 4 driver.  
            Class.forName("com.mysql.jdbc.Driver");
            //Driver Manager makes connection with the required database.
            con = DriverManager.getConnection("jdbc:mysql:///resume_builder","root","1234");
            //creates a memory for the satement we want to execute
            st = con.createStatement();
            
            }
        catch(ClassNotFoundException e)
            {
                //if class Driver is not found from connector .jar
                System.out.println(e);
            }
        catch(SQLException e)
            {
                //for connection cant be established.
                System.out.println(e);
            }
        
    }
    
    
}
