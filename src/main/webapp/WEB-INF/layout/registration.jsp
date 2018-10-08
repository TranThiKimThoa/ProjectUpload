<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="context" value="${pageContext.request.contextPath}" />

<div class="container fix-size">
	<div class="row">
		<div class="col-md-8 offset-2">

			<div class="m-portlet__head">
				<div class="m-portlet__head-caption">
					<div class="m-portlet__head-title">
						<span class="m-portlet__head-icon m--hide"> <i
							class="la la-gear"></i>
						</span>
						<h3 class="te-center h-font">Đăng kí thông tin</h3>
					</div>
				</div>
			</div>
			<!--begin::Form-->
			<form id="form" action="saveGuest" method="POST" commandName="guest"
				class="m-form m-form--fit m-form--label-align-right">
				<div class="m-portlet__body">
					<div class="form-group m-form__group">
						<label>Name :</label><span class="color-red">*</span> <input
							type="text" class="form-control m-input m-input--square"
							name="name" placeholder="Name">
					</div>
					<div class="form-group m-form__group">
						<label>Email :</label> <span class="color-red">*</span><input
							type="text" class="form-control m-input m-input--square"
							name="email" placeholder="Email">
					</div>
					<div class="form-group m-form__group">
						<label>Phone :</label> <span class="color-red">*</span> <input
							type="text" class="form-control m-input m-input--square"
							name="phone" placeholder="Phone">
					</div>	
					<div id="bt" class="form-group m-form__group" ng-app="myApp" ng-controller="myCol">
						<label>Date Register</label> <input
							type="text" class="form-control m-input m-input--square"
							name="dateregister" placeholder="" value="{{theTime|date:'yyyy-MM-dd'}}" readonly="readonly">
						<label>Phone</label> <input type="text"
							class="form-control m-input m-input--square" name="phone"
							placeholder="Phone">
					</div>
				</div>
				<div class="m-portlet__foot m-portlet__foot--fit">
					<div class="m-form__actions">
					  <div class="row">
					      <div class="col-md-6 offset-3"><button type="submit" class="btn btn-primary btn-block">Đăng kí</button></div>
					  </div>
						
						
					</div>
				</div>
			</form>
			<!--end::Form-->

		</div>
	</div>
</div>

<script>
	var app = angular.module('myApp', []);
	app.controller('myCol', function($scope, $interval) {
		$interval(function() {
			$scope.theTime = new Date();
		}, 1000);
	});

	$(document)
			.ready(
					function() {
						$('#form')
								.validate(
										{
											rules : {
												name : 'required',
												identifucard : {
													required : true,
													digits : true
												},
												phone : {
													required : true,
													digits : true
												},
												email : {
													required : true,
													email : true
												}
											},
											messages : {
												name : '<span class="m-form__help" style="color:red">Vui long nhap ten</span>',
												identifucard : {
													required : '<span class="m-form__help" style="color:red">Vui long nhap CMND</span>',
													digits : '<span class="m-form__help" style="color:red">CMND phai la so</span>'
												},
												phone : {
													required : '<span class="m-form__help" style="color:red">Vui long nhap so dien thoai</span>',
													digits : '<span class="m-form__help" style="color:red">So dien thoai phai la so duong</span>'
												},
												email : {
													required : '<span class="m-form__help" style="color:red">Vui long nhap mail</span>',
													email : '<span class="m-form__help" style="color:red">Email khong dung dinh dang</span>'
												}
											}
										});

						$('#bt').hide();
					});
</script>