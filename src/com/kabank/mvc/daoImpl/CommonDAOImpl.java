package com.kabank.mvc.daoImpl;

import com.kabank.mvc.dao.CommonDAO;
import java.sql.*;

import com.kabank.mvc.constants.CommonSql;
import com.kabank.mvc.constants.DBMS;

public class CommonDAOImpl implements CommonDAO{
	CommonSql commonsql = new CommonSql();

	@Override
	public String countTable() {
		String count = "";
		try {
			Class.forName(DBMS.ORACLE_DRIVER);
			Connection conn =  DriverManager.getConnection(DBMS.ORACLE_CONNECTION_URL, DBMS.ORACLE_USERNAME, DBMS.ORACLE_PASSWORD);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(CommonSql.getCount(" member"));
			while(rs.next()){
				count = rs.getString("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
}
