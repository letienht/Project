package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.impl.RegisterDao;
import DBConnection.ConnectionDB;
import Model.User;

/**
 * Servlet implementation class RegistrationController
 */
@WebServlet("/Register")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegistrationController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/View/Client/register.jsp");
    	dispatcher.forward(request, response);
    }
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String name = request.getParameter("name");
		String created = request.getParameter("created");

		User user = new User(username, password, email, phone, name, created);

		RegisterDao register = new RegisterDao(ConnectionDB.getConnection());
		if (register.RegisterUser(user)) // On success, you can display a message to user on Home page
		{
			request.setAttribute("Message", "Bạn đăng kí thành công . Mời bạn đăng nhập <a href='LoginForWard");
			RequestDispatcher rd = request.getRequestDispatcher("/View/Client/register.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("errMessage", "Tạo tài khoản thất bại. Hãy Thử Lại !!!");
			RequestDispatcher rd = request.getRequestDispatcher("/View/Client/register.jsp");
			rd.forward(request, response);
		}
	}
}
