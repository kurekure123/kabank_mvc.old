<%@ page import="org.eclipse.jdt.internal.compiler.flow.FinallyFlowContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<%@ page import="java.util.*" %>

<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin.css" />
	<link rel="stylesheet" href=".${pageContext.request.contextPath}/resources/css/common.css" />
</head>
<body>
<div id="wrapper">
<header>
	<h1> 관리자 메인 페이지 </h1>	
</header>
<aside id="admin_aside">
 <a id="member_mgmt_link">회원관리</a>
</aside>
<section id="admin_section">
	<form action="">
		<table id = "member_table" style="margin: 0 auto;" >
			<tr>
				<td>
					검색 방법
					<select name="search" id="search">
					<option value="">이름
						</option>
					<option value="">성별
						</option>
					</select>
					<input type="text" style="width : 200 px;" />
					<input type="submit" value = "검색" />
				</td>
			</tr>
		</table>
	</form>

		<table id="member_table" style="padding-top : 30px; margin :  0 auto; ">
		 	<tr>
		 		<th>NO</th>
		 		<th>ID</th>
		 		<th>NAME</th>
		 		<th>DATE OF BIRTH</th>
		 		<th>GENDER</th>
		 		<th>CONTACT</th>
		 		<th>EMAIL</th>
		 		<th>ADRESS</th>
		 	</tr>

	</table>
		<button id="member_register_btn" style="margin-left: 420px;">멤버추가</button>
</section>	 	
</div>
<%@ include file="../common/footer.jsp" %>
</body>
	<script>
		document.querySelector('').addEventListener('click', ,false);
	</script>

</html>