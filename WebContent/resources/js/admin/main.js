/**
 * 
 */
function init() {
	document.querySelector('#create_table').addEventListener("click", createTable, false);
	
}


function createTable() {
	alert('테이블을 생성합니다.')
	location.href = "member_list.jsp"
}

window.addEventListener('load', init, false);