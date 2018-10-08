<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<div class="m-grid m-grid--hor m-grid--root m-page">
			<div class="m-login m-login--5 m-login--signin" id="m_login" style="background-image: url(${context}/resources/dist/images/bg-3.jpg);">
				<div class="m-login__wrapper-1 m-portlet-full-height">
					<div class="m-login__wrapper-1-1">
						<div class="m-login__contanier">
							<div class="m-login__content">
								<div class="m-login__logo">
									<a href="#">
										<img src="${context}/resources/dist/images/logo.png" width="45%">
									</a>
								</div>
								<div class="m-login__title">
									<h3>
										Chào mừng bạn đến với công ty Paracel Project Education
									</h3>
								</div>
								<div class="m-login__desc">
									Không ngừng cố gắng, không ngừng phát triển
								</div>
								
							</div>
						</div>
						<div class="m-login__border">
							<div></div>
						</div>
					</div>
				</div>
				<div class="m-login__wrapper-2 m-portlet-full-height">
					<div class="m-login__contanier">
						<div class="m-login__signin">
							<div class="m-login__head">
								<h3 class="m-login__title">
									Đăng nhập vào tài khoản của bạn
								</h3>
							</div>
							<form class="m-login__form m-form" action="${context }/checklogin" method='POST' name="f">
								<c:if test="${message !=null}">
									<div class="row">
										<div class="col-sm-offset-2 col-sm-8">
											<div class="alert alert-danger">${message}</div>
										</div>
									</div>
								</c:if>
								<div class="form-group m-form__group">
									<input class="form-control m-input" type="text" placeholder="Mã đăng nhập" name="username" autocomplete="off" value="">
								</div>
								<div class="form-group m-form__group">
									<input class="form-control m-input m-login__form-input--last" type="password" placeholder="Mật khẩu" name="password">
								</div>
								<div class="row m-login__form-sub">
									<div class="col m--align-left">
										<label class="m-checkbox m-checkbox--focus">
											<input type="checkbox" name="remember-me">
											Nhớ mật khẩu
											<span></span>
										</label>
									</div>
									
								</div>
								<div class="m-login__form-action">
									<input class="btn m-btn--pill    btn-primary m-btn m-btn--custom" name="submit" type="submit" value="Đăng nhập" />
								</div>
							</form>
						</div>
						<div class="m-login__signup">
							<div class="m-login__head">
								<h3 class="m-login__title">
									Sign Up
								</h3>
								<div class="m-login__desc">
									Enter your details to create your account:
								</div>
							</div>
							<form class="m-login__form m-form" action="">
								<div class="form-group m-form__group">
									<input class="form-control m-input" type="text" placeholder="Fullname" name="fullname">
								</div>
								<div class="form-group m-form__group">
									<input class="form-control m-input" type="text" placeholder="Email" name="email" autocomplete="off">
								</div>
								<div class="form-group m-form__group">
									<input class="form-control m-input" type="password" placeholder="Password" name="password">
								</div>
								<div class="form-group m-form__group">
									<input class="form-control m-input m-login__form-input--last" type="password" placeholder="Confirm Password" name="rpassword">
								</div>
								<div class="m-login__form-sub">
									<label class="m-checkbox m-checkbox--focus">
										<input type="checkbox" name="agree">
										I Agree the
										<a href="#" class="m-link m-link--focus">
											terms and conditions
										</a>
										.
										<span></span>
									</label>
									<span class="m-form__help"></span>
								</div>
								<div class="m-login__form-action">
									<button id="m_login_signup_submit" class="btn btn-focus m-btn m-btn--pill m-btn--custom m-btn--air">
										Sign Up
									</button>
									<button id="m_login_signup_cancel" class="btn btn-outline-focus m-btn m-btn--pill m-btn--custom">
										Cancel
									</button>
								</div>
							</form>
						</div>
						<div class="m-login__forget-password">
							<div class="m-login__head">
								<h3 class="m-login__title">
									Forgotten Password ?
								</h3>
								<div class="m-login__desc">
									Enter your email to reset your password:
								</div>
							</div>
							<form class="m-login__form m-form" action="" novalidate="novalidate">
								<div class="form-group m-form__group">
									<input class="form-control m-input" type="text" placeholder="Email" name="email" id="m_email" autocomplete="off" aria-describedby="m_email-error" aria-invalid="false">
								</div>
								<div class="m-login__form-action">
									<button id="m_login_forget_password_submit" class="btn btn-focus m-btn m-btn--pill m-btn--custom m-btn--air m-loader m-loader--right m-loader--light" disabled="disabled">
										Request
									</button>
									<button id="m_login_forget_password_cancel" class="btn btn-outline-focus m-btn m-btn--pill m-btn--custom ">
										Cancel
									</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>