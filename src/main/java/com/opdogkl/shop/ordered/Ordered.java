package com.opdogkl.shop.ordered;

public class Ordered {
	private int o_no;
	private String o_title;
	private int o_price;
	private String o_brand;
	private int o_sPrice;
	private int a_no;
	
	public Ordered() {
		// TODO Auto-generated constructor stub
	}

	public Ordered(int o_no, String o_title, int o_price, String o_brand, int o_sPrice, int a_no) {
		super();
		this.o_no = o_no;
		this.o_title = o_title;
		this.o_price = o_price;
		this.o_brand = o_brand;
		this.o_sPrice = o_sPrice;
		this.a_no = a_no;
	}

	public int getO_no() {
		return o_no;
	}

	public void setO_no(int o_no) {
		this.o_no = o_no;
	}

	public String getO_title() {
		return o_title;
	}

	public void setO_title(String o_title) {
		this.o_title = o_title;
	}

	public int getO_price() {
		return o_price;
	}

	public void setO_price(int o_price) {
		this.o_price = o_price;
	}

	public String getO_brand() {
		return o_brand;
	}

	public void setO_brand(String o_brand) {
		this.o_brand = o_brand;
	}

	public int getO_sPrice() {
		return o_sPrice;
	}

	public void setO_sPrice(int o_sPrice) {
		this.o_sPrice = o_sPrice;
	}

	public int getA_no() {
		return a_no;
	}

	public void setA_no(int a_no) {
		this.a_no = a_no;
	}
	
	
	

}
