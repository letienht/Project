package Controller.admin;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Transactions;
import service.TransactionService;
import service.impl.TransactionServicesImpl;

@WebServlet("/Updateorder")
public class OrderEditController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	TransactionService transactionService = new TransactionServicesImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");
		Transactions transaction = transactionService.get(Integer.parseInt(id));
		req.setAttribute("order", transaction);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/View/Admin/editorder.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8");
		Transactions transactions = new Transactions();
		transactions.setId(Integer.parseInt(req.getParameter("order-id")));
		transactions.setUser_name(req.getParameter("order-name"));
		transactions.setUser_mail(req.getParameter("order-mail"));
		transactions.setUser_phone(req.getParameter("order-phone"));
		transactions.setAddress(req.getParameter("order-address"));
		transactions.setMessage(req.getParameter("order-mess"));
		transactions.setAmount(req.getParameter("order-amount"));
		transactions.setPayment(req.getParameter("order-payment"));
		transactions.setStatus(req.getParameter("order-status"));
		transactionService.edit(transactions);
		resp.sendRedirect("Listorder");

	}
}
