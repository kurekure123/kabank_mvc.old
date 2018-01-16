package com.kabank.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kabank.mvc.command.ChangeCommand;
import com.kabank.mvc.command.Command;
import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.command.LoginCommand;
import com.kabank.mvc.command.MoveCommand;
import com.kabank.mvc.command.SearchCommand;
import com.kabank.mvc.daoImpl.MemberDAOImpl;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.service.MemberService;
import com.kabank.mvc.serviceimpl.MemberServiceImpl;
import com.kabank.mvc.util.DispatcherServlet;

@WebServlet( "/user.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L; // 직렬화 1L의 l 은 long type
	MemberBean member;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberService service = MemberServiceImpl.getInstance();
		InitCommand init = new InitCommand(request);
		init.execute();
		System.out.println("파라미터 cmd" + request.getParameter("cmd"));
		System.out.println("겟 액션" + InitCommand.cmd.getAction());
		switch(InitCommand.cmd.getAction()) {
			case MOVE : 
				System.out.println("====MEMBER-C : MOVE IN =====");
				new MoveCommand(request).execute();
				DispatcherServlet.send(request, response); 
				System.out.println("====MEMBER-C : MOVE OUT =====");
			break;
			case JOIN : 
				System.out.println("====MEMBER-C : JOIN IN====");
				break;
			case LOGIN :
				System.out.println("======MEMBER-C LOGIN======");
				new SearchCommand(request).execute();
				member = MemberServiceImpl.getInstance().login();
				
				if(member==null) {
					InitCommand.cmd.setDir("user");
					InitCommand.cmd.setPage("login");
				}else {
					session.setAttribute("user", member);
					InitCommand.cmd.setDir("bitcamp");
					InitCommand.cmd.setPage("main");
				}
				new MoveCommand(request).execute();
				DispatcherServlet.send(request, response); 
				
				System.out.println("===== LOGIN ==== OUT====");
				break;
			case ADD :	
				System.out.println("MEMBER ADD");
				member.setId(request.getParameter("id"));
				member.setPass(request.getParameter("pass"));
				member.setName(request.getParameter("name"));
				member.setSsn(request.getParameter("ssn"));
				member.setEmail(request.getParameter("email"));
				member.setPhone(request.getParameter("phone"));
				member.setAddress(request.getParameter("addr")); 
				//dest = "/WEB-INF/view/bitcamp/main.jsp";
				service.addMember(member);
				// dest = "login";
				break; 
			case CHANGE_PASS : 
				member = new MemberBean();
				System.out.println("=== 체인지 패스 진입===");
				new ChangeCommand(request).execute();
				member.setId(((MemberBean) session.getAttribute("user")).getId());
				member.setPass(InitCommand.cmd.getData());
				MemberServiceImpl.getInstance().changePass(member);
				session.setAttribute("user", member);
				System.out.println("변경확인  :"  + member.toString());
				System.out.println("====DEST IS ==== :" + InitCommand.cmd.getView());
				System.out.println("=== 체인지 패스 탈출!===");
				move(request);
				DispatcherServlet.send(request, response); 
				break;
			case WITHDRAW :
				member = new MemberBean();
				System.out.println("=== 위드로우 진입===");
				member.setId(((MemberBean)session.getAttribute("user")).getId());
				session.setAttribute("user", member);
				System.out.println("변경확인  :"  + member.toString());
				MemberServiceImpl.getInstance().withdraw(member);
				move(request);
				DispatcherServlet.send(request, response);
				break;
			default:
				break;
				}
		
		/*RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/user/"+dest".jsp");
		rd.forward(request, response);**/
		/* request.getRequestDispatcher(Path.VIEW + dir + Path.SEPARATOR + dest + Path.EXTENSION).forward(request, response); **/
		}
	
	private void move(HttpServletRequest request) {
		new MoveCommand(request).execute();
	}

	@SuppressWarnings("unused")
	private void login(HttpServletRequest request, HttpSession session) {
		new LoginCommand(request).execute();
		MemberBean member = MemberServiceImpl.getInstance().login();
		if(member == null) {
			InitCommand.cmd.setDir("user");
			InitCommand.cmd.setPage("login");
		} else {
			session.setAttribute("user", member);
			InitCommand.cmd.setDir("bitcamp");
			InitCommand.cmd.setPage("main");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
//dispatcher는 보내는 애
}
