<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<c:set var="context" value="${pageContext.request.contextPath}" />

     <header class="m-grid__item   m-header " data-minimize="minimize" data-minimize-mobile="minimize" data-minimize-offset="10" data-minimize-mobile-offset="10">
        <div class="m-header__top">
          <div class="m-container m-container--fluid m-container--full-height m-page__container">
            <div class="m-stack m-stack--ver m-stack--desktop">
              <!-- begin::Brand -->
              <div class="m-stack__item m-brand m-stack__item--left">
                <div class="m-stack m-stack--ver m-stack--general m-stack--inline">
                  <div class="m-stack__item m-stack__item--middle m-brand__logo">
                    <a href="${context}/home" class="m-brand__logo-wrapper">
                      <img alt="" src="${context}/resources/dist/images/logo.png" class="m-brand__logo-desktop" width="45%">
                      <img alt="" src="${context}/resources/dist/images/logo.png" class="m-brand__logo-mobile" width="80px">
                    </a>
                  </div>
                  <div class="m-stack__item m-stack__item--middle m-brand__tools">

                    <!-- begin::Responsive Header Menu Toggler-->
                    <a id="m_aside_header_menu_mobile_toggle" href="javascript:;" class="m-brand__icon m-brand__toggler m--visible-tablet-and-mobile-inline-block">
                      <span></span>
                    </a>
                    <!-- end::Responsive Header Menu Toggler-->
                  </div>
                </div>
              </div>
              <!-- end::Brand -->
              <!-- begin::Topbar -->
              <div class="m-stack__item m-stack__item--right m-header-head" id="m_header_nav">
                <div class="custom__m-header__bottom">
                  <div class="container" style="padding:0">
                    <div class="m-stack m-stack--ver m-stack--desktop">
                      <!-- begin::Horizontal Menu -->
                      <div class="m-stack__item m-stack__item--middle m-stack__item--fluid">
                        <button class="m-aside-header-menu-mobile-close  m-aside-header-menu-mobile-close--skin-light " id="m_aside_header_menu_mobile_close_btn">
                          <i class="la la-close"></i>
                        </button>
                        <div id="m_header_menu" class="pull-right m-header-menu m-aside-header-menu-mobile m-aside-header-menu-mobile--offcanvas  m-header-menu--skin-dark m-header-menu--submenu-skin-light m-aside-header-menu-mobile--skin-light m-aside-header-menu-mobile--submenu-skin-light ">
                          <ul class="m-menu__nav  m-menu__nav--submenu-arrow ">
                            <li class="m-menu__item  m-menu__item--active " aria-haspopup="true">
                              <a href="${pageContext.request.contextPath}/home" class="m-menu__link ">
                                <span class="m-menu__item-here"></span>
                                <span class="m-menu__link-text text-left">
                                  Trang chủ
                                </span>
                              </a>
                            </li>

                            <li class="m-menu__item " aria-haspopup="true">
                              <a href="${pageContext.request.contextPath}/partner" class="m-menu__link ">
                                <span class="m-menu__item-here"></span>
                                <span class="m-menu__link-text text-left">
                                  Đối tác và tuyển dụng
                                </span>
                              </a>
                            </li>

                            <li class="m-menu__item m-menu__item--submenu m-menu__item--rel m-menu__item--open" data-menu-submenu-toggle="hover" data-redirect="true" aria-haspopup="true" style="padding:0">
                              <span class="m-menu__link m-menu__link_custom">
          											<span class="m-menu__link-text">
          												<a href="programs" class="m-menu__link">Chương trình đào tạo</a>
          											</span>
                              <span href="#" class="m-menu__link m-menu__toggle">
            											<i class="m-menu__hor-arrow la la-angle-down"></i>
            											<i class="m-menu__ver-arrow la la-angle-right"></i>
            										</span>
                              </span>
                              <div class="m-menu__submenu  m-menu__submenu--fixed m-menu__submenu--left submenu-nav-custom">
                                <span class="m-menu__arrow m-menu__arrow--adjust"></span>
                                <div class="m-menu__subnav">
                                  <ul class="m-menu__content" style="display:grid;padding:10px 0">
                                    <li class="m-menu__item " data-redirect="true" aria-haspopup="true">
                                      <a href="${context}/pre-bridge" class="m-menu__link ">
                                        <i class="m-menu__link-icon flaticon-map"></i>
                                        <span class="m-menu__link-text text-left">
                                          Pre Bridge Engineer
                                        </span>
                                      </a>
                                    </li>
                                    <li class="m-menu__item " data-redirect="true" aria-haspopup="true">
                                      <a href="${context}/javafs" class="m-menu__link ">
                                        <i class="m-menu__link-icon flaticon-user"></i>
                                        <span class="m-menu__link-text text-left">
                                          Java full-stack
                                        </span>
                                      </a>
                                    </li>
                                    <li class="m-menu__item " data-redirect="true" aria-haspopup="true">
                                      <a href="${context}/program-net" class="m-menu__link ">
                                        <i class="m-menu__link-icon flaticon-clipboard"></i>
                                        <span class="m-menu__link-text text-left">
                                          .Net full-stack
                                        </span>
                                      </a>
                                    </li>
                                    <li class="m-menu__item " data-redirect="true" aria-haspopup="true">
                                      <a href="${context}/frontend-stack" class="m-menu__link ">
                                        <i class="m-menu__link-icon flaticon-graphic-1"></i>
                                        <span class="m-menu__link-text text-left">
                                          Front-end full-stack
                                        </span>
                                      </a>
                                    </li>
                                  </ul>
                                </div>
                              </div>
                            </li>
                            <li class="m-menu__item " aria-haspopup="true">
                              <a href="${context}/contact" class="m-menu__link ">
                                <span class="m-menu__item-here"></span>
                                <span class="m-menu__link-text text-left">
                                  Liên hệ
                                </span>
                              </a>
                            </li>
                          </ul>
                        </div>
                      </div>
                      <!-- end::Horizontal Menu -->
                    </div>
                  </div>
                </div>
              </div>
              <!-- end::Topbar -->
            </div>
          </div>
        </div>

      </header>