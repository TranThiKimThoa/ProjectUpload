<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<title><tiles:getAsString name="title" /></title>
<tiles:insertAttribute name="javascripts" />
<tiles:insertAttribute name="stylesheets" />
</head>
 
<body class="m-page--fluid m-page--loading-enabled m-page--loading m-header--fixed m-header--fixed-mobile m-footer--push m-aside--offcanvas-default">
    <div class="m-page-loader m-page-loader--base">
      <div class="m-blockui">
        <span>
          Please wait...
        </span>
        <span>
          <div class="m-loader m-loader--brand"></div>
        </span>
      </div>
    </div>
    <div class="m-grid m-grid--hor m-grid--root m-page">
      <tiles:insertAttribute name="header" />
      <div class="m-grid__item m-grid__item--fluid  m-grid m-grid--ver-desktop m-grid--desktop 	m-container m-container--responsive m-container--xxl m-page__container m-body">
        <tiles:insertAttribute name="menu" />
        <tiles:insertAttribute name="body" />
      </div>
	  <tiles:insertAttribute name="footer" />
    </div>
    
</body>
</html>