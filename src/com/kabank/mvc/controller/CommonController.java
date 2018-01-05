package com.kabank.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kabank.mvc.constants.Path;
import com.kabank.mvc.service.CommonService;
import com.kabank.mvc.serviceimpl.CommonServiceImpl;

/**
 * Servlet implementation class CommonController
 */
@WebServlet("/common/jdbc_test.do")
public class CommonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CommonService service;
	public CommonController() {
		service = new CommonServiceImpl();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dir = request.getServletPath().split(Path.SEPARATOR)[1];
		String dest =  request.getServletPath().split(Path.SEPARATOR)[2].split(Path.DOT)[0];
		request.setAttribute("count", service.selectTableCount());
		request.getRequestDispatcher(Path.VIEW + dir + Path.SEPARATOR + dest + Path.EXTENSION).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
