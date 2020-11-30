<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="user" class="jp.ac.o_hara.site.user.UserBean" scope="session" />
<div class="panel panel-info">
	<div class="panel-heading">
		<h3 class="panel-title">
			<span class="glyphicon glyphicon-user"></span>&nbsp;ユーザー</h3>
	</div>
	<div class="panel-body">
		<form method="post" action="./user">
		<c:choose>
		<c:when test="${ user.isAuth() }">
			<p>ようこそ、${ user.getUserId() }さん</p>
			<input type="submit" class="btn btn-default" name="logout" value="ログアウト" />
		</c:when>
		<c:otherwise>
			<dl>
				<dt><label for="userId" class="control-label">ユーザーID：</label></dt>
				<dd><input type="text" class="form-control input-sm" name="userId" value="" /></dd>
				<dt><label for="userPass" class="control-label">パスワード：</label></dt>
				<dd><input type="password" class="form-control input-sm" name="userPass" value="" /></dd>
			</dl>
			<input type="submit" class="btn btn-default" name="login" value="ログイン" />
			<a class="btn btn-default" href="./user?register=true">新規登録</a>
		</c:otherwise>
		</c:choose>
		</form>
	</div>
</div>