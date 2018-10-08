<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.lang.Integer"%>
<%@page import="java.io.*,java.util.*"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />

     
<div class="form-group" style="margin-top: 100px;">
	<c:forEach var="n" items="${nameCourse}">
		<div class="form-group col-md-10" style="margin: 10px auto;">
			<div class="m-portlet m-portlet--mobile">
				<div class="m-portlet__head" style="background: #4675b8;color: #fff!important;">
					<div class="m-portlet__head-caption">
						<div class="m-portlet__head-title">
							<h3 class="m-portlet__head-text" style="color: #fff!important;">${n.nameCourse}</h3>
						</div>
					</div>
				</div>


				<div class="m-portlet__body">
					<div class="w-100 form-group"
						style="margin: 0 auto;">
						<div class="m-section">
							<div class="m-section__content">
								<table
									class="table table-bordered m-table m-table--border-success">
									<thead>
										<tr style="text-align: center;background: #34bfa3;color: #fff;">
											<th>STT</th>
											<th>Tên học viên</th>
											<th>Số bài tập đã nộp</th>
											<th>Lần nộp gần nhất</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="k" items="${nameUser}">


											<c:if test="${k.c.id==n.id}">

												<tr style="text-align: center">
													<td>${k.u.userId}</td>
													<td>${k.u.full_Name}</td>
													<c:forEach var="abc" items="${hmNumberExercise[k.id]}">
														
														<td>
														<a href="${pageContext.request.contextPath}/teacher/displays?iduser=${k.u.userId}&id=${n.id}">${abc}</a>
														</td>
														
													</c:forEach>

													<c:forEach var="date" items="${dateExercise[k.id]}">
														<td>${date}</td>
													</c:forEach>

												</tr>

											</c:if>


										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>

	</c:forEach>

</div>
