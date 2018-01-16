<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<%@ include file="../common/nav.jsp"%>
<section>
<div class="changePass">
	<form id="changepass_form" action="${ctx}/user.do">
		현재비밀번호 <br />
		<input name="current_pass" type="text" value="${sessionScope.user.pass} " /><br />
		새 비밀번호 <br />
		<input name="newPass" type="text" /><br />
		새 비밀번호  확인 <br />
		<input name="new_pass_check" type="text" /><br />
		<input type="hidden" name = "cmd" value="change_pass" />
		<input type="hidden" name = "dir" value="bitcamp" />
		<input type="hidden" name = "page" value="main" />
	</form>
		<button id="confirm_btn" >확인</button>
		<button id="cancel_btn"  >취소</button>
</div>
</section>
<%@ include file="../common/footer.jsp"%>
</body>
<script>
document.querySelector('#confirm_btn').addEventListener('click', 
		function() {
			document.querySelector('#changepass_form').submit()}
 			, false)
 			
 document.querySelector("#cancel_btn").addEventListener('click', 
		 function() {
			location.href = "${ctx}/user.do?cmd=move&page=main"
		}, false);
</script>
</html>