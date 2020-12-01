<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="module" tagdir="/WEB-INF/tags" %>
<jsp:useBean id="content" class="jp.ac.o_hara.site.ContentBean" scope="request" />
<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Bootstrap Sample</title>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/jquery-ui.min.css">
	<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="js/jquery-ui.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript">
	$(function() {
		$("strong").css("color", "red");
	});
	</script>
</head>
<body>
<div class="container">
	<header class="well">
		<h1>大原簿記法律専門学校柏校</h1>
		<h2>システム開発コース</h2>
	</header>
	<div class="row">
		<div class="col-sm-3">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title"><span class="glyphicon glyphicon-cutlery"></span>&nbsp;メニュー</h3>
				</div>
				<ul class="nav nav-pills nav-stacked">
					<li><a href="${ pageContext.request.contextPath }/blog">ブログ</a></li>
					<li><a href="${ pageContext.request.contextPath }/dummy">ダミー</a></li>
				</ul>
			</div>
			<module:User />
		</div>
		<div class="col-sm-9">
			<jsp:include page="${ content.getContent() }" />
			
		</div>
	</div>
	<footer class="well">
		copyright&copy; 大原簿記法律専門学校柏校
	</footer>
</div>

</body>
</html>