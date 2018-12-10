package vn.edu.poly.tuanltph04663.util;

import java.util.List;
import java.util.stream.Collectors;

import vn.edu.poly.tuanltph04663.model.Products;

public class DefaultImage {

	/**
	 * Get default image if product has no image
	 * 
	 * @param products
	 * @return
	 */
	public List<Products> getDefaultImage(List<Products> products) {
		List<Products> result = products.stream().map(e -> {
			if ("".equals(e.getImage()) || null == e.getImage()) {
				e.setImage("sp1.png");
			}
			return e;
		}).collect(Collectors.toList());

		return result;
	}
}
