package com.kabank.mvc.factory;

import com.kabank.mvc.enums.Action;

public class ActionFactory {
	public static Action create(String x) {
		Action action = null;
		if(x==null) {x="move";}
		switch (x) {
		case "move": action=Action.MOVE; break;
		case "login" : action=Action.LOGIN; break;
		case "change_pass" : action=Action.CHANGE_PASS; break;
		case "withdraw" : action=Action.WITHDRAW; break;
		default:
			action=Action.MOVE;
			break;
		}
		System.out.println("액션은 : " + action.toString());
		return action;
	}
}
