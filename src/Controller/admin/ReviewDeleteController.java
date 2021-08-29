package Controller.admin;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ReviewService;
import service.impl.ReviewServicesImpl;
@WebServlet("/Deletereview")

public class ReviewDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ReviewService reviewService =  new ReviewServicesImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		reviewService.delete(Integer.parseInt(id));
		resp.sendRedirect("Listreview");
	}

}
