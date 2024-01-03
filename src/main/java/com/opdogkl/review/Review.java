package com.opdogkl.review;

import java.util.Date;

public class Review {
	private int r_no;
	private String r_img;
	private String r_title;
	private String r_txt;
	private Date r_created;
	private Date r_updated;
	private int a_no;
	
	public Review() {
		// TODO Auto-generated constructor stub
	}

	public Review(int r_no, String r_img, String r_title, String r_txt, Date r_created, Date r_updated, int a_no) {
		super();
		this.r_no = r_no;
		this.r_img = r_img;
		this.r_title = r_title;
		this.r_txt = r_txt;
		this.r_created = r_created;
		this.r_updated = r_updated;
		this.a_no = a_no;
	}

	public int getR_no() {
		return r_no;
	}

	public void setR_no(int r_no) {
		this.r_no = r_no;
	}

	public String getR_img() {
		return r_img;
	}

	public void setR_img(String r_img) {
		this.r_img = r_img;
	}

	public String getR_title() {
		return r_title;
	}

	public void setR_title(String r_title) {
		this.r_title = r_title;
	}

	public String getR_txt() {
		return r_txt;
	}

	public void setR_txt(String r_txt) {
		this.r_txt = r_txt;
	}

	public Date getR_created() {
		return r_created;
	}

	public void setR_created(Date r_created) {
		this.r_created = r_created;
	}

	public Date getR_updated() {
		return r_updated;
	}

	public void setR_updated(Date r_updated) {
		this.r_updated = r_updated;
	}

	public int getA_no() {
		return a_no;
	}

	public void setA_no(int a_no) {
		this.a_no = a_no;
	}

	
		
}
