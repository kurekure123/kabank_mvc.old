<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/head.jsp" %>
<body>
<div>

 	<header>
		<h1>회원 가입</h1>
	</header>
	
<section  id = "members_section">
	<article>
	<form id="join_form" action="${pageContext.request.contextPath}/user/login.do" >
		<table id = "members_table">
			<tr >
				<td >
					<p> 아이디 입력</p>
				</td>
				
				<td>
				<input id="join_id" type="text" name="id" placeholder="아이디" />
					<button id= "check_dupl_btn" name="id_check">중복확인
					</button>
				</td>
			<tr>
				<td>
					<p>비밀번호 입력</p>
				</td>
				<td>
					<input id="pass" type="text" name="pass" placeholder="비밀번호" />
				</td>
			</tr>
			<tr>
				<td>
					<p>비밀번호 재확인</p>
				</td>
				<td>
					<input id= "pass_check" type="text" name="pass_check"  placeholder="비밀번호" />
				</td>
			</tr>
			<tr>
				<td>
					<p>이름 입력</p>
				</td>	
				<td>
					<input id = "name" type="text" name="name" placeholder="이름 입력"  />
				</td>
			</tr>
			<tr>	
				<td>
					<p>주민번호 입력</p>
				</td>
				<td>
					<input type="text" id ="ssn" name="ssn" placeholder="주민번호 앞자리입력" />
					<!-- 
					<input type="text" id ="spn1" name="ssn1" placeholder="주민번호 앞자리입력" /> - 
					<input type="text" id="spn2" name="ssn2" placeholder="주민번호 뒷자리입력"  />
					 -->
				</td>
			</tr>
			<tr>	
				<td>
					<p>본인확인 이메일</p>
				</td>
				<td>
					<input type="email" name="email" placeholder="이메일 입력"  /> 
				<!-- 
					<input type="email" name="email" placeholder="이메일 입력"  /> @ 
					<select name="" id="">
						<option value="">naver.com
						</option>
						<option value="">daum.com
						</option>
						<option value="">google.com
						</option>
						<option value="">yahoo.com
						</option>
						<option value="">직접입력
						</option>
					</select>
				 -->	
				</td>
			</tr>
			<tr>	
				<td>
					<p>핸드폰 번호</p>
				</td>
				<td>
					<input type="text" name="phone" />
				 <!--	<input type="checkbox" name="telecom" value="skt"/>SKT
					<input type="checkbox" name="telecom" value="KT"/>KT
					<input type="checkbox" name="telecom" value="LG"/>LG <br>
					<select name="phone1" id="">
						<option value="010">010
						</option>
						<option value="011">011
						</option>	
					</select>
					<input style="width: 100px" pattern="[0-9]{4}" type="tel" name="phone2" placeholder="앞자리" /> - 
					<input style="width: 100px" pattern="[0-9]{4}" type="tel" name="phone3" placeholder="뒷자리" />
				 -->
				</td>
			</tr>
			<tr>
				<td>
					<p>사진 업로드</p>
				</td>	
				<td>
					<input type="file" name="profile"/>
					<input type="submit" name = "upload" value = "사진 등록" />
				</td>
			</tr>
			<tr>	
				<td>
					<p>주소등록</p>
				</td>
				<td>
					<input type="text" name="addr"/>
				</td>
			</tr>
			<tr>	
				<td colspan="2">
					<button id = "join_confirm_btn" style = " width :160px; height : 30px" >확인</button> 
					<button style = " width :160px; height : 30px" >취소</button>
				</td>
			</tr>
		</table>
	</form>
</article>	
</section>
</div>	
	<%@ include file="../common/footer.jsp" %>
	<script>
		var joinConfirmBtn = document.querySelector('#join_confirm_btn').addEventListener("click",joinConfirm, false);
		var checkConfirm = document.querySelector('#check_dupl_btn').addEventListener("click",checkId, false);
	
		function joinConfirm() {
			alert('가입 완료');
			document.querySelector('#join_form').submit();
		}
		function checkId(e) {
			e.preventDefault();
			alert('중복확인');
		}
	</script>	
	</body>
</html>

<!-- 
<tr>
	<td>
		<input type="date" />
	</td>
</tr>
-->