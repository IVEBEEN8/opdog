package com.opdoghj.volunteer;

public class appliedVol {
	private String title;
	private String status;
	private String created;
	private String imgf;
	private String txt;
	private String email;

	public appliedVol() {
	}

	public appliedVol(String title, String status, String created, String imgf, String txt, String email) {
		super();
		this.title = title;
		this.status = status;
		this.created = created;
		this.imgf = imgf;
		this.txt = txt;
		this.email = email;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getImgf() {
		return imgf;
	}

	public void setImgf(String imgf) {
		this.imgf = imgf;
	}

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "appliedVol [title=" + title + ", status=" + status + ", created=" + created + ", imgf=" + imgf
				+ ", txt=" + txt + ", email=" + email + "]";
	}

}
