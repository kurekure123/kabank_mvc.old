package com.kabank.mvc.service;

import com.kabank.mvc.domain.MemberBean;

public interface MemberService {

	public void addMember(MemberBean m);
	public MemberBean findMemberById(MemberBean m);
	public MemberBean login();
	public void changePass(MemberBean member);

}
