<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:set var="context" value="${pageContext.request.contextPath}" />

<div id="m_aside_left" class="col-md-3">
	<!-- BEGIN: Aside Menu -->
	<div id="m_ver_menu"
		class="m-aside-menu  m-aside-menu--skin-light m-aside-menu--submenu-skin-light "
		data-menu-vertical="true" data-menu-scrollable="false">
		<ul class="m-menu__nav  m-menu__nav--dropdown-submenu-arrow ">

			<li class="m-menu__section">
				<h4 class="m-menu__section-text">
					<a href="#">${name}</a>
				</h4> <i class="m-menu__section-icon flaticon-more-v3"></i>
			</li>

			<c:forEach var="n" items="${nameCourse}">
				<li class="m-menu__section">
					<h4 class="m-menu__section-text">
						<a href="#">${n.nameCourse}</a>
					</h4> <i class="m-menu__section-icon flaticon-more-v3"></i>
				</li>

				<c:forEach var="k" items="${nameUser}">
					<c:if test="${k.c.id==n.id}">
						<li class="m-menu__item " aria-haspopup="true"
							data-redirect="true" style="margin-left: 20px;"><a
							href="${pageContext.request.contextPath}/teacher/displays?iduser=${k.u.userId}&id=${n.id}"
							class="m-menu__link "> <i
								class="m-menu__link-bullet m-menu__link-bullet--dot"> <span></span>
							</i> <span class="m-menu__link-text"> ${k.u.userName} </span>
						</a></li>
						
					</c:if>
				</c:forEach>
			</c:forEach>

		</ul>

		<button type="button" class="form-control btn btn-warning"
			onclick="location.href = '${pageContext.request.contextPath}/teacher/addExercise'"
			style="background: #5867dd; color: #fff; width: 210px; margin-left: 30px; margin-bottom: 50px;">Thêm
			bài tập</button>
	</div>


</div>