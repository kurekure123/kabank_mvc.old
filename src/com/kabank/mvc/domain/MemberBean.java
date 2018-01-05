package com.kabank.mvc.domain;

public class MemberBean {
	private String id, pass, name, ssn, phone, email, profile, address;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "회원정보 [ID : " + id + ", 비밀번호 : " + pass + ", 이름 : " + name
				+ ", 주민번호(생년월일 첫번째) : " + ssn + ", 전화번호 : " + phone + ", 이메일 : "
				+ ", 프로필사진  : " + profile + "주소 : " +  address +  " ]"; 
	}
}
