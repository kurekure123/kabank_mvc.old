/**
 * 
 */
function init() {
	document.querySelector('#member_register_btn').addEventListener("click", memberRegister, false);
	
}

function memberRegister() {
	alert("클릭");
	location.href = "member_register_form.jsp"
}

window.addEventListener('load', init, false);