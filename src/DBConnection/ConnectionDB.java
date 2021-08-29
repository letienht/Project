package DBConnection;
import java.sql.*;

public class ConnectionDB 
{
	public static Connection getConnection()
	{
		Connection conn = null;;
		
		
		String url = "jdbc:mysql://localhost:3306/qlns?useUnicode=true&characterEncoding=UTF-8";
		String username = "root";
		String password = "";
		
		try 
		{
			//load driver
			Class.forName("com.mysql.jdbc.Driver");
			//create connection
			conn = DriverManager.getConnection(url,username,password);
				
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}	
		return conn;
	}
}
