<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding ="UTF-8"%>
<%@ include file="../common/header.jsp" %> 
<body>

<div id = "wrapper">

 	<header id="index_header">
		<h1>BIT CAMP</h1>
	</header>
	<section id= "index_section">
	
		<article>
	<table id="index_table">
		<tr>
		<td colspan="5">
		<form id="login_form" action="${ctx}/user.do">
			 <table id = "index_login_box">
					<tr>
						<td>
							<input id="index_input_id" name ="id" type="text" value="kurekure123" placeholder="아이디">
						</td>
	   					 <td rowspan= "2">
	   					 	<input id = "index_login_btn" type="submit" value="로그인" 	>
	   					 </td>
					</tr>
					<tr>
						<td >
							<input id= "index_input_pass" name = "pass" type="password" value="24865" placeholder="비밀번호">
							<input type="hidden" name = "cmd" value="login" />
							<input type="hidden" name = "dir" value="bitcamp" />
							<input type="hidden" name = "page" value="main" />
						</td>
					</tr>
				
				</table>
			</form>
			<a id= "go_admin_link" type="button" href="#">
				관리자
			</a>
			<a id = "go_join_link" type="button" href="#">
				회원가입
			</a>						
			<a id = "go_jdbc_link" type="button" href="#">
				JDBCTest
			</a>						
			</td>
		 </tr>
	</table>		
	</article>
	</section>
	</div>
		<%@ include file="../common/footer.jsp" %>
	<script>
	document.querySelector('#go_join_link').addEventListener('click', 
	function() {
	alert('클릭');
	location.href = "${ctx}/user.do?cmd=move&page=join"
	} , false)
	document.querySelector('#go_jdbc_link').addEventListener('click', 
	function() {
	alert('체크')
	location.href = "${ctx}/common.do?cmd=move&page=jdbc_test"
	} , false);
	
	document.querySelector('#index_login_btn').addEventListener('click', 
		function() {
		document.querySelector('#login_form').submit();
	}, false);
	
	document.querySelector('#go_admin_link').addEventListener('click', 
		function(){
		location.href = "${ctx}/admin.do?cmd=login&dir=bitcamp&page=main"
	}, false);
	
	
	</script>
	</body>
	
</html>