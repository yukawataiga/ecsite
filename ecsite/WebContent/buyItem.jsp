<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta http-equiv="content-Style-type" content="text/css" />
<meta http-equiv="content-script-type" content="text/javascript" />
<meta http-equiv="imagetoolbar" content="no" />
<meta name="description" content="" />
<meta name="keywords" content="" />

<style type="text/css">
body {
	margin: 0;
	padding: 0;
	line-height: 1.6;
	letter-spacing: 1px;
	font-family: Verdana, Helvetica, sans-serif;
	font-size: 12px;
	color: #333;
	background: #fff;
}

table {
	text-align: center;
	margin: 0 auto;
}

#top {
	width: 780px;
	margin: 30px auto;
	border: solid #333;
}

#header {
	width: 100%;
	height: 80px;
	background-color: black;
}

#main {
	width: 100%;
	height: 500px;
	text-align: center;
}

#footer {
	width: 100%;
	height: 80px;
	background-color: black;
	clear: both;
}

#text-center {
	display: inline-block;
	text-align: center;
}

#box {
	display: inline-block;
	text-align: center;
	border: solid #333;
}

select {
	font-size: 2em;
}
</style>
<script type="text/javascript">
	function changePrice() {
		const
		obj = document.getElementById("item_name");
		const
		price = document.getElementById("item_price");
		let
		index = obj.selectedIndex - 1;
		alert(index);

		if (index == 0) {
			price.innerHTML = '<s:property value="#session.dto[0].itemPrice" />円';
		}
		if (index == 1) {
			price.innerHTML = '<b><s:property value="#session.dto[1].itemPrice" /></b>円';
		}

	}
</script>
<title>buyItem画面</title>
</head>

<body>

	<div id="header">
		<div id="pr"></div>
	</div>

	<div id="main">
		<div id="top">
			<p>buyItem画面</p>
		</div>
		<div>
			<s:if test="errorMessage != null">
				<s:property value="errorMessage" />
			</s:if>
			<s:form action="BuyItemAction" name="buy_item">
				<tr>
					<td><span>商品名</span></td>
					<td><select name="id" id="item_name" onchange="changePrice()">
							<option value="" disabled selected style="display :none;">選択してください</option>
							<s:iterator value="#session.dto">
								<option value='<s:property value="id"/>'><s:property
										value="itemName" /></option>
							</s:iterator>
					</select></td>
				</tr>
				<tr>
					<td><span>値段</span></td>
					<td id="item_price"></td>
				</tr>
				<tr>
					<td><span>購入個数</span></td>
					<td><select name="count" id="">
							<option value="1" selected>1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
					</select></td>
				</tr>
				<tr>
					<td><span>支払い方法</span></td>
					<td><input type="radio" name="pay" value="1" checked>現金
						<input type="radio" name="pay" value="2">クレジッド</td>
				</tr>
				<tr>
					<td><s:submit value="購入" /></td>
				</tr>
			</s:form>
			<div>
				<span>前画面に戻る場合は</span> <a href='<s:url action="GoHomeAction"/>'>こちら</a>
				<p>
					マイページは<a href='<s:url action="MyPageAction"/>'>こちら</a>
				</p>
			</div>
		</div>
	</div>

	<div id="footer">
		<div id="pr"></div>
	</div>
</body>

</html>