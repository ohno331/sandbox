<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="jp.ac.o_hara.site.calendar.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="list" scope="request" class="java.util.ArrayList"/>
<%
	if(list.size()>0){
		CalendarBean first = (CalendarBean) list.get(0);
		Schedulable module = (Schedulable)Class.forName("jp.ac.o_hara.site."+first.getModuleName().toLowerCase()+"."+first.getModuleName()+"Bean").newInstance();
%>
<article class="panel panel-primary">
	<header class="panel-heading"><span class="glyphicon glyphicon-paperclip">&nbsp;</span><%=first.getModuleName() %>モジュール</header>
	<section class="panel-body">
	<%=module.preRenderSchedule() %>
	<%=module.renderSchedule(first) %>
<%
		for(int i=1; i<list.size(); i++){
			CalendarBean next = (CalendarBean) list.get(i);
			if(!next.getModuleName().equals(first.getModuleName())){
%>
	<%=module.postRenderSchedule() %>
	</section>
</article>
<article class="panel panel-primary">
	<header class="panel-heading"><span class="glyphicon glyphicon-paperclip">&nbsp;</span><%=next.getModuleName() %>モジュール</header>
	<section class="panel-body">
	<% module = (Schedulable)Class.forName("jp.tist.proc.module."+next.getModuleName().toLowerCase()+"."+next.getModuleName()+"Bean").newInstance(); %>
	<%=module.preRenderSchedule() %>
<%
			}
%>
			<%=module.renderSchedule(next) %>
<%
			first = next;
		}
%>
	<%=module.postRenderSchedule() %>
	</section>
</article>
<%
	}
%>
<article class="panel panel-primary">
	<header class="panel-heading"><span class="glyphicon glyphicon-paperclip">&nbsp;</span>エントリ一覧</header>
	<section class="panel-body">
	<table class="table table-bordered table-condensed">
		<tr><th>日時</th><th>ユーザー</th><th>モジュール</th></tr>
		<c:forEach var="bean" items="${ list }">
		<tr><td>${ bean.date }</td><td>${ bean.userID }</td><td>${ bean.moduleName }</td></tr>
		</c:forEach>	
	</table>				
	</section>
</article>