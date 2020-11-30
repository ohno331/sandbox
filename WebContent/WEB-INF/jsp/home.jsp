<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="module" tagdir="/WEB-INF/tags" %>
<jsp:useBean id="content" class="jp.ac.o_hara.site.ContentBean" scope="request" />
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<module:User />
<jsp:include page="${ content.getContent() }" />
</body>
</html>