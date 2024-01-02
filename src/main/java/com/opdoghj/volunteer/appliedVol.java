package com.opdoghj.volunteer;

public class appliedVol {
	private int preivateNo;
	private int accountNo;
	private int postNo;
	private String title;
	private String status;
	private String created;
	private String applied;
	private String imgf;
	private String txt;
	private String email;

	public appliedVol() {
		// TODO Auto-generated constructor stub
	}

	public appliedVol(int preivateNo, int accountNo, int postNo, String title, String status, String created,
			String applied, String imgf, String txt, String email) {
		super();
		this.preivateNo = preivateNo;
		this.accountNo = accountNo;
		this.postNo = postNo;
		this.title = title;
		this.status = status;
		this.created = created;
		this.applied = applied;
		this.imgf = imgf;
		this.txt = txt;
		this.email = email;
	}

	public int getPreivateNo() {
		return preivateNo;
	}

	public void setPreivateNo(int preivateNo) {
		this.preivateNo = preivateNo;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
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

	public String getApplied() {
		return applied;
	}

	public void setApplied(String applied) {
		this.applied = applied;
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
		return "appliedVol [preivateNo=" + preivateNo + ", accountNo=" + accountNo + ", postNo=" + postNo + ", title="
				+ title + ", status=" + status + ", created=" + created + ", applied=" + applied + ", imgf=" + imgf
				+ ", txt=" + txt + ", email=" + email + "]";
	}

}
