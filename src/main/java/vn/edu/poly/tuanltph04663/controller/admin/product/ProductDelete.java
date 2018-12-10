package vn.edu.poly.tuanltph04663.controller.admin.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.edu.poly.tuanltph04663.dao.ProductsDAO;
import vn.edu.poly.tuanltph04663.model.Products;

@WebServlet(urlPatterns = { "/productDelete" })
public class ProductDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductsDAO productsDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductDelete() {
		super();
		this.productsDAO = new ProductsDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Products> products = productsDAO.getAll();
		request.setAttribute("products", products);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("Views-QLWebsite/product.jsp");
		requestDispatcher.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Products product = productsDAO.getById(id);
		if (product != null) {
			productsDAO.delete(product);
		}
		doGet(request, response);
	}

}
