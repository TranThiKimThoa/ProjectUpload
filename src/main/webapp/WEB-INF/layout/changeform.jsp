<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<c:set var="context" value="${pageContext.request.contextPath}" />
<form:form id="idform" class="m-form m-form--fit m-form--label-align-right"
	action="${pageContext.request.contextPath}/user/editPassword" method="POST" modelAttribute="user">
	<br> <br>
	<div class="m-portlet__body">
		
		<input type="text" class="form-control" hidden
					name="userId" value="${user.userId}"/>
		<input type="text" class="form-control" 
					name="userName" value="${user.userName}"  hidden/>
		<input type="text" class="form-control" 
					name="phone" value="${user.phone}" hidden/>
		<input type="text" class="form-control" 
					name="email" value="${user.email}" hidden/>
		<input type="text" class="form-control" 
					name="dateRegister" value="${user.dateRegister}" hidden/>
		<input type="text" class="form-control" hidden
					name="enabled" value="${user.enabled}"/>
		<input type="text" class="form-control" hidden
					name="full_Name" value="${user.full_Name}"/>
		<c:if test="${message !=null}">
			<div class="row">
				<div class="col-sm-offset-2 col-sm-8">
					<div class="alert alert-danger">${message}</div>
				</div>
			</div>
		</c:if>			
					
		<div class="form-group m-form__group row">
			<label class="col-form-label col-lg-5 col-sm-12"> Nhập mật
				khẩu mới </label>
			<div class="col-lg-9 col-md-9 col-sm-12">
				<input type="password" class="form-control" id="password"
					name="encrytedPassword" value=""/>
			</div>
		</div>

		<div class="form-group m-form__group row">
			<label class="col-form-label col-lg-5 col-sm-12"> Nhập lại
				mật khẩu </label>
			<div class="col-lg-9 col-md-9 col-sm-12">
				<input type="password" class="form-control" id="confirm_password"
					name="confirm_password" value=""/>

			</div>
		</div>
	</div>
	<div class="m-portlet__foot m-portlet__foot--fit">
		<div class="m-form__actions m-form__actions">
			<div class="row">
				<div class="col-lg-9 ml-lg-auto">

					<input type="submit" value="Lưu mật khẩu" class="btn btn-brand">

				</div>
			</div>
		</div>
	</div>
</form:form>

<script>
	$(document).ready(function() {

		$("#idform").validate({
			rules : {
				password : {
					required : true,
					minlength : 5
				},
				confirm_password : {
					required : true,
					minlength : 5,
					equalTo : "#password"
				}
			},
			messages : {
				password : {
					required : '<span style="color:red">Vui lòng nhập mật khẩu</span>',
					minlength : 'Vui lòng nhập ít nhất 5 kí tự'
				},
				confirm_password : {
					required : 'Vui lòng nhập mật khẩu',
					minlength : 'Vui lòng nhập ít nhất 5 kí tự',
					equalTo : 'Mật khẩu không trùng'
				}
			}
		});
	});
</script>