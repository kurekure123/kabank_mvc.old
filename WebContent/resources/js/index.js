/**
 * 
 */

function init() {
	var	goAdminLink = document.querySelector('#go_admin_link');
	var	goJoinLink = document.querySelector('#go_join_link');
	var indexLoginBtn = document.querySelector('#index_login_btn');
	goAdminLink.addEventListener("click", goAdmin, false);
	goJoinLink.addEventListener("click" , goJoin, false);
	indexLoginBtn.addEventListener("click", indexLogin, false);
}

function indexLogin(e) {
	
	var loginId = document.querySelector('#index_input_id').value;
	var joinId = sessionStorage.getItem('id');
	var joinPass = document.querySelector('#pass')
	var loginPass = document.querySelector('#index_input_pass').value;
	if(loginId === joinId){
		if(!(loginId === joinId)){
			alert("입력하신" + loginId + "는 존재하지 않는 아이디 입니다." )
			e.preventDefault();
		}else if(!(loginPass === joinPass)){
			alert("패스워드가 틀렸습니다." )
			e.preventDefault();
		}
	}	
}

function goAdmin(e) {
	var admin = confirm('관리자?');
	if(admin){
		location.href = "../jsp/admin/main.jsp";
	}else{
		alert('관리자만 접근 가능합니다.');
}	
	
}
function goJoin(e){
	location.href = "../jsp/user/join_form.jsp";
}
window.addEventListener("load", init, false);
/*
 * 이벤트 핸들러 (초창기 방식)
window.onload = execute;
	function execute(){
		document.querySelector('#go_admin').onclick = goAdmin;
		document.querySelector('#go_join').onclick = goJoin;
	}
	function goAdmin(){
		var admin = confirm('관리자?');
		if(admin){
			alert('안녕하세요 관리자님');
			location.href = "../jsp/burgerking/main.jsp";
		}else{
			alert('관리자만 접근 가능합니다.');
		}
		
	}

	function goJoin(){
			location.href = "../jsp/join/member.jsp";
	}
	* */
