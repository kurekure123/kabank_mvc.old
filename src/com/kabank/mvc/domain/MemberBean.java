package com.kabank.mvc.domain;

import lombok.Data;

@Data
public class MemberBean {
	private String id, pass, name, ssn, phone, email, profile, address;


	@Override
	public String toString() {
		return "회원정보 [ID : " + id + ", 비밀번호 : " + pass + ", 이름 : " + name
				+ ", 주민번호(생년월일 첫번째) : " + ssn + ", 전화번호 : " + phone + ", 이메일 : "
				+ ", 프로필사진  : " + profile + "주소 : " +  address +  " ]"; 
	}
}
