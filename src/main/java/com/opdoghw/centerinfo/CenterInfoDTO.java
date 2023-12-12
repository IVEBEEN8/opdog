package com.opdoghw.centerinfo;

public class CenterInfoDTO {
	private int no;
	private String careNm;
	private String careAddr;
	private float lat;
	private float lng;
	private int vetPersonCnt;
	private String careTel;
	private String oprtime;
	private String closetime;
	private String closeday;
	private String caretel;

	public CenterInfoDTO() {
		// TODO Auto-generated constructor stub
	}

	public CenterInfoDTO(int no, String careNm, String careAddr, float lat, float lng, int vetPersonCnt, String careTel,
			String oprtime, String closetime, String closeday, String caretel2) {
		super();
		this.no = no;
		this.careNm = careNm;
		this.careAddr = careAddr;
		this.lat = lat;
		this.lng = lng;
		this.vetPersonCnt = vetPersonCnt;
		this.careTel = careTel;
		this.oprtime = oprtime;
		this.closetime = closetime;
		this.closeday = closeday;
		caretel = caretel2;
	}

	public String getCloseday() {
		return closeday;
	}

	public void setCloseday(String closeday) {
		this.closeday = closeday;
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

	public String getOprtime() {
		return oprtime;
	}

	public void setOprtime(String oprtime) {
		this.oprtime = oprtime;
	}

	public String getClosetime() {
		return closetime;
	}

	public void setClosetime(String closetime) {
		this.closetime = closetime;
	}

	public String getCaretel() {
		return caretel;
	}

	public void setCaretel(String caretel) {
		this.caretel = caretel;
	}

	@Override
	public String toString() {
		return "CenterInfoDTO [no=" + no + ", careNm=" + careNm + ", careAddr=" + careAddr + ", lat=" + lat + ", lng="
				+ lng + ", vetPersonCnt=" + vetPersonCnt + ", careTel=" + careTel + ", oprtime=" + oprtime
				+ ", closetime=" + closetime + ", closeday=" + closeday + ", caretel=" + caretel + "]";
	}

}
