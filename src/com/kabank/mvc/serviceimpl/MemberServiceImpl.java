package com.kabank.mvc.serviceimpl;

import com.kabank.mvc.dao.MemberDAO;
import com.kabank.mvc.dapImpl.MemberDAOImpl;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.service.MemberService;
import java.util.*;

public class MemberServiceImpl implements MemberService{
	MemberDAO dao; 
	
	
	public static MemberService getInstance() {
		return new MemberServiceImpl();
	}
	private MemberServiceImpl() {
		dao = MemberDAOImpl.getInstance();
	}
	
	
	@Override
	public MemberBean findMemberById(MemberBean m) {
		//for(){if() {}else {}}
		return dao.selectMemberById(m);
	}

	@Override
	public void addMember(MemberBean m) {
		dao.addMembers(m);
		
	}



}
