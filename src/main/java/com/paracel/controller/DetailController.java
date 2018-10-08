package com.paracel.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class DetailController {
	@RequestMapping(value = "/detail/javafullstack", method = RequestMethod.GET)
	public ModelAndView javaFullStack(HttpSession session,Model model) {
		if(session.getAttribute("check")!=null) {
			model.addAttribute("check", session.getAttribute("check"));
			session.removeAttribute("check");
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("javafs");
		return mav;
	}
	@RequestMapping(value = "/detail/pre-bridge", method = RequestMethod.GET)
	public ModelAndView priSe(HttpSession session,Model model) {
		if(session.getAttribute("check")!=null) {
			model.addAttribute("check", session.getAttribute("check"));
			session.removeAttribute("check");
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("pre-bridge");
		return mav;
	}
	@RequestMapping(value = "/detail/program-net", method = RequestMethod.GET)
	public ModelAndView programNet(HttpSession session,Model model) {
		if(session.getAttribute("check")!=null) {
			model.addAttribute("check", session.getAttribute("check"));
			session.removeAttribute("check");
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("program-net");
		return mav;
	}

	@RequestMapping(value = "/detail/frontend-stack", method = RequestMethod.GET)
	public ModelAndView frontendStack(HttpSession session,Model model) {
		if(session.getAttribute("check")!=null) {
			model.addAttribute("check", session.getAttribute("check"));
			session.removeAttribute("check");
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("frontend-stack");
		return mav;
	}
}