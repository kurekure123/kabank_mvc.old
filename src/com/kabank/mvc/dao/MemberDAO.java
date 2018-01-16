package com.kabank.mvc.dao;

import java.util.List;

import com.kabank.mvc.domain.MemberBean;

public interface MemberDAO {
	public MemberBean selectMemberById(MemberBean m);

	public void addMembers(MemberBean m);
	List<MemberBean> selectMembers();
	public MemberBean login();
	public void updatePass(MemberBean member);

	public void deleteId(MemberBean member);
}
