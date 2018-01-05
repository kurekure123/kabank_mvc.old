/**
 * 
 */
function header() {
	location.href = "../../jsp/burgerking/main.jsp";
}

function burgerKing() {
document.querySelector('#header_burgerKing').onclick = header;	
}

window.onload = header;