package com.opdoghj.volunteer;

import java.sql.Date;

public class volunteerDTO {
	private int a_no;
	private int v_no;
	private String v_title;
	private String v_img;
	private String v_txt;
	private String v_updated;
	private Date v_created;
	private String v_status;
	private String a_email;
	private String v_locate;

	public volunteerDTO() {
		// TODO Auto-generated constructor stub
	}



	public volunteerDTO(int a_no, int v_no, String v_title, String v_img, String v_txt, String v_updated,
			Date v_created, String v_status, String a_email, String v_locate) {
		super();
		this.a_no = a_no;
		this.v_no = v_no;
		this.v_title = v_title;
		this.v_img = v_img;
		this.v_txt = v_txt;
		this.v_updated = v_updated;
		this.v_created = v_created;
		this.v_status = v_status;
		this.a_email = a_email;
		this.v_locate = v_locate;
	}



	public int getA_no() {
		return a_no;
	}

	public void setA_no(int a_no) {
		this.a_no = a_no;
	}

	public int getV_no() {
		return v_no;
	}

	public void setV_no(int v_no) {
		this.v_no = v_no;
	}

	public String getV_title() {
		return v_title;
	}

	public void setV_title(String v_title) {
		this.v_title = v_title;
	}

	public String getV_img() {
		return v_img;
	}

	public void setV_img(String v_img) {
		this.v_img = v_img;
	}

	public String getV_txt() {
		return v_txt;
	}

	public void setV_txt(String v_txt) {
		this.v_txt = v_txt;
	}



	public String getV_updated() {
		return v_updated;
	}



	public void setV_updated(String v_updated) {
		this.v_updated = v_updated;
	}



	public Date getV_created() {
		return v_created;
	}



	public void setV_created(Date v_created) {
		this.v_created = v_created;
	}



	public String getA_email() {
		return a_email;
	}

	public void setA_email(String a_email) {
		this.a_email = a_email;
	}

	public String getV_status() {
		return v_status;
	}

	public void setV_status(String v_status) {
		this.v_status = v_status;
	}

	public String getV_locate() {
		return v_locate;
	}

	public void setV_locate(String v_locate) {
		this.v_locate = v_locate;
	}

	@Override
	public String toString() {
		return "volunteerDTO [a_no=" + a_no + ", v_no=" + v_no + ", v_title=" + v_title + ", v_img=" + v_img
				+ ", v_txt=" + v_txt + ", v_created=" + v_created + ", v_status=" + v_status + ", a_email=" + a_email
				+ ", v_locate=" + v_locate + "]";
	}

}