<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>


<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
 	<meta http-equiv="content-Style-type" content="text/css"/>
 	<meta http-equiv="content-script-type" content="text/javascript"/>
 	<meta http-equiv="imagetoolbar" content="no"/>
 	<meta name="description" content=""/>
 	<meta name="keywords" content=""/>
 	<script src ="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

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
	#text-link {
	display: inline-block;
	text-align: right;
	}
	</style>

	<script type ="text/javascript">
		function submitAction(url) {
			$('form').attr('action',url);
			$('form').submit();
		}

	</script>
	<title>BuyItemConfirm画面</title>
</head>

<body>

<div id="header">
	<div id="pr"></div>
</div>

<div id="main">
	<div id="top">
		<p>BuyItem</p>
  	</div>

	<div>
		<s:form>
			<tr>
				<td>商品名</td>
				<td><s:property value="#session.dtoConfirm.itemName"/></td>
			</tr>
			<tr>
				<td>値段</td>
				<td>
					<s:property value="#session.dtoConfirm.itemPrice"/>
					<span>円</span>
				</td>
			</tr>
			<tr>
				<td>購入個数</td>
				<td>
					<s:property value="session.count"/>
					<span>個</span>
				</td>
			</tr>
			<tr>
				<td>支払い方法</td>
				<td><s:property value="session.pay"/></td>
			</tr>
			<tr>
				<td><br></td>
			</tr>
			<tr>
				<td>
					<input type="button" value="戻る" onclick="submitAction('HomeAction')"/>
				</td>
				<td>
					<input type="button" value="完了" onclick="submitAction('BuyItemConfirmAction')"/>
				</td>
			</tr>
		</s:form>
  	</div>

  	<div>
  		<p>
  			前の画面に戻る場合には
  			<a href='<s:url action="GoHomeAction"/>'>こちら</a>
  		</p>
  		<p>
  			マイページは
  			<a href='<s:url action="MyPageAction"/>'>こちら</a>
  		</p>
  	</div>
</div>

<div id="footer">
  	<div id="pr"></div>
</div>
</body>

</html>