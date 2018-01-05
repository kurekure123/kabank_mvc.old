<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
	<link rel="stylesheet" href="../../css/admin.css" />
	<link rel="stylesheet" href="../../css/common.css" />
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
	<form id="member_register_form" action="member_register.jsp">
	<table style="margin: 0px auto;">
		<tr style = "height: 50px; border-bottom: 1px solid grey;">
			<td>
				<p>아이디</p>
			</td>
			<td style = "margin-top : 100px; height: 50px;">
				<input type="text" name="id" placeholder="아이디" />
			</td>
		</tr>
		<tr style = "height: 50px; border-bottom: 1px solid grey;">
			<td>
				<p>이름</p>
			</td>	
			<td >
				<input type="text" name="name" placeholder="이름"/>
			</td>
		</tr>
		<tr style = "height: 50px; border-bottom: 1px solid grey;">
			<td>
				<p>주민번호  </p>
			</td>
			<td style = "height: 50px;">
				<input type="text" name="ssn" placeholder="주민번호 앞자리" />
			</td>
		</tr>
		<tr style = "height: 50px; border-bottom: 1px solid grey;">
			<td>
				<p>전화번호  </p>
			</td>	
			<td style = "height: 50px;">
				<input type="text" name="phone" placeholder="전화번호" />
			</td>
		</tr>
		<tr style = "height: 50px; border-bottom: 1px solid grey;">
			<td>
				<p>이메일 </p>
			</td>	
			<td style = "height: 50px;">
				<input type="text" name="email" placeholder="이메일" />
			</td>
		</tr>
		<tr style = "height: 50px; border-bottom: 1px solid grey;">	
			<td>
			 	<p>주소</p>
			</td>
			<td style = "height: 50px;">
				<input type="text" name="addr" placeholder="주소"/>
			</td>
		</tr>
	</table>
		<button id="member_register_btn" style = "margin-left : 100px; width : 100px; " >멤버추가</button>
	</form>	
</section>	 	
</div>
<script src="../../js/admin/member_register_form.js"></script>
<%@ include file="../common/footer.jsp" %>
</body>
</html>