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
	<title>ItemCreateConfirm画面</title>
</head>

<body>

<div id="header">
	<div id="pr"></div>
</div>

<div id="main">
	<div id="top">
		<p>ItemCreateConfirm</p>
  	</div>

	<div>
		<h3>登録する内容は以下でよろしいですか？</h3>
		<table>
			<s:form action="ItemCreateCompleteAction">
				<tr id="box">
					<td><label for="">商品名:</label></td>
					<td><s:property value="item_name" escape="false"/></td>
				</tr>
				<tr id="box">
					<td><label for="">商品価格:</label></td>
					<td><s:property value="item_price" escape="false"/>円</td>
				</tr>
				<tr>
					<td><label for="">在庫:</label></td>
					<td><s:property value="item_stock" escape="false"/>個</td>
				</tr>
				<tr>
					<td><s:submit value="完了"/></td>
				</tr>
			</s:form>
		</table>
  	</div>

  	<div>
  		<span>前画面に戻る場合は</span>
  		<a href='<s:url action="ItemCreateAction"/>'>こちら</a>
  	</div>
</div>

<div id="footer">
  	<div id="pr"></div>
</div>
</body>

</html>