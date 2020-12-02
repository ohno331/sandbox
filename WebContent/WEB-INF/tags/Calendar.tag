<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<article id="calendar" class="panel panel-primary">
	<header class="panel-heading"><span class="glyphicon glyphicon-calendar">&nbsp;</span>カレンダー</header>
	<table style="font-size: 75%; text-align:center" class="table table-bordered table-condensed">

	</table>
</article>
<script type="text/javascript">
<!--
function showCal(year, month) {
	$.ajax({
		type: 'GET',
		url: '${ pageContext.request.contextPath }/showCal?year='+year+'&month='+month+'',
		dataType: 'html',
		success: function(data) {
			$('#calendar table').html(data);
		},
		error:function() {
			alert('問題がありました。');
		},
		cache: false
	});
}
$(function(){
	showCal(2020,12);
});
// -->
</script>