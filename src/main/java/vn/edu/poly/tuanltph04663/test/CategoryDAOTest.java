package vn.edu.poly.tuanltph04663.test;

import java.util.Map;

import vn.edu.poly.tuanltph04663.dao.CategoryDAO;
import vn.edu.poly.tuanltph04663.model.Category;

public class CategoryDAOTest {

	private static CategoryDAO categoryDao = new CategoryDAO();

	private static void getAllCategoryTest() {
		Map<Integer, Category> result = categoryDao.getAll();
		result.entrySet().stream().forEach(System.out::println);
	}

	private static void addCategoryTest() {
		Category category = new Category("Category test");
		categoryDao.insert(category);
		System.out.println("insert thanh cong!!!");
	}
	
	private static void getCategoryByIdTest() {
		int id = 12;
		Category category = categoryDao.getById(id);
		System.out.println(category);
	}

	private static void updateCategoryTest() {
		int id = 12;
		Category category = categoryDao.getById(id);
		category.setNameCategory("Category test updated");
		categoryDao.update(category);
		System.out.println(category);
	}

	private static void deleteCategoryTest() {
		int id = 12;
		Category category = categoryDao.getById(id);
		category.setNameCategory("Category test updated");
		categoryDao.delete(category);
		System.out.println("delete thanh cong!!!");
	}

	public static void main(String[] args) {
		CategoryDAOTest.deleteCategoryTest();
	}
}
