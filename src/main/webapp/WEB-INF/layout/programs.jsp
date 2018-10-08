<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
      <c:set var="context" value="${pageContext.request.contextPath}" />
     <div class="fornt-end-body m-body">
        <div class="form-group m-page__container">
          <!-- <div class=" m-grid--desktop 	m-container m-container--responsive m-container--xxl m-page__container" >

            <h2 class="m--font-boldest  m--margin-top-50 form-group">
								Chương trình đào tạo
						</h2>
            <div class="line" style="background:#000;margin:20px 0 0 0"></div>
          </div> -->
          <div class="form-group m--margin-top-50 m-page__container" >
            <div class="form-group">
              <div style="display:inline-block;width:100%;overflow-y:auto;">
      					<ul class="timeline timeline-horizontal">
      						<li class="timeline-item">
      							<div class="timeline-badge primary"><i class="la la-check"></i></div>
      							<div class="timeline-panel" >
      								<div class="timeline-heading">
      									<h4 class="m--font-warning timeline-title">Học Viên</h4>

      								</div>
      								<div class="timeline-body">
      									<p><i class="flaticon-users" style="font-size:5rem"></i></p>
      								</div>
      							</div>
      						</li>
      						<li class="timeline-item">
      							<div class="timeline-badge success"><i class="la la-check"></i></div>
      							<div class="timeline-panel">
      								<div class="timeline-heading">
      									<h4 class="m--font-warning timeline-title">Chương trình đào tạo</h4>
      								</div>
      								<div class="timeline-body timeline-body-edu">
                        <ul class="m-menu__content list-unstyled">
                          <li class="m-menu__item " data-redirect="true" aria-haspopup="true">
                            <a href="${context}/detail/pre-bridge" class="m-menu__link ">
                              <i class="m-menu__link-icon flaticon-map"></i>
                              <span class="m-menu__link-text text-left">
                                Kỹ sư cầu nối
                              </span>
                            </a>
                          </li>
                          <li class="m-menu__item " data-redirect="true" aria-haspopup="true">
                            <a href="${context}/detail/javafullstack" class="m-menu__link ">
                              <i class="m-menu__link-icon flaticon-user"></i>
                              <span class="m-menu__link-text text-left">
                                Java full-stack
                              </span>
                            </a>
                          </li>
                          <li class="m-menu__item " data-redirect="true" aria-haspopup="true">
                            <a href="${context}/detail/program-net" class="m-menu__link ">
                              <i class="m-menu__link-icon flaticon-clipboard"></i>
                              <span class="m-menu__link-text text-left">
                                .Net full-stack
                              </span>
                            </a>
                          </li>
                          <li class="m-menu__item " data-redirect="true" aria-haspopup="true">
                            <a href="${context}/detail/frontend-stack" class="m-menu__link ">
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
      						<li class="timeline-item">
      							<div class="timeline-badge info"><i class="la la-check"></i></div>
      							<div class="timeline-panel">
      								<div class="timeline-heading">
      									<h4 class="m--font-warning timeline-title">Công ty và đối tác</h4>
      								</div>
      								<div class="timeline-body timeline-body-partner">
                        <ul class="m-menu__content list-unstyled">
      										<li class="m-menu__item">
      											<ul class="list-unstyled m-menu__inner">
      												<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
      													<a href="header/actions.html" class="m-menu__link ">
                                  <i class="m-menu__link-bullet m-menu__link-bullet--line">
																		<span></span>
																	</i>
      														<span class="m-menu__link-text">
      															Annual Reports
      														</span>
      													</a>
      												</li>
      												<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
      													<a href="header/actions.html" class="m-menu__link ">
                                  <i class="m-menu__link-bullet m-menu__link-bullet--line">
																		<span></span>
																	</i>
      														<span class="m-menu__link-text">
      															HR Reports
      														</span>
      													</a>
      												</li>
      												<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
      													<a href="header/actions.html" class="m-menu__link ">
                                  <i class="m-menu__link-bullet m-menu__link-bullet--line">
																		<span></span>
																	</i>
      														<span class="m-menu__link-text">
      															IPO Reports
      														</span>
      													</a>
      												</li>
      												<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
      													<a href="header/actions.html" class="m-menu__link ">
                                  <i class="m-menu__link-bullet m-menu__link-bullet--line">
																		<span></span>
																	</i>
      														<span class="m-menu__link-text">
      															Finance Margins
      														</span>
      													</a>
      												</li>
      												<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
      													<a href="header/actions.html" class="m-menu__link ">
                                  <i class="m-menu__link-bullet m-menu__link-bullet--line">
																		<span></span>
																	</i>
      														<span class="m-menu__link-text">
      															Revenue Reports
      														</span>
      													</a>
      												</li>
      											</ul>
      										</li>
      										<li class="m-menu__item">
      											<ul class="list-unstyled m-menu__inner">
      												<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
      													<a href="header/actions.html" class="m-menu__link ">
      														<i class="m-menu__link-bullet m-menu__link-bullet--line">
      															<span></span>
      														</i>
      														<span class="m-menu__link-text">
      															Coca Cola CRM
      														</span>
      													</a>
      												</li>
      												<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
      													<a href="header/actions.html" class="m-menu__link ">
      														<i class="m-menu__link-bullet m-menu__link-bullet--line">
      															<span></span>
      														</i>
      														<span class="m-menu__link-text">
      															Delta Airlines Booking Site
      														</span>
      													</a>
      												</li>
      												<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
      													<a href="header/actions.html" class="m-menu__link ">
      														<i class="m-menu__link-bullet m-menu__link-bullet--line">
      															<span></span>
      														</i>
      														<span class="m-menu__link-text">
      															Malibu Accounting
      														</span>
      													</a>
      												</li>
      												<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
      													<a href="header/actions.html" class="m-menu__link ">
      														<i class="m-menu__link-bullet m-menu__link-bullet--line">
      															<span></span>
      														</i>
      														<span class="m-menu__link-text">
      															Vineseed Website Rewamp
      														</span>
      													</a>
      												</li>
      												<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
      													<a href="header/actions.html" class="m-menu__link ">
      														<i class="m-menu__link-bullet m-menu__link-bullet--line">
      															<span></span>
      														</i>
      														<span class="m-menu__link-text">
      															Zircon Mobile App
      														</span>
      													</a>
      												</li>
      												<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
      													<a href="header/actions.html" class="m-menu__link ">
      														<i class="m-menu__link-bullet m-menu__link-bullet--line">
      															<span></span>
      														</i>
      														<span class="m-menu__link-text">
      															Mercury CMS
      														</span>
      													</a>
      												</li>
      											</ul>
      										</li>
      									</ul>
      								</div>
      							</div>
      						</li>
      					</ul>
      				</div>
            </div>
          </div>
        </div>
      </div>
      <script>
          $(window).on('load', function() {
            $('body').removeClass('m-page--loading');
          });
        </script>