package com.kabank.mvc.dao;

import java.sql.*;

public class JDBCTest {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
					"bitcamp", "bitcamp");
			Statement stmt = conn.createStatement();
			String sql = "SELECT (*) FROM tab";
			// COUNT(*)  = 전체 갯수 ,  AS count = 키값으로 count 라는 변수에 할당하시게 라는 명령어, tab = table의 약자
			ResultSet rs = stmt.executeQuery(sql);
			String count = "";
			while (rs.next()) {
				count = rs.getString("tname");
			}
			System.out.println("테이블 수 : " + count);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 상속구조
		
	}
}
