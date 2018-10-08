<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<div class="m-wizard__form col-md-8">
	<f:form id="idform"
		class="m-form m-form--label-align-left- m-form--state-"
		novalidate="novalidate"
		action="${pageContext.request.contextPath}/user/saveupload"
		method="POST" enctype="multipart/form-data" modelAttribute="ex">
		<!--begin: Form Body -->
		<div class="m-portlet__body">
			<!--begin: Form Wizard Step 1-->
			<div class="m-wizard__form-step m-wizard__form-step--current"
				id="m_wizard_form_step_1">
				<div class="row">
					<div class="col-xl-11 offset-xl-2">
						<div class="m-form__section m-form__section--first">
							<br>
							<div class="m-form__heading">
								<h3 class="m-form__heading-title" style="color: #4675b8;text-align: center;font-size: 30px;font-weight: bold;margin-bottom: 50px;">NƠI NỘP BÀI</h3>
							</div>
							<div class="form-group m-form__group row">
								<label class="col-xl-5 col-lg-3 col-form-label"
									style="color: #4675b8"> * Tiêu đề: </label>
								<div class="col-xl-7 col-lg-9">
									<input type="text" name="title" class="form-control m-input"
										placeholder="" aria-describedby="name-error"
										aria-invalid="false"> <span class="m-form__help"
										required id="title"> </span>
								</div>
							</div>
							<div class="form-group m-form__group row">
								<label class="col-xl-5 col-lg-3 col-form-label"
									style="color: #4675b8"> * Mô tả: </label>
								<div class="col-xl-7 col-lg-9">
									<input type="text" name="description"
										class="form-control m-input" placeholder=""
										aria-describedby="email-error" aria-invalid="false"> <span
										class="m-form__help" required id="description"> </span>
								</div>
							</div>

							<div class="form-group m-form__group row">
								<label class="col-xl-5 col-lg-3 col-form-label"
									style="color: #4675b8"> * Chọn bài tập </label>
								<div class="col-xl-7 col-lg-9">
									<select name="te.id">
									<c:forEach var="c" items="${listExercise}">
										<c:if test="${ex.te.id == c.id}">
											<option value="${c.id}" selected>${c.name}</option>
										</c:if>
										<c:if test="${ex.te.id != c.id}">
											<option value="${c.id}">${c.name}</option>
										</c:if>
									</c:forEach>
								</select>
								</div>
							</div>

							<div class="form-group m-form__group row">
								<label class="col-xl-5 col-lg-3 col-form-label"
									style="color: #4675b8"> * File </label>
								<div class="col-xl-7 col-lg-9">
									<div class="input-group">

										<input type="file" name="file" class="form-control m-input"
											placeholder="" aria-describedby="phone-error"
											aria-invalid="false" onchange="loadFile(event)">
									</div>
									<span class="m-form__help"> <img id="output"
										style="height: 100px; width: 150px" />
									</span>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
		<div class="m-portlet__foot m-portlet__foot--fit m--margin-top-40" style="margin-left: 240px;">
			<div class="m-form__actions m-form__actions">
				<div class="row">
					<div class="col-lg-2"></div>
					<div class="col-lg-4 m--align-left">
						<a href="${pageContext.request.contextPath}/user/"
							class="btn btn-secondary m-btn m-btn--custom m-btn--icon"
							data-wizard-action="prev">  Trở về </span>
						</span>
						</a>
					</div>
					<div class="col-lg-4 m--align-right">

						<input class="btn btn-secondary m-btn m-btn--custom m-btn--icon"
							type="submit" value="Lưu"/>
					</div>
					<div class="col-lg-2"></div>
				</div>
			</div>
		</div>
		<!--end: Form Actions -->
	</f:form>
</div>
<script>
	var loadFile = function(event) {
		var reader = new FileReader();
		reader.onload = function() {
			var output = document.getElementById('output');
			output.src = reader.result;
		};
		reader.readAsDataURL(event.target.files[0]);
	};
</script>

<script>
	$(document).ready(function() {

		$("#idform").validate({
			rules : {
				title : {
					required : true,
				},
				description : {
					required : true,
				}
			},
			messages : {
				title : {
					required : 'Vui lòng không bỏ trống trường này'

				},
				description : {
					required : 'Vui lòng không bỏ trống trường này'
				}
			}
		});
	});
</script>