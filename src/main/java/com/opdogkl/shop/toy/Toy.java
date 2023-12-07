package com.opdogkl.shop.toy;

public class Toy {
	private int t_no;
	private String t_img;
	private String t_title;
	private int t_price;
	private String t_brand;
	
	public Toy() {
		// TODO Auto-generated constructor stub
	}

	public Toy(int t_no, String t_img, String t_title, int t_price, String t_brand) {
		super();
		this.t_no = t_no;
		this.t_img = t_img;
		this.t_title = t_title;
		this.t_price = t_price;
		this.t_brand = t_brand;
	}

	public int getT_no() {
		return t_no;
	}

	public void setT_no(int t_no) {
		this.t_no = t_no;
	}

	public String getT_img() {
		return t_img;
	}

	public void setT_img(String t_img) {
		this.t_img = t_img;
	}

	public String getT_title() {
		return t_title;
	}

	public void setT_title(String t_title) {
		this.t_title = t_title;
	}

	public int getT_price() {
		return t_price;
	}

	public void setT_price(int t_price) {
		this.t_price = t_price;
	}

	public String getT_brand() {
		return t_brand;
	}

	public void setT_brand(String t_brand) {
		this.t_brand = t_brand;
	}
	
	
	
}
