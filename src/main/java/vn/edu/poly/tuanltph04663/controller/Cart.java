package vn.edu.poly.tuanltph04663.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.edu.poly.tuanltph04663.dao.ProductsDAO;
import vn.edu.poly.tuanltph04663.model.Order;
import vn.edu.poly.tuanltph04663.model.OrderItem;
import vn.edu.poly.tuanltph04663.model.Products;

@WebServlet(urlPatterns = { "/cart", "/addtocart", "/removefromcart" })
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String ADD_TO_CART = "/addtocart";
	private static final String REMOVE_FROM_CART = "/removefromcart";
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
		// get product id
		String productIdParam = request.getParameter("productId");
		int productId = null == productIdParam ? 0 : Integer.parseInt(productIdParam);

		if (request.getServletPath().startsWith(ADD_TO_CART)) {

			// get product from db
			Products product = productsDAO.getById(productId);

			// create order item
			OrderItem orderItem = new OrderItem();
			orderItem.setOrderId(productId);
			orderItem.setProduct(product);

			// check session
			Order order = new Order();
			if (request.getSession().getAttribute("order") != null) {
				order = (Order) request.getSession().getAttribute("order");
			}
			order.addToCart(orderItem);

			// add product to session
			request.getSession().setAttribute("order", order);
		}

		if (request.getServletPath().startsWith(REMOVE_FROM_CART)) {
			if (request.getSession().getAttribute("order") == null) {
				return;
			}

			Order order = (Order) request.getSession().getAttribute("order");
			order.removeFromCart(productId);
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
