<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<c:set var="context" value="${pageContext.request.contextPath}" />

<div id="m_aside_left" class="col-md-3">
					<!-- BEGIN: Aside Menu -->
					<div id="m_ver_menu" class="m-aside-menu  m-aside-menu--skin-light m-aside-menu--submenu-skin-light " data-menu-vertical="true" data-menu-scrollable="false" >
						<ul class="m-menu__nav  m-menu__nav--dropdown-submenu-arrow ">
							<li class="m-menu__section">
								<h4>
									<a href="${pageContext.request.contextPath}/user/">${name}</a>
								</h4>
								<i class="m-menu__section-icon flaticon-more-v3"></i>
							</li>
							
						</ul>
					</div>
					
					<div id="m_ver_menu" class="m-aside-menu  m-aside-menu--skin-light m-aside-menu--submenu-skin-light " data-menu-vertical="true" data-menu-scrollable="false" >
					<ul class="m-menu__nav  m-menu__nav--dropdown-submenu-arrow ">
					<button type="button" class="btn btn-info m-btn--wide" style="background: #4675b8; width: 150px;"
					onclick="location.href = 'admin-page'"> 
						Danh sách đăng kí
					</button>
					</ul>
					</div>
					
					<div id="m_ver_menu" class="m-aside-menu  m-aside-menu--skin-light m-aside-menu--submenu-skin-light " data-menu-vertical="true" data-menu-scrollable="false" >
					<ul class="m-menu__nav  m-menu__nav--dropdown-submenu-arrow ">
					<button type="button" class="btn btn-info m-btn--wide" style="background: #4675b8; width: 150px;"
					onclick="location.href = 'create-user'"> 
						Tạo mới tài khoản
					</button>
					</ul>
					</div>
					
					<div id="m_ver_menu" class="m-aside-menu  m-aside-menu--skin-light m-aside-menu--submenu-skin-light " data-menu-vertical="true" data-menu-scrollable="false" >
					<ul class="m-menu__nav  m-menu__nav--dropdown-submenu-arrow ">
					<button type="button" class="btn btn-info m-btn--wide" style="background: #4675b8; width: 150px;"
					onclick="location.href = 'lockup'"> 
						Danh sách tài khoản
					</button>
					</ul>
					</div>
					
					
				</div>