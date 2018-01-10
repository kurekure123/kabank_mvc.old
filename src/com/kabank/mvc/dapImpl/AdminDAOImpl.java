package com.kabank.mvc.dapImpl;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import com.kabank.mvc.constants.AdminSql;
import com.kabank.mvc.constants.DBMS;
import com.kabank.mvc.dao.AdminDAO;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.enums.DMLEnum;
import com.kabank.mvc.enums.TNameEnum;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DatabaseFactory;
import com.kabank.mvc.serviceimpl.AdminServiceImpl;

import sun.security.jca.GetInstance.Instance;

public class AdminDAOImpl implements AdminDAO {
	List<MemberBean> result;
	AdminServiceImpl adminservice;
	Connection conn;
	Statement stmt;
	ResultSet rs;

	public static AdminDAO getInstance() {
		return new AdminDAOImpl();
	}
	
	public AdminDAOImpl() {
	}


	@Override
	public void createTable(String sql) {
		try {
			StringBuffer name = new StringBuffer(DMLEnum.SELECT.toString())
					.insert(6,  "*").append(TNameEnum.MEMBER);
		rs = DatabaseFactory.createDatabase(Vendor.ORACLE)
				.getConnection().createStatement().executeQuery(name.toString());
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
