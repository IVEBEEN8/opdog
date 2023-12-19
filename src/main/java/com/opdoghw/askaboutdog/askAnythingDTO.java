package com.opdoghw.askaboutdog;

public class askAnythingDTO {

	private String askanything;

	public askAnythingDTO() {
		// TODO Auto-generated constructor stub
	}

	public askAnythingDTO(String askanything) {
		super();
		this.askanything = askanything;
	}

	public String getAskanything() {
		return askanything;
	}

	public void setAskanything(String askanything) {
		this.askanything = askanything;
	}

	@Override
	public String toString() {
		return "askAnythingDTO [askanything=" + askanything + "]";
	}

}
