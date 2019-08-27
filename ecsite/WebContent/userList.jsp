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
	function submitAction(url) {
		$('form').attr('action', url);
		$('form').submit();
	}
</script>
<title>UserList画面</title>
</head>

<body>

	<div id="header">
		<div id="pr"></div>
	</div>

	<div id="main">
		<div id="top">
			<p>UserList</p>
		</div>

		<div>
			<h3>ユーザー情報は以下になります。</h3>
						<s:form action="UserListDeleteConfirmAction">
			<table border="1">
				<tr>
					<th>ID</th>
					<th>管理者権限</th>
					<th>ユーザーID</th>
					<th>ユーザーパスワード</th>
					<th>ユーザーネーム</th>
					<th>作成日</th>
					<th></th>
				</tr>
				<s:iterator value="userList">
					<tr>
						<td><s:property value="Id" /></td>
						<td><s:property value="admin_flg" /></td>
						<td><s:property value="login_id" /></td>
						<td><s:property value="login_pass" /></td>
						<td><s:property value="user_name" /></td>
						<td><s:property value="insert_date" /></td>
						<td>
					<a href='<s:url action="UserDetailsAction"><s:param name="Id" value="%{Id}" /></s:url>'>詳細</a>
						</td>
					</tr>
				</s:iterator>
			</table>
			</s:form>
		</div>

		<div id="text-right">
			<p>
				管理者画面に戻る場合には <a href='<s:url action="AdminAction"/>'>こちら</a>
			</p>
		</div>
	</div>

	<div id="footer">
		<div id="pr"></div>
	</div>
</body>

</html>