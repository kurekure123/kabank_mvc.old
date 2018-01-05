<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%
	Statement stmt = null;
	Connection conn = null;
	String sql = "";
	ResultSet rs = null;
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "bitcamp", "bitcamp");
		stmt = conn.createStatement();
		sql = "SELECT * FROM tab";
		rs = stmt.executeQuery(sql);
		List<String> list = new ArrayList<>();
		while(rs.next()){
			String temp = rs.getString("TNAME");
			list.add(temp);
		}
		boolean exist = false;
		for(String s : list){
			if(s.equalsIgnoreCase("member")){
				exist = true;
				break;
			}
		}
			if(!exist){
				stmt.executeQuery("CREATE TABLE Member("
						+ "id VARCHAR2(20) PRIMARY KEY,"
						+ "pass VARCHAR2(20),"
						+ "name VARCHAR2(20),"
						+ "ssn VARCHAR2(20),"
						+ "phone VARCHAR2(20),"
						+ "email VARCHAR2(20),"
						+ "profile VARCHAR2(20),"
						+ "addr VARCHAR2(20)"
						+")");
			}
	
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		if(stmt != null){
			try{stmt.close();}catch(Exception e){
				e.printStackTrace();
			}
		}
		if(conn != null){
			try{conn.close();}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
%>