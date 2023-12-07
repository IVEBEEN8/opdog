package com.opdogkl.shop.feed;

public class Feed {
	private int f_no;
	private String f_img;
	private String f_title;
	private int f_price;
	private String f_brand;
	
	public Feed() {
		// TODO Auto-generated constructor stub
	}

	public Feed(int f_no, String f_img, String f_title, int f_price, String f_brand) {
		super();
		this.f_no = f_no;
		this.f_img = f_img;
		this.f_title = f_title;
		this.f_price = f_price;
		this.f_brand = f_brand;
	}

	public int getF_no() {
		return f_no;
	}

	public void setF_no(int f_no) {
		this.f_no = f_no;
	}

	public String getF_img() {
		return f_img;
	}

	public void setF_img(String f_img) {
		this.f_img = f_img;
	}

	public String getF_title() {
		return f_title;
	}

	public void setF_title(String f_title) {
		this.f_title = f_title;
	}

	public int getF_price() {
		return f_price;
	}

	public void setF_price(int f_price) {
		this.f_price = f_price;
	}

	public String getF_brand() {
		return f_brand;
	}

	public void setF_brand(String f_brand) {
		this.f_brand = f_brand;
	}
	
	
	
}
