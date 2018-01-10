package com.kabank.mvc.enums;

public enum OracleEnum {
	//ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver",
	//ORACLE_CONNECTION_URL = "jdbc:oracle:thin:@localhost:1521:xe",
	//ORACLE_USERNAME = "bitcamp",
	//ORACLE_PASSWORD = "bitcamp"	
	ORACLE_DRIVER("oracle.jdbc.driver.OracleDriver"),
	ORACLE_CONNECTION_URL("jdbc:oracle:thin:@localhost:1521:xe"),		
	ORACLE_USERNAME("bitcamp"),
	ORACLE_PASSWORD("bitcamp");
	
	public String getValue() {
		return value;
	}
	public final String value; 
	private OracleEnum(String value) {
		this.value = value; 
	}
}
