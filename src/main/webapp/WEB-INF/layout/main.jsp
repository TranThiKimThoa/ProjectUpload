<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
	    <tiles:insertAttribute name="body" />
		<tiles:insertAttribute name="footer" />
    </div>
	
</body>
</html>