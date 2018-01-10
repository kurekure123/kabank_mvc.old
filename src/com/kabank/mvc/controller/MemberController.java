package com.kabank.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kabank.mvc.constants.Path;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.service.MemberService;
import com.kabank.mvc.serviceimpl.MemberServiceImpl;

@WebServlet( {"/user/login.do" , "/user/join.do", "/user/auth.do", "/user/signup.do",
	 "/user/add.do"})
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L; // 직렬화 1L의 l 은 long type

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/*
		String path = request.getServletPath();
		String[] path1 = path.split("/"); // /member/login.do
		String[] path2 = path1[2].split("\\.");
		// substring[8]은 8번째 이후의 텍스트를 받겠다. 라는 뜻
		String action = path2[0];
		**/
		/*
		String dir = request.getServletPath().split(Path.SEPARATOR)[1];
		String dest =  request.getServletPath().split(Path.SEPARATOR)[2].split(Path.DOT)[0];
		**/	
		String dir = request.getServletPath().split(Path.SEPARATOR)[1]; 
		String id = request.getServletPath().split(Path.SEPARATOR)[2].split(Path.DOT)[0];
		String dest = "";
		MemberBean m = new MemberBean();
		HttpSession session = request.getSession();
		MemberService service = MemberServiceImpl.getInstance();
		switch(id) {
		case "login" :
			dest = id;
			break;
		case "join" : 
			dest = id;
			break;
		case "auth" :
			m.setId(request.getParameter("id"));
			m.setPass(request.getParameter("pass"));
			MemberBean member = service.findMemberById(m);
			if(member!=null) {
				dir = "bitcamp";
				dest = "main";
				session.setAttribute("user", member);
			}else {
				dir = "user";
				dest = "login";
			}
			break;
		case "signup" :	
			m.setId(request.getParameter("id"));
			m.setPass(request.getParameter("pass"));
			m.setName(request.getParameter("name"));
			m.setSsn(request.getParameter("ssn"));
			m.setEmail(request.getParameter("email"));
			m.setPhone(request.getParameter("phone"));
			m.setAddress(request.getParameter("addr"));
			//dest = "/WEB-INF/view/bitcamp/main.jsp";
			service.addMember(m);
			dest = "login";
			break;
		} 
		
		request.getRequestDispatcher(Path.VIEW + dir + Path.SEPARATOR + dest + Path.EXTENSION).forward(request, response);
		/*RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/user/"+dest".jsp");
		rd.forward(request, response);**/
		/* request.getRequestDispatcher(Path.VIEW + dir + Path.SEPARATOR + dest + Path.EXTENSION).forward(request, response); **/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
//dispatcher는 보내는 애
}
