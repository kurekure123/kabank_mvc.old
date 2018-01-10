package com.kabank.mvc.util;

import com.kabank.mvc.enums.Enums;

public class MainTest {
	public static void main(String[] args) {
		for(Enums.MemberSqlColumn c : Enums.MemberSqlColumn.values()) {
			System.out.println("컬럼명 : "+c);
		}
	}
}
