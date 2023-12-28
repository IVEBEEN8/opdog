package com.opdoghj.volunteer;

import java.sql.Date;

public class volunteerDTO {
	private int a_no;
	private int v_no;
	private String v_title;
	private String v_img;
	private String v_txt;
	private Date v_created;
	private Date v_updated;
	private String a_email;
	private String v_status;

	public volunteerDTO() {
		// TODO Auto-generated constructor stub
	}

	public volunteerDTO(int a_no, int v_no, String v_title, String v_img, String v_txt, Date v_created, Date v_updated,
			String a_email, String v_status) {
		super();
		this.a_no = a_no;
		this.v_no = v_no;
		this.v_title = v_title;
		this.v_img = v_img;
		this.v_txt = v_txt;
		this.v_created = v_created;
		this.v_updated = v_updated;
		this.a_email = a_email;
		this.v_status = v_status;
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

	public Date getV_created() {
		return v_created;
	}

	public void setV_created(Date v_created) {
		this.v_created = v_created;
	}

	public Date getV_updated() {
		return v_updated;
	}

	public void setV_updated(Date v_updated) {
		this.v_updated = v_updated;
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

	@Override
	public String toString() {
		return "volunteerDTO [a_no=" + a_no + ", v_no=" + v_no + ", v_title=" + v_title + ", v_img=" + v_img
				+ ", v_txt=" + v_txt + ", v_created=" + v_created + ", v_updated=" + v_updated + ", a_email=" + a_email
				+ ", v_status=" + v_status + "]";
	}

}