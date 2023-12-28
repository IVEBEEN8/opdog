package com.opdogkl.shop.fashion;

public class Fashion {
	private int fs_no;
	private String fs_img;
	private String fs_title;
	private int fs_price;
	private String fs_brand;
	
	public Fashion() {
		// TODO Auto-generated constructor stub
	}

	public Fashion(int fs_no, String fs_img, String fs_title, int fs_price, String fs_brand) {
		super();
		this.fs_no = fs_no;
		this.fs_img = fs_img;
		this.fs_title = fs_title;
		this.fs_price = fs_price;
		this.fs_brand = fs_brand;
	}

	public int getFs_no() {
		return fs_no;
	}

	public void setFs_no(int fs_no) {
		this.fs_no = fs_no;
	}

	public String getFs_img() {
		return fs_img;
	}

	public void setFs_img(String fs_img) {
		this.fs_img = fs_img;
	}

	public String getFs_title() {
		return fs_title;
	}

	public void setFs_title(String fs_title) {
		this.fs_title = fs_title;
	}

	public int getFs_price() {
		return fs_price;
	}

	public void setFs_price(int fs_price) {
		this.fs_price = fs_price;
	}

	public String getFs_brand() {
		return fs_brand;
	}

	public void setFs_brand(String fs_brand) {
		this.fs_brand = fs_brand;
	}
	
	
}
