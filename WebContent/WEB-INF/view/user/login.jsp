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
		<form id="login_form" action="${ctx}/user/auth.do">
			 <table id = "index_login_box">
					<tr>
						<td>
							<input id="index_input_id" name ="id" type="text" placeholder="아이디">
						</td>
	   					 <td rowspan= "2">
	   					 	<input id = "index_login_btn" type="submit" value="로그인" 	>
	   					 </td>
					</tr>
					<tr>
						<td >
							<input id= "index_input_pass" name = "pass" type="text" placeholder="비밀번호">
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
	location.href = "${ctx}/user/join.do "
	} , false)
	document.querySelector('#go_jdbc_link').addEventListener('click', 
	function() {
	alert('체크')
	location.href = "${ctx}/common/jdbc_test.do"
	} , false);
	
	document.querySelector('#index_login_btn').addEventListener('click', 
		function() {
		document.querySelector('#login_form').submit();
	}, false);
	
	document.querySelector('#go_admin_link').addEventListener('click', 
			function(){
			location.href = "${ctx}/admin/main.do"
	}, false);
	
	
	</script>
	</body>
	
</html>