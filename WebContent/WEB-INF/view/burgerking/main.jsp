<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<%@ include file="../common/head.jsp" %>
<body>
<%@ include file ="../common/header.jsp" %>
<%@ include file="../common/nav.jsp" %>
<div id ="wrapper">
		<section>
		<article>
		<header id = "burger_head">
			<hgroup>
				<h1>버거킹 주문화면</h1>
				<h2>상품과 수량을 선택해주세요</h2>
			</hgroup>
		</header>
		<form id="order_form" action="result.jsp">
			<table id = "burger_table">
				<tr>
					<td id="burger_table_td">
						<figure>
							<img src="http://www.bk.com/sites/default/files/02200-1-BK_Web_WHOPPER_300x270px_CR.jpg" alt="" style="width : 200px;"> 
								<figcaption>
									<input type="checkbox" name="menu" value="hamburger" />	햄버거 : ￦5,500 
									<input type="number" name="hamburger-count" style = "width : 40px" min ="1" max = "10"/>개
								</figcaption>
						</figure>
					</td>
					<td>
						<figure>
							<img src="http://www.bk.com/sites/default/files/Menu_0003_Beverages_0.jpg" alt="" style="width : 200px;" > 
							<figcaption>	
								<input type="checkbox" name="menu" value="coke" /> 콜라 : ￦1,000 
								<input type="number" name="coke-count" style = "width : 40px" min ="1" max = "10"/>개
							</figcaption>
						</figure>
					</td>
					<td>
					<figure>
						<img src="http://www.bk.com/sites/default/files/Thumb_0005_Sides.jpg" alt="" style="width : 200px;"> 
						<figcaption>
							<input type="checkbox" name="menu" value="fries" /> 감자칩 : ￦1,000 
							<input type="number" name="fries-count" style = "width : 40px" min ="1" max = "10"/>개
						</figcaption>
					</figure>
					</td>
				</tr>
				<tr>
					<td>
					<figure>
						<figcaption>
					<img src="http://www.bk.com/sites/default/files/BK_Web_BKJOEHOTCOFFEE_300x270px%255b9%255d.jpg" alt="" style="width : 200px;">
							<input type="checkbox" name="menu" value="coffee" /> 커피 : ￦900  
							<input type="number" name="coffee-count" style = "width : 40px" min ="1" max = "10"/>개
						</figcaption>
					</figure>
					</td>
					<td>
						<figure>
						<img src="http://www.bk.com/sites/default/files/02001-2_BK_Web_ChickenGardenSalad_300x270px_0.jpg" alt="" style="width : 200px;">
							<figcaption>
								<input type="checkbox" name="menu" value="salad" /> 샐러드 : ￦3000
								<input type="number" name="salad-count" style = "width : 40px" min ="1" max = "10"/>개
							</figcaption>
						</figure>
					</td>
					<td>
					<figure>
						<img src="http://www.bk.com/sites/default/files/Thumb_Croissanwich_Ham_Egg_Cheese.jpg" alt="" style="width : 200px;" > 
							<figcaption>
								<input type="checkbox" name="menu" value="bagel" /> 베이글 : ￦4000
								<input type="number" name="bagel-count" style = "width : 40px" min ="1" max = "10"/>개
						</figcaption>
					</figure>
					</td>
				</tr>
				<tr>
				<td colspan ="3">
					<input type="radio" name="place" value="매장식사" checked = "checked"/> 매장식사
					<input type="radio" name="place" value="테킷아웃" /> 테이크 아웃
				</td>
				</tr>
				<tr >
				<td colspan="3">
					<input type="hidden" name="hamburger" value="5500" />
					<input type="hidden" name="coke" value="1000" />
					<input type="hidden" name="fries" value="1000" />
					<input type="hidden" name="coffee" value="900" />
					<input type="hidden" name="salad" value="3000" />
					<input type="hidden" name="bagel" value="4000" />
					<input id = "burgerking_order_btn" type="button" value="전송" style="width : 100px;"/>
				</td>
			</tr>
			</table>
		</form>
		</article>
	</section>
		</div>
	<%@ include file="../common/footer.jsp"  %>
</body>
<script src="../../js/burgerking/burgerking.js"></script>
</html>	