package com.opdoghw.login;

public class LoginDTO {
	private String email;
	private String firstname;
	private String lastname;
	private String pw;
	private int no;


public LoginDTO() {
	// TODO Auto-generated constructor stub
}


public LoginDTO(String email, String firstname, String lastname, String pw, int no) {
	super();
	this.email = email;
	this.firstname = firstname;
	this.lastname = lastname;
	this.pw = pw;
	this.no = no;
}



public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public String getFirstname() {
	return firstname;
}


public void setFirstname(String firstname) {
	this.firstname = firstname;
}


public String getLastname() {
	return lastname;
}


public void setLastname(String lastname) {
	this.lastname = lastname;
}


public String getPw() {
	return pw;
}


public void setPw(String pw) {
	this.pw = pw;
}


public int getNo() {
	return no;
}


public void setNo(int no) {
	this.no = no;
}


@Override
public String toString() {
	return "LoginDTO [email=" + email + ", firstname=" + firstname + ", lastname=" + lastname + ", pw=" + pw + "]";
}



}
