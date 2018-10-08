<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/css/select2.min.css" rel="stylesheet" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/js/select2.min.js"></script>

<c:set var="context" value="${pageContext.request.contextPath}" />

<div class="container" style="margin-top: 70px">
	<div class="row" style="min-height: 70vh;">
		<div class="col-md-10 offset-1">
			<div class="m-section">
				<div class="m-section__content">
				   <h3 class="te-center h-font">Danh sách tài khoản</h3>
					<table class="table table-bordered m-table m-table--border-success te-center">
						<thead>
							<tr>
								<th>ID</th>
								<th>Tên</th>
								<th>Số điện thoại</th>
								<th>Thư điện tử</th>
								<th>Ngày đăng kí</th>
								<th>Kích hoạt</th>
							</tr>
						</thead>
						<tbody id="myTable">
							<c:forEach var="list" items="${list}" varStatus="status">
								<tr>
									<td scope="row">${list.userId}</td>
									<td>${list.userName}</td>
									<td>${list.phone}</td>
									<td>${list.email}</td>
									<td>${list.dateRegister}</td>
								
									<td>
									    <c:choose>
									       <c:when test="${list.enabled==false}">								        
									         <div>
									           <span class="label label-danger">Khóa</span>&nbsp;
									           
									             <i><img class="icon-image" alt="Lock" src="${pageContext.request.contextPath}/resources/dist/images/jail-lock.png"></i>
									           
									        </div>
									        </c:when>
									        <c:otherwise>
									          <div>
									           <span class="label label-success">Kích hoạt</span>&nbsp;
									          
									             <i><img class="icon-image" alt="Active" src="${pageContext.request.contextPath}/resources/dist/images/jail-unlock.png"></i>
									          
									          </div>
									        </c:otherwise>
									     </c:choose>
									 </td>		  
							</c:forEach>
						</tbody>
					</table>
				
				</div>
			</div>
		</div>
		
		<ul class="pagination offset-4">
			<c:if test="${page>1}">
				<li class="page-item"><a class="page-link"
					href="lockup?page=${page-1}">Previous</a></li>
			</c:if>
			<c:if test="${page==1||page==0}">
				<li class="page-item disabled"><a class="page-link" href="#">Previous</a></li>
			</c:if>
			<c:forEach var="i" begin="1" end="${numPage}">
				<c:if test="${i==page}">
					<li class="page-item disabled"><a class="page-link"
						href="lockup?page=${i}">${i}</a></li>
				</c:if>
				<c:if test="${i!=page}">
					<li class="page-item"><a class="page-link"
						href="lockup?page=${i}">${i}</a></li>
				</c:if>
			</c:forEach>
			<c:if test="${page<numPage}">
				<li class="page-item"><a class="page-link"
					href="lockup?page=${page+1}">Next</a></li>
			</c:if>
			<c:if test="${page==numPage}">
				<li class="page-item disabled"><a class="page-link" href="#">Next</a></li>
			</c:if>
		</ul>
		
	</div>
</div>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
		
		</div>
	</div>
</div>	

<script>
  $(function() {
	   $('.icon-image').click(function(){
		   var x = $(this).closest('div').find('span').text();
		   var y = $(this);
		   var enabled = false;
		   if(x!='Khóa'){
			   swal({
			        title: 'Bạn muốn khóa tài khoản này?',
			        type: 'warning',
			        showCancelButton: true,
			        confirmButtonColor: '#3085d6',
			        cancelButtonColor: '#d33',
			        confirmButtonText: 'Vâng',
			        cancelButtonText: 'Không',
			        confirmButtonClass: 'btn btn-success',
			        cancelButtonClass: 'btn btn-danger',
			        buttonsStyling: false
			    }).then(function () {
			 	   $.ajax({
					   method:'GET',
					   url:'editEnabled',
					   data: {
						   'enabled':enabled,
						   'id':id
					   },
					   success:function(data, statusText, xhr){
						   if(xhr.status==200){
								     y.attr('src','${pageContext.request.contextPath}/resources/dist/images/jail-lock.png');
								     y.attr('alt','Lock');
								     y.closest('div').find('span').text('Khóa');
								     y.closest('div').find('span').removeClass('label-success');
								     y.closest('div').find('span').addClass('label-danger');
						   } 
					   },
					   error:function(xhr, ajaxOptions, thrownError){
						   if(xhr.status==404) {
						        alert(thrownError);
						    }
					   }
				    });
			        swal(
			          'Đã khóa!',
			          'Tài khoản này đã bị khoá',
			          'success'
			        )
			    })      
		   } else {
			   enabled = true;
			   swal({
			        title: 'Bạn muốn kích hoạt tài khoản này?',
			        type: 'warning',
			        showCancelButton: true,
			        confirmButtonColor: '#3085d6',
			        cancelButtonColor: '#d33',
			        confirmButtonText: 'Vâng',
			        cancelButtonText: 'Không',
			        confirmButtonClass: 'btn btn-success',
			        cancelButtonClass: 'btn btn-danger',
			        buttonsStyling: false
			    }).then(function () {
			 	   $.ajax({
					   method:'GET',
					   url:'editEnabled',
					   data: {
						   'enabled':enabled,
						   'id':id
					   },
					   success:function(data, statusText, xhr){
						   if(xhr.status==200){
							y.attr('src','${pageContext.request.contextPath}/resources/dist/images/jail-unlock.png');
							y.attr('alt','Active');
							y.closest('div').find('span').text('Kích hoạt');
							y.closest('div').find('span').removeClass('label-danger');
							y.closest('div').find('span').addClass('label-success');
						   } 
					   },
					   error:function(xhr, ajaxOptions, thrownError){
						   if(xhr.status==404) {
						        alert(thrownError);
						    }
					   }
				    });
			        swal(
			          'Thành công!',
			          'Tài khoản đã kích hoạt thành công',
			          'success'
			        )
			    })      
		   }
		   var id = $(this).closest('tr').find('td:nth-child(1)').text();
	
		   
	   });
	
});
</script>