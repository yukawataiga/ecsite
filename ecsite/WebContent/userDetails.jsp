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
		#text-right {
			display: inline-block;
			text-align: right;
		}
	</style>

	<script type="text/javascript">
		function submitAction(url){
			$('form').attr('action',url);
			$('form').submit();
		}

	</script>
	<title>UserDetails画面</title>
</head>

<body>

<div id="header">
	<div id="pr"></div>
</div>

<div id="main">
	<div id="top">
		<p>UserDetails</p>
  	</div>

	<div>
			<h3>ユーザー情報は以下になります。</h3>
			<table border="1">
				<tr>
				    <th>ID</th>
				    <td><s:property value="userInfo.id"/></td>
				</tr>
				<tr>
				    <th>ユーザーID</th>
				    <td><s:property value="userInfo.login_id"/></td>
				</tr>
				<tr>
				    <th>ユーザーPASS</th>
				    <td><s:property value="userInfo.login_pass"/></td>
				</tr>
				<tr>
				    <th>ユーザーネーム</th>
				    <td><s:property value="userInfo.user_name"/></td>
				</tr>
				<tr>
				    <th>挿入日</th>
				    <td><s:property value="userInfo.insert_date"/></td>
				</tr>
			</table>
			<s:form action="UserDeleteConfirmAction">
				<s:submit value="削除する"/>
			</s:form>
  	</div>

  	<div id="text-right">
  		<p>
  			前の画面に戻る場合には
  			<a href='<s:url action="UserListAction"/>'>こちら</a>
  		</p>
  	</div>
</div>

<div id="footer">
  	<div id="pr"></div>
</div>
</body>

</html>