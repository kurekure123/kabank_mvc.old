package com.kabank.mvc.daoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jni.Mmap;

import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.constants.DBMS;
import com.kabank.mvc.dao.MemberDAO;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.enums.DDLEnum;
import com.kabank.mvc.enums.DMLEnum;
import com.kabank.mvc.enums.Enums;
import com.kabank.mvc.enums.Enums.MemberSqlColumn;
import com.kabank.mvc.enums.MemberEnum;
import com.kabank.mvc.enums.TNameEnum;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DatabaseFactory;
import com.kabank.mvc.factory.SqlFactory;
import com.sun.glass.ui.Pixels.Format;

import javafx.scene.chart.PieChart.Data;

public class MemberDAOImpl implements MemberDAO{
	
	List<MemberBean> list;
	Connection conn;
	Statement stmt;
	ResultSet rs;
	MemberBean member;
	String[] arr;
	StringBuffer sql;
		
	@Override
	public MemberBean login() {
		System.out.println("MEMBER-D : LOGIN");
		sql = new StringBuffer(MemberEnum.LOGIN.toString());
		arr= InitCommand.cmd.getData().split("/");
		System.out.println("ID : " + arr[0]);
		System.out.println(" PASS : " + arr[1]);
		sql.replace(sql.indexOf("$"), sql.indexOf("$") + 1 , arr[0]);
		sql.replace(sql.indexOf("@"), sql.indexOf("@") + 1, arr[1]);
		System.out.println("::::SQL::::" + sql.toString());
		member = null;
		rs = null;
		
		try {
			rs = DatabaseFactory.create(Vendor.ORACLE).getConnection().createStatement()
					.executeQuery(sql.toString());
			while(rs.next()) {
				member = new MemberBean();
				member.setId(rs.getString(MemberEnum.ID.toString()));
				member.setPass(rs.getString(MemberEnum.PASS.toString()));
				member.setName(rs.getString(MemberEnum.NAME.toString()));
				member.setSsn(rs.getString(MemberEnum.SSN.toString()));
				member.setPhone(rs.getString(MemberEnum.PHONE.toString()));
				member.setEmail(rs.getString(MemberEnum.EMAIL.toString()));
				member.setProfile(rs.getString(MemberEnum.PROFILE.toString()));
				member.setAddress(rs.getString(MemberEnum.ADDR.toString()));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("MEMBER-D : LOGOUT");
		return member;
		
	}
	// static instance 에 접근 할 수 있는 정적 메서드 정의
	
	// 아래가 singleton pattern
	public static MemberDAO getInstance() {return new MemberDAOImpl();}
	private MemberDAOImpl() {}

	@Override
	public List<MemberBean> selectMembers() {
		try{
			list = new ArrayList<MemberBean>();
			rs = DatabaseFactory.create(Vendor.ORACLE)
					.getConnection().createStatement().executeQuery(SqlFactory.create(6, " ", MemberEnum.ID +","
							+ MemberEnum.PASS + " " + TNameEnum.MEMBER));
			while(rs.next()) {
				MemberBean m = new MemberBean();
				m.setId(rs.getString(MemberEnum.ID.name()));
				m.setPass(rs.getString(MemberEnum.PASS.name()));
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
			
			DatabaseFactory.create(Vendor.ORACLE)
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
			 rs = DatabaseFactory.create(Vendor.ORACLE)
			.getConnection()
			.createStatement()
			.executeQuery(String.format(sql.toString(), m.getId(), m.getPass()));
			while(rs.next()) {
				mem = new MemberBean();
				mem.setId(rs.getString(MemberEnum.ID.name()));
				mem.setPass(rs.getString(MemberEnum.PASS.name()));
				mem.setName(rs.getString(MemberEnum.NAME.name()));
				mem.setSsn(rs.getString(MemberEnum.SSN.name()));
				mem.setPhone(rs.getString(MemberEnum.PHONE.name()));
				mem.setEmail(rs.getString(MemberEnum.EMAIL.name()));
				mem.setProfile(rs.getString(MemberEnum.PROFILE.name()));
				mem.setAddress(rs.getString(MemberEnum.ADDR.name()));
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
		
		System.out.println("======MEMBER-D LOGOUT======");
		return mem;
	}


	@Override
	public void updatePass(MemberBean member) {
		System.out.println("업데이트 패스 입장");
		String pass = InitCommand.cmd.getData();
		sql = new StringBuffer(DMLEnum.UPDATE_PASSWORD.toString());
		sql.replace(sql.indexOf("$"), sql.indexOf("$")+1, member.getId());
		sql.replace(sql.indexOf("@"), sql.indexOf("@")+1, pass);
		System.out.println("SQL ::::: " + sql.toString());
		
		try {
		DatabaseFactory.create(Vendor.ORACLE).getConnection().createStatement().executeUpdate(sql.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("======업데이트 패스 LOGOUT======");
		
	}

	@Override
	public void deleteId(MemberBean member) {
		System.out.println("delete Id 입장");
		String id = member.getId();
		System.out.println(id);
		sql = new StringBuffer(DMLEnum.DELETE_ID.toString());
		sql.replace(sql.indexOf("$"), sql.indexOf("$")+1, id);
		System.out.println(" ===SQL==== : " + sql.toString());
		try {
			DatabaseFactory.create(Vendor.ORACLE).getConnection().createStatement().executeUpdate(sql.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		System.out.println("delete Id 로그아웃");
	}
	
}
