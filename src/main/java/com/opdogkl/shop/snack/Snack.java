package com.opdogkl.shop.snack;

public class Snack {
	private int s_no;
	private String s_img;
	private String s_title;
	private int s_price;
	private String s_brand;
	
	public Snack() {
		// TODO Auto-generated constructor stub
	}

	public Snack(int s_no, String s_img, String s_title, int s_price, String s_brand) {
		super();
		this.s_no = s_no;
		this.s_img = s_img;
		this.s_title = s_title;
		this.s_price = s_price;
		this.s_brand = s_brand;
	}

	public int getS_no() {
		return s_no;
	}

	public void setS_no(int s_no) {
		this.s_no = s_no;
	}

	public String getS_img() {
		return s_img;
	}

	public void setS_img(String s_img) {
		this.s_img = s_img;
	}

	public String getS_title() {
		return s_title;
	}

	public void setS_title(String s_title) {
		this.s_title = s_title;
	}

	public int getS_price() {
		return s_price;
	}

	public void setS_price(int s_price) {
		this.s_price = s_price;
	}

	public String getS_brand() {
		return s_brand;
	}

	public void setS_brand(String s_brand) {
		this.s_brand = s_brand;
	}
	
	
}
