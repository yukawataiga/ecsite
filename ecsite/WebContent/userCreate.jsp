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
	<title>UserCreate画面</title>
</head>

<body>

<div id="header">
	<div id="pr"></div>
</div>

<div id="main">
	<div id="top">
		<p>UserCreate</p>
  	</div>

	<div>
		<s:if test="errorMessage !=''">
			<s:property value="errorMessage" escape="false"/>
		</s:if>
		<table>
			<s:form action="UserCreateConfirmAction">
				<tr>
					<td><label for="">ログインID:</label></td>
					<td><input type="text" name="loginUserId" value=""/></td>
				</tr>
				<tr>
					<td><label for="">ログインPASS:</label></td>
					<td><input type="text" name="loginPassword" value=""/></td>
				</tr>
				<tr>
					<td><label for="">ユーザー名:</label></td>
					<td><input type="text" name="userName" value=""/></td>
				</tr>
				<s:submit value="登録"/>
			</s:form>
		</table>
  	</div>

  	<div>
  		<s:if test="#session.admin != null">
  		<p>前の画面に戻る場合は<a href='<s:url action="AdminAction"/>'>こちら</a></p>
  		</s:if>
  		<s:if test="#session.admin == null">
  		<p>前の画面に戻る場合は<a href='<s:url action="HomeAction"/>'>こちら</a></p>
  		</s:if>
  	</div>
</div>

<div id="footer">
  	<div id="pr"></div>
</div>
</body>

</html>