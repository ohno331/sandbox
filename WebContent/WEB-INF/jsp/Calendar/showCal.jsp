<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*,jp.ac.o_hara.site.calendar.*"%>
<%! Calendar c = Calendar.getInstance(); %>
<jsp:useBean id="user" scope="session"
	class="jp.ac.o_hara.site.user.UserBean" />
<%
	if (request.getAttribute("cdate") != null) {
		c = (Calendar) (request.getAttribute("cdate"));
	}
%>
<caption>
	<a href="javascript:showCal(<%= c.get(Calendar.YEAR) %>,<%= c.get(Calendar.MONTH) %>)">&laquo;</a>
	<%=c.get(Calendar.YEAR)%>年<%=c.get(Calendar.MONTH) + 1%>月
	<a href="javascript:showCal(<%= c.get(Calendar.YEAR) %>,<%= c.get(Calendar.MONTH)+2 %>)">&raquo;</a>
</caption>
<tr>
	<th>日</th>
	<th>月</th>
	<th>火</th>
	<th>水</th>
	<th>木</th>
	<th>金</th>
	<th>土</th>
</tr>
<%
	int nStartDay = c.get(Calendar.DAY_OF_WEEK), nEndDate = c
			.getActualMaximum(Calendar.DATE);
%>
<tr>
	<%
		Date start = c.getTime();
		c.set(Calendar.DAY_OF_MONTH, nEndDate);
		Date end = c.getTime();
		ArrayList<CalendarEntry> list = CalendarBean.getAllEntries(user.getUserId(), start, end);
		int count = 1;
		for (int i = 1; i < nStartDay; i++) {
			out.print("<td></td>");
			count++;
		}
		for (int i = 1; i <= nEndDate; i++) {
			if (list.size() > 0) out.print(list.get(i - 1).getFormat(i));
			//out.print("<td>"+i+"</td>");
			if (count % 7 + 1 == Calendar.SUNDAY)
				out.print("</tr>");
			count++;
			if (count % 7 == Calendar.SUNDAY)
				out.print("<tr>");
		}
		while (count++ % 7 != Calendar.SUNDAY)
			out.print("<td></td>");
	%>
</tr>