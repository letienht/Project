package Controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import DAO.LoginDAO;
import DBConnection.ConnectionDB;
import Model.User;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginController() {
        super();    
    }
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Connection conn = ConnectionDB.getConnection();
			response.setContentType("text/html");
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=UTF-8");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			User users =new User();
		    users.setUsername(username);
			users.setPassword(password);
			boolean kt1=LoginDAO.Authenticationmember(request, conn, users);
			if(kt1) {
				
				HttpSession session = request.getSession();
                session.setAttribute("username", username);
                RequestDispatcher rd = request.getRequestDispatcher("HomeForWard");
		        rd.forward(request, response);
			}
			else {
				 request.setAttribute("errorMsg", "Tài khoản đăng nhập hoặc mật khẩu sai !!!");
				 RequestDispatcher rd = request.getRequestDispatcher("LoginForWard");
		         rd.forward(request, response);
			}
		}
}

