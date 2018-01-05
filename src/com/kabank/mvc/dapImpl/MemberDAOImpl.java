package com.kabank.mvc.dapImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kabank.mvc.constants.DBMS;
import com.kabank.mvc.dao.MemberDAO;
import com.kabank.mvc.domain.MemberBean;

public class MemberDAOImpl implements MemberDAO{
	
	List<MemberBean> list;
	
	public MemberDAOImpl() {
		list = new ArrayList<MemberBean>();
	}
	
	@Override
	public List<MemberBean> selectMembers() {
		try{
			Class.forName(DBMS.ORACLE_DRIVER);
			Connection conn = DriverManager.getConnection(DBMS.ORACLE_CONNECTION_URL, DBMS.ORACLE_USERNAME, DBMS.ORACLE_PASSWORD);
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM Member";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				MemberBean m = new MemberBean();
				m.setId(rs.getString("id"));
				m.setPass(rs.getString("pass"));
				list.add(m);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
		
	}
	
}
