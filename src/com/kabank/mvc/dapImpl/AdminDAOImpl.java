package com.kabank.mvc.dapImpl;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import com.kabank.mvc.constants.AdminSql;
import com.kabank.mvc.constants.DBMS;
import com.kabank.mvc.dao.AdminDAO;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.serviceimpl.AdminServiceImpl;

public class AdminDAOImpl implements AdminDAO {
	List<MemberBean> result;
	AdminServiceImpl adminservice;

	public AdminDAOImpl() {
		result = new ArrayList<>();
		adminservice = new AdminServiceImpl();
	}

	@Override
	public void createTable(String sql) {
		try {
			Class.forName(DBMS.ORACLE_DRIVER);
			Connection conn = DriverManager.getConnection(DBMS.ORACLE_CONNECTION_URL, DBMS.ORACLE_USERNAME,
					DBMS.ORACLE_PASSWORD);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * from tab");
			List<String> list = new ArrayList<>();
			System.out.println(sql);
			while (rs.next()) {
				String temp = rs.getString("TNAME");
				list.add(temp);
			}
			boolean exist = false;
			for (String s : list) {
				if (s.equalsIgnoreCase("member")) {
					exist = true;
					break;
				}
			}
			if (!exist) {
				stmt.executeUpdate(sql);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}	
