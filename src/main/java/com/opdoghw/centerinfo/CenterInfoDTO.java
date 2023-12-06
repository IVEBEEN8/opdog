package com.opdoghw.centerinfo;

public class CenterInfoDTO {
	private int no;
	private String careNm;
	private String careAddr;
	private float lat;
	private float lng;
	private int vetPersonCnt;
	private String careTel;
	
	
	public CenterInfoDTO() {
		// TODO Auto-generated constructor stub
	}


	public CenterInfoDTO(int no, String careNm, String careAddr, float lat, float lng, int vetPersonCnt,
			String careTel) {
		super();
		this.no = no;
		this.careNm = careNm;
		this.careAddr = careAddr;
		this.lat = lat;
		this.lng = lng;
		this.vetPersonCnt = vetPersonCnt;
		this.careTel = careTel;
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public String getCareNm() {
		return careNm;
	}


	public void setCareNm(String careNm) {
		this.careNm = careNm;
	}


	public String getCareAddr() {
		return careAddr;
	}


	public void setCareAddr(String careAddr) {
		this.careAddr = careAddr;
	}


	public float getLat() {
		return lat;
	}


	public void setLat(float lat) {
		this.lat = lat;
	}


	public float getLng() {
		return lng;
	}


	public void setLng(float lng) {
		this.lng = lng;
	}


	public int getVetPersonCnt() {
		return vetPersonCnt;
	}


	public void setVetPersonCnt(int vetPersonCnt) {
		this.vetPersonCnt = vetPersonCnt;
	}


	public String getCareTel() {
		return careTel;
	}


	public void setCareTel(String careTel) {
		this.careTel = careTel;
	}


	@Override
	public String toString() {
		return "CenterInfoDTO [no=" + no + ", careNm=" + careNm + ", careAddr=" + careAddr + ", lat=" + lat + ", lng="
				+ lng + ", vetPersonCnt=" + vetPersonCnt + ", careTel=" + careTel + "]";
	}
	
	
}
