package Controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.AdminLoginDao;
import Model.Admin;


@WebServlet("/AdminLoginController")
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
           
    public AdminLoginController() {
        super();    
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/View/Admin/login.jsp");
    	dispatcher.forward(request, response);
    }
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	   response.setContentType("text/html");   
		 
		String username = request.getParameter("admin-username");
		String password = request.getParameter("admin-password");
		Admin admin = new Admin();
		admin.setName(request.getParameter("name"));
		
		if(AdminLoginDao.checkAdminLogin(username,password)) {
			HttpSession session = request.getSession();
			session.setAttribute("admin-username", username);
			session.setAttribute("admin-password", password);
			response.sendRedirect("Adminhome"); 
		}
		else {
            request.setAttribute("errorMessage", "Tài khoản hoặc mật khẩu không chính xác !!!");
            RequestDispatcher rd = request.getRequestDispatcher("Admin");
            rd.forward(request, response);     
		}
		
			}

}
