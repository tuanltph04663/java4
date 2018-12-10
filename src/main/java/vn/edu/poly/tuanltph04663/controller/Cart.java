package vn.edu.poly.tuanltph04663.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.edu.poly.tuanltph04663.dao.ProductsDAO;
import vn.edu.poly.tuanltph04663.model.Products;

@WebServlet(urlPatterns = { "/cart", "/addtocart" })
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductsDAO productsDAO;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Cart() {
		super();
		this.productsDAO = new ProductsDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if (request.getServletPath().startsWith("/addtocart")) {
			// get product id
			String productIdParam = request.getParameter("productId");
			int productId = Integer.parseInt(productIdParam);
			
			// get product from db
			Products product = productsDAO.getById(productId);
			
			// add product to session
			request.getSession().setAttribute("cart", "some thing here");
		}
		
		request.getRequestDispatcher("/Views/cart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
