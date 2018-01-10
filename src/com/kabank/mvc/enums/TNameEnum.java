package com.kabank.mvc.enums;

public enum TNameEnum {
 MEMBER, ATTEND, TNAMES{
	 @Override
	public String toString() {
		return MEMBER+","+ATTEND;
	} }
}
