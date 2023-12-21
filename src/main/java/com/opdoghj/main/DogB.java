package com.opdoghj.main;

public class DogB {
	private String popfile;
	private String kindCd;
	private String sexCd;
	private String age;
	private String specialMark;
	private int date;
	private int Dday;
	public DogB() {
		// TODO Auto-generated constructor stub
	}
	public DogB(String popfile, String kindCd, String sexCd, String age, String specialMark, int date, int dday) {
		super();
		this.popfile = popfile;
		this.kindCd = kindCd;
		this.sexCd = sexCd;
		this.age = age;
		this.specialMark = specialMark;
		this.date = date;
		Dday = dday;
	}
	public String getPopfile() {
		return popfile;
	}
	public void setPopfile(String popfile) {
		this.popfile = popfile;
	}
	public String getKindCd() {
		return kindCd;
	}
	public void setKindCd(String kindCd) {
		this.kindCd = kindCd;
	}
	public String getSexCd() {
		return sexCd;
	}
	public void setSexCd(String sexCd) {
		this.sexCd = sexCd;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSpecialMark() {
		return specialMark;
	}
	public void setSpecialMark(String specialMark) {
		this.specialMark = specialMark;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public int getDday() {
		return Dday;
	}
	public void setDday(int dday) {
		Dday = dday;
	}
	
	
	
	
}
