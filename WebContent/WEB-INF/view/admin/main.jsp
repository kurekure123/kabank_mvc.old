<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<body>
<div id="wrapper">
<header id="admin_header">
	<h1> 관리자 메인 페이지 </h1>	
</header>
<aside id="admin_aside">
	<p> 회원 관리 </p>
</aside>
<section id="admin_section">
		<table id="admin_table" style="">
		 	<tr>
		 		<td>
		 			<a id="create_table" href = "#">
		 				<button>멤버리스트</button>
		 			</a>
		 		</td>
		 		<td>
		 			<p>2</p>
		 		</td>
		 		<td>
		 			<p>3</p>
		 		</td>
		 	</tr>
		 	<tr>
		 		<td>
		 			<p>4</p>
		 		</td>
		 		<td>
		 			<p>5</p>
		 		</td>
		 		<td>
		 			테이블생성 <br />
		 			<form id="create_table_form" action="${pageContext.request.contextPath}/admin/create_table.do">	
		 				<select name="table_name" >
		 					<option value="member">회원테이블
		 					<option value="attend">출석테이블
		 				</select>
		 				<button id="create_table_btn">전송</button>
		 			</form>
		 		</td>
		 	</tr>
	</table>
</section>	 	
</div>
<%@ include file="../common/footer.jsp" %>
</body>
	<script>
		document.querySelector('#create_table').addEventListener('click', createtable ,false);
		function createtable() {
			alert('췍췍췍');
			location.href = "${pageContext.request.contextPath}/admin/member_list.do"
		}
		
		document.querySelector('#create_table_btn').addEventListener('click',
			function() {
			document.querySelector('#create_table_form').submit()
		}, false);
		
		
	</script>
</html>