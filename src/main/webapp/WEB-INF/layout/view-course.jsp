<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />

<div class="container" style="margin-top: 150px">
	<div class="row" style="min-height: 70vh;">
		<div class="col-md-10 offset-1">
			<div class="m-section">
				<div class="m-section__content">
				    <h3 class="te-center h-font">Thông tin lễ khai giảng khóa học</h3>
					<table class="table table-bordered m-table m-table--border-success">
						<thead>
							<tr>
								<th>STT</th>
								<th>Khóa học</th>
								<th>Mô tả</th>
								<th>Giá</th>
								<th>Ngày bắt đầu</th>
								<th>Ngày kết thúc</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody id="myTable">
							<c:forEach var="list" items="${list}" varStatus="status">
								<tr>
									<th scope="row">${status.index+1+(page-1)*2}</th>
									<td>${list.nameCourse}</td>
									<td>${list.description}</td>
									<td>${list.price}</td>
									<td>${list.startDate}</td>
									<td>${list.endDate}</td>
									<td><a class="btn btn-primary btn-sm" href="registration?id=${list.id}">Đăng kí</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<ul class="pagination offset-5">
			<c:if test="${page>1}">
				<li class="page-item"><a class="page-link"
					href="view-course?page=${page-1}">Previous</a></li>
			</c:if>
			<c:if test="${page==1||page==0}">
				<li class="page-item disabled"><a class="page-link" href="#">Previous</a></li>
			</c:if>
			<c:forEach var="i" begin="1" end="${numPage}">
				<c:if test="${i==page}">
					<li class="page-item disabled"><a class="page-link"
						href="view-course?page=${i}">${i}</a></li>
				</c:if>
				<c:if test="${i!=page}">
					<li class="page-item"><a class="page-link"
						href="view-course?page=${i}">${i}</a></li>
				</c:if>
			</c:forEach>
			<c:if test="${page<numPage}">
				<li class="page-item"><a class="page-link"
					href="view-course?page=${page+1}">Next</a></li>
			</c:if>
			<c:if test="${page==numPage}">
				<li class="page-item disabled"><a class="page-link" href="#">Next</a></li>
			</c:if>
		</ul>
	</div>
</div>
<script>
       var idCourse = '${idCourse}';
	   if(idCourse!=''){
		   swal({
			   position: 'top-end',
			   type: 'success',
			   title: 'Bạn đã đăng kí thành công',
			   html:'<h3 style="color:#2ECC40">Chúng tôi sẽ liên lạc với bạn sớm nhất có thể</h3>',
			   showConfirmButton: false,
			   timer:2500
			 });
	   }
  
</script>