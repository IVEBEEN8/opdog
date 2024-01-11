package com.opdoghoho.mypage;

import java.util.Date;

public class TotalPoint {
	private String date;
	private String text;
	private int point;
	
	public TotalPoint() {
		// TODO Auto-generated constructor stub
	}

	public TotalPoint(String date, String text, int point) {
		super();
		this.date = date;
		this.text = text;
		this.point = point;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	
	
	
}
