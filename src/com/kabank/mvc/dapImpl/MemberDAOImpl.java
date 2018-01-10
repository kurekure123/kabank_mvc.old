package com.kabank.mvc.dapImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jni.Mmap;

import com.kabank.mvc.constants.DBMS;
import com.kabank.mvc.dao.MemberDAO;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.enums.DDLEnum;
import com.kabank.mvc.enums.DMLEnum;
import com.kabank.mvc.enums.Enums;
import com.kabank.mvc.enums.Enums.MemberSqlColumn;
import com.kabank.mvc.enums.TNameEnum;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DatabaseFactory;
import com.sun.glass.ui.Pixels.Format;

public class MemberDAOImpl implements MemberDAO{
	
	List<MemberBean> list;
	Connection conn;
	Statement stmt;
	String sql;
	ResultSet rs;
		
	// static instance 에 접근 할 수 있는 정적 메서드 정의
	
	// 아래가 singleton pattern
	public static MemberDAO getInstance() {return new MemberDAOImpl();}
	private MemberDAOImpl() {}

	@Override
	public List<MemberBean> selectMembers() {
		try{
			list = new ArrayList<MemberBean>();
			StringBuffer sql = new StringBuffer(DMLEnum.SELECT.toString())
					.insert(6, " *").append(TNameEnum.MEMBER);
			rs = DatabaseFactory.createDatabase(Vendor.ORACLE)
					.getConnection().createStatement().executeQuery(sql.toString());
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

	@Override
	public void addMembers(MemberBean m) {
		try {
			list = new ArrayList<MemberBean>();
			StringBuffer sql = new StringBuffer(DMLEnum.INSERT.toString())
					.insert(11, " "+ TNameEnum.MEMBER +"("+ Enums.getSql() +") ")
					.append("("+Enums.getBlanks(Enums.MemberSqlColumn.values().length)+")");
			
			DatabaseFactory.createDatabase(Vendor.ORACLE)
			.getConnection().createStatement().executeQuery(String.format
					(sql.toString(),
						m.getId(),
						m.getPass(),
						m.getName(), 
						m.getSsn(), 
						m.getPhone(),
						m.getEmail(), 
						m.getProfile(), 
						m.getAddress()
						));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public MemberBean selectMemberById(MemberBean m) {
		MemberBean mem = null;
		try {
			StringBuffer sql = new StringBuffer(DMLEnum.SELECT_ID_PASS.toString());
			 rs = DatabaseFactory.createDatabase(Vendor.ORACLE)
			.getConnection()
			.createStatement()
			.executeQuery(String.format(sql.toString(), m.getId(), m.getPass()));
			while(rs.next()) {
				mem = new MemberBean();
				mem.setId(rs.getString("id"));
				mem.setPass(rs.getString("pass"));
				mem.setName(rs.getString("name"));
				mem.setSsn(rs.getString("ssn"));
				mem.setPhone(rs.getString("phone"));
				mem.setEmail(rs.getString("email"));
				mem.setProfile(rs.getString("profile"));
				mem.setAddress(rs.getString("addr"));
			} 
			
			/* ResultSet rs = DriverManager.getConnection(DBMS.ORACLE_CONNECTION_URL, DBMS.ORACLE_USERNAME, DBMS.ORACLE_PASSWORD)
					.createStatement().executeQuery(String.format("SELECT * FROM Member WHERE id ='%s' AND pass ='%s' ", m.getId(), m.getPass()));
			while(rs.next()) {
				mem = new MemberBean();
				mem.setId(rs.getString("id"));
				mem.setPass(rs.getString("pass"));
				mem.setName(rs.getString("name"));
				mem.setSsn(rs.getString("ssn"));
				mem.setPhone(rs.getString("phone"));
				mem.setEmail(rs.getString("email"));
				mem.setProfile(rs.getString("profile"));
				mem.setAddress(rs.getString("addr"));
			} **/
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mem;
	}
	
}
