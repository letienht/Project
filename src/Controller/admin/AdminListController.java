package Controller.admin; 
 
import java.io.IOException; 
 
import javax.servlet.RequestDispatcher; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
 
import java.util.List; 
import Model.Admin; 
 
import service.AdminService; 
import service.impl.AdminServicesImpl; 
 
@WebServlet("/List")

public class AdminListController extends HttpServlet { 
	/** 
	 *  
	 */ 
	private static final long serialVersionUID = 1L; 
	AdminService adminService = new AdminServicesImpl(); 
 
	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
		List<Admin> adminList = adminService.getAll(); 
		req.setAttribute("adminlist", adminList); 
		RequestDispatcher dispatcher = req.getRequestDispatcher("/View/Admin/admin.jsp"); 
		dispatcher.forward(req, resp); 
	} 
}