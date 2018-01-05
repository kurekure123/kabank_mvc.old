/**
 * 
 */

function init(){
	var arr=['burgerking', 'kakao', 'bitcamp', 'sktelecom', 'lotto'];
	for(var i = 0; i<arr.length; i++){
		document.querySelector('#' + arr[i]).addEventListener('click', 
			function(e){
			location.href = "../"+this.id+"/main.jsp";
		}, false);
	}
}
function order() {
	document.querySelector('#order_form').submit();
}
window.addEventListener("load", init,false);


/* window.onload = function execute(){
	var arr=['burgerking', 'kakao', 'bitcamp', 'sktelecom', 'lotto'];
	for(var i = 0; i<arr.length; i++){
		document.querySelector('#' + arr[i]).addEventListener('click', 
			function(e){
			location.href = "../"+this.id+"/main.jsp";
		}, false);
	}
	document.querySelector('#burgerking_order_btn').addEventListener('click',
		function(e) {
			document.querySelector('#order_form').submit();
			}, false);
	}
**/


	// on 에 해당하는게 addEventListener 임


