<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
	<body>
<%@ include file ="../common/header.jsp" %>
<%@ include file="../common/nav.jsp" %>
<%
try{
	Class.forName("oracle.jdbc.driver.OracleDriver");	
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "bitcamp", "bitcamp");
	Statement stmt = conn.createStatement();
	String sql = "SELECT * FROM tab";
	ResultSet rs = stmt.executeQuery(sql);
	List<String> list = new ArrayList<>();
	while(rs.next()){
		String temp = rs.getString("TNAME");
		list.add(temp);
	}
	boolean exist = false;
	for(String s : list){
		if(s.equalsIgnoreCase("attend")){
			exist = true;
			break;
		}
	}
	
	if(!exist){
		stmt.executeQuery("CREATE TABLE Attend("
				+ "id VARCHAR(20) PRIMARY KEY,"
				+ "week VARCHAR(20),"
				+ "status VARCHAR(20)"
				+ ")" );
		
	}
}catch(Exception e){e.printStackTrace();
}




%>

<div>
<section>
<h1> 비트 캠프</h1>
<article>
<div>
	<table id="bitcamp_profile_table">
		<tr id="bitcamp_profile_table tr">
			<td rowspan="4" class="photo"><img src="" width="170px" height="170px" alt="" /></td>
			<td class="column1">ID</td>
			<td class="column2">${sessionScope.user.id}</td>
			<td class="column1">생년</td>
			<td class="column2">${sessionScope.user.ssn}</td>
		</tr>
		<tr>
			<td class="column1">Password</td>
			<td>${sessionScope.user.pass}</td>
			<td class="column1">전화번호</td>
			<td>${sessionScope.user.phone}</td>
		</tr>
		<tr>
			<td class="column1">이름</td>
			<td>${sessionScope.user.name}</td>
			<td class="column1">이메일</td>
			<td>${sessionScope.user.email}</td>
		</tr>
		<tr>
			<td class="column1">성별</td>
			<td>남자</td>
			<td class="column1">주소</td>
			<td>${sessionScope.user.address}</td>
		</tr>
	</table>
</div>
<table id = "no" style="width : 90%; height : 100%;margin : 50px auto; border: 1px solid grey;">
	<tr style=" height : 5%;margin : 50px auto; ">
		<th>상태</th>
		<th>월</th>
		<th>화</th>
		<th>수</th>
		<th>목</th>
		<th>금</th>
	</tr>
	<tr id="bitcamp_attend">
		<td>
			<p>출석 여부</p>
		</td>
		<td>
			<select name="monday" id="">
				<option value="">출석</option>
				<option value="">결석</option>
				<option value="">지각</option>
				<option value="">조퇴</option>
			</select>
		</td>
		<td>
			<select name="tuesday" id="">
				<option value="">출석</option>
				<option value="">결석</option>
				<option value="">지각</option>
				<option value="">조퇴</option>
			</select>
		</td>
		<td>
			<select name="wednesday" id="">
				<option value="">출석</option>
				<option value="">결석</option>
				<option value="">지각</option>
				<option value="">조퇴</option>
			</select>
		</td>
		<td>
			<select name="thursday" id="">
				<option value="">출석</option>
				<option value="">결석</option>
				<option value="">지각</option>
				<option value="">조퇴</option>
			</select>
		</td>
		<td>
			<select name="friday" id="">
				<option value="">출석</option>
				<option value="">결석</option>
				<option value="">지각</option>
				<option value="">조퇴</option>
			</select>
		</td>
	</tr>
	<tr>
		<td>결과</td>
		<td><input type="text" id="result" /></td>
		<td><input type="text" id="result" /></td>
		<td><input type="text" id="result" /></td>
		<td><input type="text" id="result" /></td>
		<td><input type="text" id="result" /></td>
	</tr>
</table>
	<input type="hidden" name = "id" value="kurekure123" />
	<button id="attend" style="width: 200px" >제출</button>
	<button id="change_pass" style="width: 200px" >비밀번호 변경</button>
	<button id="withdraw" style="width: 200px" >탈퇴</button>

</article>
</section>
</div>
<%@ include file="../common/footer.jsp" %>
</body>
<script>
	document.querySelector('#change_pass').addEventListener('click',
			function () {
			location.href="${ctx}/user.do?cmd=move&dir=bitcamp&page=change";
			}
			,false)
	document.querySelector('#withdraw').addEventListener('click', 
			function() {
				location.href="${ctx}/user.do?cmd=withdraw"
			}
			, false)
</script>
</html>