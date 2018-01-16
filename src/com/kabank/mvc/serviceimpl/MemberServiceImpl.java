package com.kabank.mvc.serviceimpl;

import com.kabank.mvc.dao.MemberDAO;
import com.kabank.mvc.daoImpl.MemberDAOImpl;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.service.MemberService;
import java.util.*;

import org.apache.catalina.connector.Request;

public class MemberServiceImpl implements MemberService{
	MemberDAO dao; 
	
	
	public static MemberServiceImpl getInstance() {
		return new MemberServiceImpl();
	}
	private MemberServiceImpl() {
	}
	
	public interface MemberService{

		Object login();
		
	}
	
	@Override
	public MemberBean findMemberById(MemberBean m) {
		//for(){if() {}else {}}
		return MemberDAOImpl.getInstance().selectMemberById(m);
	}

	@Override
	public void addMember(MemberBean m) {
		MemberDAOImpl.getInstance().addMembers(m);
		
	}
	@Override
	public MemberBean login() {
		return MemberDAOImpl.getInstance().login();
	}
	@Override
	public void changePass(MemberBean member) {
		MemberDAOImpl.getInstance().updatePass(member);
	System.out.println("===== 서비스 임플 체인지 패스 진입 ====");
	 System.out.println("===== 서비스 임플 체인지 패스 탈출 ====");
	}
	public void withdraw(MemberBean member) {
		// TODO Auto-generated method stub
		MemberDAOImpl.getInstance().deleteId(member);
		System.out.println("===== 서비스 임플 withraw 진입 ====");
		 System.out.println("===== 서비스 임플 withraw 탈출 ====");
		
	}

}
