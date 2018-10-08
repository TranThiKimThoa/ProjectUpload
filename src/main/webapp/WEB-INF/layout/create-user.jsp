<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="context" value="${pageContext.request.contextPath}" />
    <div class="container" style="margin-top: 70px">
        <div class="row">
                    <div class="col-md-8 offset-1">
                        <div class="form-block">
                          <h3 class="te-center h-font">Tạo mới tài khoản</h3>
                          <div class="form">
                            <form id="form" action="createUser" method="Post">
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="Họ tên : *" name="full_Name">
                                </div>
                                <div class="form-group">
                                    <input id="username" type="text" class="form-control" placeholder="Tài khoản : *" name="userName">
                                </div>
                                <div class="form-group">
                                    <input type="password" class="form-control" placeholder="Mật khẩu : *" name="encrytedPassword">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="Thư điện tử : *" name="email">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="Số điện thoại : *" name="phone">
                                </div>
                                <div class="form-group">
                                    <select class="form-control" id="sel1" name="sel">
                                       <option selected="selected" value="0">Khóa học</option>
                                      <c:forEach var="list" items="${list}" varStatus="status">
                                         <option value="${status.index+1}">${list.nameCourse}</option>
                                      </c:forEach>
                                    </select>
                                </div>
                                <div id="bt" class="form-group" ng-app="myApp" ng-controller="myCol">
                                    <input type="text" class="form-control" placeholder="" name="dateRegister"
                                     value="{{theTime|date:'yyyy-MM-dd'}}" readonly="readonly">
                                </div>
                                <div class="row" style="margin-bottom: 20px;margin-top: 20px">
                                   <div class="col-md-6 offset-3">
                                      <button type="submit" class="btn btn-primary custom-btn btn-block">Tạo tài khoản</button>
                                   </div>
                                </div>
                            </form>
                          </div>
                        </div>
                    </div>
                </div>
    </div>
    <script type="text/javascript">
    var app = angular.module('myApp',[]);
    app.controller('myCol',function($scope,$interval){
    	$interval(function(){
            $scope.theTime = new Date();
    	},1000);
    });
    
    $(document).ready(function(){
    	$('#bt').hide();
//     	$.validator.addMethod("valueNotEquals",function(value,element,arg){
//     		if(element.value='default') return false;
//     		return true;
//     	},'Value must not equal arg');
    	$('#form').validate({
    		rules:{
    			full_Name:{
    				required:true
    			},
    			userName:{
    				required:true
    			},
    			encrytedPassword:{
    				required:true
    			},
    			email:{
    				required:true,
    				email:true
    			},
    			phone:{
    				required:true,
    				digits:true
    			},
    			sel:{
    				min:1
    			}
    		},
    		messages:{
    			full_Name:{
    				required:'<span style="color:red">Trường này không được để trống<span>'
    			},
    			userName:{
    				required:'<span style="color:red">Trường này không được để trống<span>'
    			},
    			encrytedPassword:{
    				required:'<span style="color:red">Trường này không được để trống<span>'
    			},
    			email:{
    				required:'<span style="color:red">Trường này không được để trống<span>',
    				email:'<span style="color:red">Email không đúng định dạng<span>'
    			},
    			phone:{
    				required:'<span style="color:red">Trường này không được để trống<span>',
    				digits:'<span style="color:red">Số điện thoại phải là số nguyên dương<span>'
    			},
    			sel:{
    				min:'<span style="color:red">Vui lòng chọn khóa học<span>'
    			}
    		},
    		submitHandler:function(form,event){
    			event.preventDefault();
    			$.ajax({
    				method:form.method,
    				url:form.action,
    				data:$(form).serialize(),
    				success:function(data,status){
    					if(data==true){
    						swal({
     						   position: 'top-end',
     						   type: 'success',
     						   title: 'Tạo tài khoản thành công',
     						   showConfirmButton: false,
     						   timer: 2500
     						 });
    					}
    					else{
    						swal({
    							  type: 'error',
    							  title: 'Username đã tồn tại'
    							});
    					}
    				},
    				error:function(xhr,ajaxOptions,thrownError){
    					if(xhr.status==500){
    						alert('That bai');
    					}
    				}
    			});
    		}
    	});
    	
    });
    </script>