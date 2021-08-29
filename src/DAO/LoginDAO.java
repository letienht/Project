package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import Model.User;

public class LoginDAO {
	public static boolean Authenticationmember(HttpServletRequest request, Connection conn, User member)
	{
		PreparedStatement ptmt = null;
		String sql = "select username,password from users";
		boolean kt=false;
		try 
		{
			ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			while (rs.next())
			{
				String membername = rs.getString("username");
				String memberpass=  rs.getString("password");
				if ((member.getUsername().equals(membername) && member.getPassword().equals(memberpass)))
					kt=true;
			}
			ptmt.close();
			rs.close();
		} 
		catch (SQLException e) 
		{
			request.setAttribute("msglogin",e.getMessage());
		}
		return kt;
	}
}
