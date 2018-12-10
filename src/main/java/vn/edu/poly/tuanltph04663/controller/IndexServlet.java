package vn.edu.poly.tuanltph04663.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.edu.poly.tuanltph04663.dao.CategoryDAO;
import vn.edu.poly.tuanltph04663.dao.ProductsDAO;
import vn.edu.poly.tuanltph04663.model.Category;
import vn.edu.poly.tuanltph04663.model.Products;

@WebServlet(urlPatterns = { "/index" })
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductsDAO productsDAO;
	private CategoryDAO categoryDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndexServlet() {
		super();
		this.productsDAO = new ProductsDAO();
		this.categoryDAO = new CategoryDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String categoryIdParam = request.getParameter("categoryId");
		int categoryId = 0;
		List<Products> products = new ArrayList<>();
		if (null != categoryIdParam) {
			categoryId = Integer.parseInt(categoryIdParam);
			products = productsDAO.getAllByCategory(categoryId);
		} else {
			products = productsDAO.getAll();
		}

		List<Category> categories = categoryDAO.getAll();
		request.setAttribute("products", products);
		request.setAttribute("categories", categories);
		request.getRequestDispatcher("/Views/home.jsp").forward(request, response);
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
