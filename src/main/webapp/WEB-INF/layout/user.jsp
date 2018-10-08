<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:set var="context" value="${pageContext.request.contextPath}" />

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:parseDate value="${c.startDate}" var="theDate" 
     pattern="yyyy-MM-dd HH:mm:ss'',S" />
<fmt:parseDate value="${c.endDate}" var="theDate" 
     pattern="yyyy-MM-dd HH:mm:ss'',S" />
     
<div class="col-md-8" >
<br>
	
	<div class="m-section">
		<div class="m-section__content">
			<table class="table table-bordered m-table m-table--border-success">
				<thead>
					<tr>
						<th>#</th>
						<th>Tên khóa học</th>
						<th>Giá tiền</th>
						<th>Ngày bắt đầu</th>
						<th>Ngày kết thúc</th>
						<th>Nộp bài</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="c" items="${course}">
						<tr>
							<th scope="row">${c.id}</th>
							<td>${c.nameCourse}</td>
							<td>${c.price}</td>
							<td>${c.startDate }</td>
							<td  pattern="yyyy-MM-dd HH:mm:ss">${c.endDate }</td>
							<td><a
								href="${pageContext.request.contextPath}/user/exercise/${c.id}">
									Xem chi tiết</a></td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
	</div>
</div>