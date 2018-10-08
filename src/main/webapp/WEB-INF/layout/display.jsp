<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />

<div class="col-md-9 form-group" style="margin-top: 15px;">


	<c:forEach var="l" items="${lists}">

		<div class="m-portlet m-portlet--mobile">
			<div class="m-portlet__head" style="background: #4675b8;height: 3.1rem;">
				<div class="m-portlet__head-caption">
					<div class="m-portlet__head-title">
						<h3 class="m-portlet__head-text" style="color: #fff!important;">
							${l.name} <small> </small>
						</h3>
					</div>
				</div>
			</div>
			<c:forEach var="k" items="${listEx}">
				
					<c:if test="${k.te.id==l.id}">
						<c:if
							test="${k.tailpath == 'image/jpeg' || k.tailpath == 'image/jpg' 
														 || k.tailpath == 'image/png' || k.tailpath == 'image/giff' || k.tailpath == 'image/psd' || k.tailpath == 'image/tiff'}">
							<div class="m-portlet__body">
							<a
								href="${pageContext.request.contextPath}/teacher/download/${k.id}"><img
								src="${pageContext.request.contextPath}/teacher/getImages/${k.id}"
								style="height: 100px; width: 150px"></a>
								</div>
						</c:if>

						<c:if test="${k.tailpath != 'image/jpeg'}">
						<div class="m-portlet__body">
							<a
								href="${pageContext.request.contextPath}/teacher/download/${k.id}"><img
								src="${pageContext.request.contextPath}/resources/dist/images/pdf.png"
								style="height: 100px; width: 150px"></a>
								</div>
						</c:if>
					</c:if>
				
			</c:forEach>



		</div>

	</c:forEach>
</div>



