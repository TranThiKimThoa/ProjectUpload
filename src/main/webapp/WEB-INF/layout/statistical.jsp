<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="context" value="${pageContext.request.contextPath}" />

<div class="container fix-size">
	<div class="row" style="min-height: 70vh;">
		<div class="col-md-10 offset-1">
			<div class="m-section">
				<div class="m-section__content">
				
				   <h3 class="te-center h-font">Thông tin học viên</h3>
					<table class="table table-bordered m-table m-table--border-success te-center">
						<thead>
							<tr>
								<th>ID</th>
								<th>Name</th>
								<th>Phone</th>
								<th>Email</th>
								<th>Date Register</th>
								<th>Course</th>
							</tr>
						</thead>
						<tbody id="myTable">
							<c:forEach var="list" items="${list}" varStatus="status">
								<tr>
									<td scope="row">${list.idname}</td>
									<td>${list.name}</td>
									<td>${list.phone}</td>
									<td>${list.email}</td>
									<td>${list.dateregister}</td>
<!-- 									<td> -->
<%-- 									  <c:forEach var="course" items="${list.courses}"> --%>
<%-- 									    <span>${course.nameCourse}</span> --%>
<%-- 									  </c:forEach> --%>
<!-- 									</td> -->
<!-- 									<td> -->
<%-- 									    <c:choose> --%>
<%-- 									       <c:when test="${list.status==0}">								         --%>
<!-- 									         <div> -->
<%-- 									           <i><img class="icon-image" alt="Lock" src="${pageContext.request.contextPath}/resources/dist/images/delete.png"></i> --%>
<!-- 									        </div> -->
<%-- 									        </c:when> --%>
<%-- 									        <c:otherwise> --%>
<!-- 									          <div> -->
<%-- 									           <i><img class="icon-image" alt="Active" src="${pageContext.request.contextPath}/resources/dist/images/ok.png"></i> --%>
<!-- 									          </div> -->
<%-- 									        </c:otherwise> --%>
<%-- 									     </c:choose> --%>
<!-- 									 </td>		   -->
							</c:forEach>
						</tbody>
					</table>
				
				</div>
			</div>
		</div>
	</div>
</div>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
		    
		  <form id="uform">
		
			<div class="modal-header">
				<h4 class="modal-title" id="exampleModalLabel">Register User</h4>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
				  <span aria-hidden="true">×</span>
				</button>
			</div>
		    <div class="modal-body">
				
                   <div class="form-group">
                      <label for="exampleInputEmail1">Username</label>
                      <input type="text" class="form-control" id="user" placeholder="Username">
                   </div>
                   <div class="form-group">
                       <label for="exampleInputPassword1">Password</label>
                       <input type="password" class="form-control" id="password" placeholder="Password">
                    </div>
                  
			</div>
			
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				<button type="submit" class="btn btn-primary">Save</button>
			</div>
			
		 </form>
									
		</div>
	</div>
</div>

<script>

  $(document).ready(function(){
	 
	   var idguest;
	   var y;
	   var status = 0;
	   $('.icon-image').click(function(){
		   if($(this).attr('alt')=='Active'){
			   alert('Khach hang da dang ki');
		   }
		   else {
			   status=1;
			   idguest = $(this).closest('tr').find('td:nth-child(1)').text();
			   y = $(this);
			   $('#myModal').modal({
				   backdrop:false,
				   show:true
			   });
		   }
// 		   var x = $(this).closest('div').find('img').attr('alt');
// 		   var y = $(this);
// 		   var status = 0;
// 		   if(x!='Lock'){
// 		   } else {
// 			   status = 1;
// 		   }
// 		   var id = $(this).closest('tr').find('td:nth-child(1)').text();
// 		   $.ajax({
// 			   method:'GET',
// 			   url:'editStatistical',
// 			   data: {
// 				   'status':status,
// 				   'id':id
// 			   },
// 			   success:function(data, statusText, xhr){
// 				   if(xhr.status==200){
// 					   if(data==1){
// 						   alert("Kich hoat thanh cong");
// 						   y.attr('src','${pageContext.request.contextPath}/resources/dist/images/ok.png');
// 						   y.attr('alt','Active');
// 					   } else {
// 						   alert("Huy thanh cong");
// 						   y.attr('src','${pageContext.request.contextPath}/resources/dist/images/delete.png');
// 						   y.attr('alt','Lock');
// 					   }
// 				   }
// 			   },
// 			   error:function(xhr, ajaxOptions, thrownError){
// 				   if(xhr.status==404) {
// 				        alert(thrownError);
// 				    }
// 			   }
// 		   });
		   
	   });
	   
	   $('#uform').submit(function(e){
		   e.preventDefault();
		   var user = $('#user').val();
		   var password = $('#password').val();
		   $.ajax({
			   method:'GET',
			   url:'statusGuest',
			   data:{
				   'idguest':idguest,
				   'user':user,
				   'password':password,
				   'status':status
			   },
			   success:function(data, statusText, xhr){
				   if(data==1){
					   alert('Dang ki thanh cong');
					   $('#uform').trigger("reset");
			           $('#myModal').modal('hide');
					   y.attr('src','${pageContext.request.contextPath}/resources/dist/images/ok.png');
					   y.attr('alt','Active');
				   }
			   },
			   error:function(xhr, ajaxOptions, thrownError){
				   if(xhr.status==500){
					   alert('That bai');
				   }
			   }
		   });
	   });
	
});
</script>