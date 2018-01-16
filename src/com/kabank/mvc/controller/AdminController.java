package com.kabank.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kabank.mvc.constants.Path;
import com.kabank.mvc.domain.AdminBean;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.service.AdminService;
import com.kabank.mvc.serviceimpl.AdminServiceImpl;

@WebServlet("/admin.do")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L; // 직렬화 1L의 l 은 long type

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdminService service = new AdminServiceImpl();
		String dir = request.getServletPath().substring(1, 6); 
		//1이상 6 미만
		String cmd = request.getParameter("cmd");
		String page = request.getParameter("page");
				
		String dest = "";
		if(cmd.equals("move")) {
		switch(page) {
		case "main" :
			dest = page;
			break;
		case "create_table" :
			dest = "main";
			service.makeTable(request.getParameter("table_name"));
		}
		request.getRequestDispatcher(Path.VIEW + dir + Path.SEPARATOR + dest + Path.EXTENSION).forward(request, response);
	}
	}	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
