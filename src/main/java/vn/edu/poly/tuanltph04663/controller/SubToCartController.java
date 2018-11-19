package vn.edu.poly.tuanltph04663.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.edu.poly.tuanltph04663.dao.CartDAO;


/**
 * Servlet implementation class SubToCartController
 */
public class SubToCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubToCartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			PrintWriter out=response.getWriter();
			HttpSession session = request.getSession();
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String action = request.getParameter("add");
			int idProducts = Integer.parseInt(request.getParameter("idProducts"));
			
			if (session.getAttribute("Account") == null) {
				response.sendRedirect("/Assignment/Views/Login.jsp");

			} else {
				if (action.equalsIgnoreCase("sub")) {
					int idsp = Integer.parseInt(request.getParameter("idProducts"));
					int idctgh = Integer.parseInt(request.getParameter("idDetail"));
					CartDAO.SubToCart(idctgh, idsp);
					response.sendRedirect("/Assignment/Views/Cart.jsp");
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
