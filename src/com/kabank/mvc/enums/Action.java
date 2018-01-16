package com.kabank.mvc.enums;

public enum Action {
	MOVE, ADD, LOGIN, JOIN, SEARCH, CHANGE_PASS, WITHDRAW,
	VIEW{
		@Override
		public String toString() {
			return "/WEB-INF/view/";
		}
	},
	EXTENTION{
		@Override
		public String toString() {
			return ".jsp";
		}
	},
	SEPARATOR{
		@Override
		public String toString() {
			return "/";
		}
	}
}
