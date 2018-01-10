package com.kabank.mvc.enums;

public class Enums {
	public enum MemberColumn {
		ID,PASS,NAME 
	}
	public enum MemberSqlColumn{
		ID,PASS,NAME,SSN,PHONE,EMAIL,PROFILE,ADDR
	}
	public enum Table{
		MEMBER,ATTEND,ADMIN
	}
	
	public enum DML{
		SELECT, INSERT, INTO, UPDATE, DELETE, FROM
	}
	public static String getSql(){
		MemberSqlColumn[] column = MemberSqlColumn.values();
		String setSql = "";
		for(int i = 0; i<column.length; i++) {
			if(!(i == column.length-1)) {
				setSql += column[i]+ ",";
			}else {
				setSql += column[i];
			}
		}
		
		return setSql;
	}
	
	public static String getBlanks(int count) {
		String blanks = "";
		for(int i = 0; i<count; i++) {
			if(!(i == MemberSqlColumn.values().length-1)) {
				blanks += "'%s'," ;
			}else {
				blanks += "'%s'";
			}
			
		}
		return blanks;
	}
}
