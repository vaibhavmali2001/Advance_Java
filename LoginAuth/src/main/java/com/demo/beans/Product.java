package com.demo.beans;

public class Product {
	
	private int id;
	private String pname;
	private int qty;
	private float price;
	public Product() {
		super();
	}
	public Product(int id, String pname, int qty, float price) {
		super();
		this.id = id;
		this.pname = pname;
		this.qty = qty;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", pname=" + pname + ", qty=" + qty + ", price=" + price + "]";
	}
	
	

}
