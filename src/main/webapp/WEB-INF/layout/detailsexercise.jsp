<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<c:set var="context" value="${pageContext.request.contextPath}" />
         
	<div class="col-md-9 form-group">

			
            <br>
				<div >
				<div class="m-portlet__body" >
				<!-- END: Left Aside -->
				<div class="m-section">
									<div class="m-section__content" >
										<table class="table m-table m-table--head-bg-brand" >
											<thead>
												<tr>
													<th>STT</th>
													<th>Bài tập</th>
													<th>Tiêu đề</th>
													<th>Mô tả</th>
													<th>Ngày nộp</th>
													<th>Nộp bài</th>
												</tr>
											</thead>
											<tbody>
												
												<c:forEach var="l" items="${list}">
												<tr>
													<td>${l.id}</td>
													<td>
														 <c:if test="${l.tailpath == 'image/jpeg' || l.tailpath == 'image/jpg' 
														 || l.tailpath == 'image/png' || l.tailpath == 'image/giff' || l.tailpath == 'image/psd' || l.tailpath == 'image/tiff'}">
														 	 <a href="${pageContext.request.contextPath}/user/download/${l.id}"><img src="${pageContext.request.contextPath}/user/getImages/${l.id}" style="height: 100px;width: 150px" ></a>
														</c:if>	
														
														<c:if test="${l.tailpath != 'image/jpeg'}">
														    <a href="${pageContext.request.contextPath}/user/download/${l.id}"><img src="${pageContext.request.contextPath}/resources/dist/images/pdf.png" style="height: 100px;width: 150px" ></a>
														</c:if>
														
													</td>
													<td>${l.title}</td>
													<td>${l.description}</td>
													<td>${l.datefilling}</td>
													<td>
														<form action="${pageContext.request.contextPath}/user/delete" method="post">
					
															<input type="text" class="form-control hidden" name="id" hidden value="${l.id}" /> 
															<input type="submit" class="form-control btn btn-info" value="Xóa" />
														</form>
													</td>
												</tr>
												</c:forEach>
												
											</tbody>
										</table>
									</div>
								</div>
				</div>
			</div>
			<div class="float-right">
				<button type="button" class="btn btn-info" style="background: #4675b8"
                 onclick="location.href = '${pageContext.request.contextPath}/user/upload'">Bấm vào đây để nộp bài tập</button>
			</div>
		</div>
	
		