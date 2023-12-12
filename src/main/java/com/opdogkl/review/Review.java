package com.opdogkl.review;

import java.util.Date;

public class Review {
	private String r_img;
	private String r_title;
	private String r_txt;
	private Date r_created;
	private Date r_updated;
	private String op_email;
	
	public Review() {
		// TODO Auto-generated constructor stub
	}

	public Review(String r_img, String r_title, String r_txt, Date r_created, Date r_updated, String op_email) {
		super();
		this.r_img = r_img;
		this.r_title = r_title;
		this.r_txt = r_txt;
		this.r_created = r_created;
		this.r_updated = r_updated;
		this.op_email = op_email;
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

	public String getOp_email() {
		return op_email;
	}

	public void setOp_email(String op_email) {
		this.op_email = op_email;
	}

	
	
		
}
