package com.kabank.mvc.serviceimpl;

import com.kabank.mvc.dao.MemberDAO;
import com.kabank.mvc.dapImpl.MemberDAOImpl;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.service.MemberService;
import java.util.*;

public class MemberServiceImpl implements MemberService{
	
	@Override
	public boolean login(MemberBean m) {
		boolean flag = false;
		MemberDAO dao = new MemberDAOImpl();
		List<MemberBean> list = dao.selectMembers();
		for(int i = 0; i < list.size(); i++) {
			if(m.getId().equals(list.get(i).getId()) && m.getPass().equals(list.get(i).getPass())) {
				flag = true;
			}
		}
		//for(){if() {}else {}}
		return flag;
	}

}
