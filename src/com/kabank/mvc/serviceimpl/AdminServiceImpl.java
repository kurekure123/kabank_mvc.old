package com.kabank.mvc.serviceimpl;

import java.util.List;

import com.kabank.mvc.constants.AdminSql;
import com.kabank.mvc.controller.AdminController;
import com.kabank.mvc.dao.AdminDAO;
import com.kabank.mvc.dapImpl.AdminDAOImpl;
import com.kabank.mvc.domain.AdminBean;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.enums.DDLEnum;
import com.kabank.mvc.service.AdminService;

public class AdminServiceImpl implements AdminService{

	@Override
	public void makeTable(String tname) {
		System.out.println("================ 내부로 들어옴");
		System.out.println(tname);
		AdminDAO admindao = new AdminDAOImpl(); 
		String sql = "";
		switch(tname) {
			case "member" : 
				sql = DDLEnum.CREATE_TABLE_MEMBER.toString();
				break;
			case "attend" :
				sql = DDLEnum.CREATE_TABLE_ATTEND.toString();
				break;
		}
		admindao.createTable(sql);
		System.out.println(sql);
		
	/*	if(tname.equalsIgnoreCase("member")) {
			admindao.membercheckTable();
		} else {
			admindao.attendcheckTable();
		}*/
	}
	
}
