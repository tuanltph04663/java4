package vn.edu.poly.tuanltph04663.model;

public class Detail implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idDetail;
	private Cart cart;
	private Products products;
	private Integer quality;

	public Detail() {
	}

	public Detail(Cart cart, Products products) {
		this.cart = cart;
		this.products = products;
	}

	public Detail(Cart cart, Products products, Integer quality) {
		this.cart = cart;
		this.products = products;
		this.quality = quality;
	}

	public Integer getIdDetail() {
		return this.idDetail;
	}

	public void setIdDetail(Integer idDetail) {
		this.idDetail = idDetail;
	}

	public Cart getCart() {
		return this.cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Products getProducts() {
		return this.products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	public Integer getQuality() {
		return this.quality;
	}

	public void setQuality(Integer quality) {
		this.quality = quality;
	}

}
