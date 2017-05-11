<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<body>
	<h2>用户注册</h2>
	
	<form action="doregister" method="post">
		<table>
			<tr>
				<td>注册邮箱：</td>
				<td><input type="text" name="userCode"></td>
			</tr>
			<tr>
				<td>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
				<td><input type="password" name="userPassword"></td>
			</tr>
			<tr>
				<td>重复密码：</td>
				<td><input type="password" name="userPassword2"></td>
			</tr>
			<tr>
				<td>
				<input type="hidden" name="role" value="2">
				<input type="hidden" name="flatId" value="1">
				<input type="reset" value="重置" ></td>
				<td><input type="submit" value="注册" ></td>
			</tr>
			
		</table>
	
	</form>

	<div>
		<span> <a href="login">登录</a> </span> <span><a href="register">注册</a>
		</span>
	</div>
</body>
</html>
