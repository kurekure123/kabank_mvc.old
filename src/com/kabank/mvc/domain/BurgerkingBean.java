package com.kabank.mvc.domain;

import java.io.Serializable;

public class BurgerkingBean implements Serializable{
	private String menu, price, count;

	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getMenu() {
		return menu;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPrice() {
		return price;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getCount() {
		return count;
	}

	@Override
	public String toString() {
		return "메뉴 [상품명: " + menu + ", 가격 : ]" + price + "원, 수량 " + count +"]";
	}
	
	
}
