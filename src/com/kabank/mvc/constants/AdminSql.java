package com.kabank.mvc.constants;

public class AdminSql {
	public static final String CREAT_MEMBER = 
			"CREATE TABLE Member("
					+ "id VARCHAR2(20) PRIMARY KEY,"
					+ "pass VARCHAR2(20),"
					+ "name VARCHAR2(20),"
					+ "ssn VARCHAR2(20),"
					+ "phone VARCHAR2(20),"
					+ "email VARCHAR2(20),"
					+ "profile VARCHAR2(20),"
					+ "addr VARCHAR2(20)"
					+")";
	
	public static final String CREAT_ATTEND = 
			"CREATE TABLE Attend("
					+ "seq NUMBER PRIMARY KEY,"
					+ "week VARCHAR(20),"
					+ "status VARCHAR(20)"
					+ "id VARCHAR(20)"
					+ ")";
}
