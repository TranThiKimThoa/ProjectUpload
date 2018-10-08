package com.paracel.controller;

import java.security.Principal;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.paracel.entity.User;

@Controller
public class HomeController implements ErrorController {

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		return mav;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;
	}

	@RequestMapping(value = "/loginError", method = RequestMethod.GET)
	public String loginError(ModelMap model) {

		model.addAttribute("message", "Mã đăng nhập hoặc mật khẩu không đúng. Vui lòng nhập lại!");
		return "login";
	}

	@RequestMapping(value = "/partner")
	public String partner(ModelMap model) {
		return "partner";
	}

	@RequestMapping(value = "/programs")
	public String programs(ModelMap model) {
		return "programs";
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}

	@RequestMapping("/error")
	@ResponseBody
	public ModelAndView handleError(HttpServletRequest request) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		ModelAndView mav = new ModelAndView("error");
		if (status != null) {
			Integer statusCode = Integer.valueOf(status.toString());

			if (statusCode == HttpStatus.NOT_FOUND.value()) {
				mav.setViewName("error-404");
			} else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				mav.setViewName("error-500");
			}
		}
		return mav;
	}

	@RequestMapping(value = "/student")
	public String students(ModelMap model) {
		return "student";
	}

}