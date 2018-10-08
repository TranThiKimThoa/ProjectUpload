package com.paracel.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.paracel.entity.Course;
import com.paracel.entity.Guest;
import com.paracel.service.CourseService;
import com.paracel.service.GuestService;

@Controller
public class TextController {

	@Autowired
	private GuestService guestService;

	@Autowired
	private CourseService courseService;

	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public ModelAndView contact() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("contact");
		return mav;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView registration(@RequestParam(value = "id", required = false)int id, Model model,
			@RequestParam(value="check",required=false,defaultValue="0")int check,HttpSession session) {
		session.setAttribute("idCourse", id);
		session.setAttribute("check", check);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("registration");
		return mav;
	}

	@RequestMapping(value = "/view-course", method = RequestMethod.GET)
	public ModelAndView viewCourse(Model model,@RequestParam(value="page",required=false,defaultValue="0")int page,
			                          HttpSession session) {
		if(session.getAttribute("idCourse")!=null) {
			model.addAttribute("idCourse",session.getAttribute("idCourse"));
			session.removeAttribute("idCourse");
		}
		if(session.getAttribute("check")!=null) {
			session.removeAttribute("check");
		}
		long numPage = (long)Math.ceil((double)courseService.getCount()/4);
		List<Course> list = new ArrayList<Course>();
		if(page==0) {
			list = courseService.getListCourse(1, 4);
			page++;
		} else {
			list = courseService.getListCourse(page, 4);
		}
		model.addAttribute("page", page);
		model.addAttribute("list", list);
		model.addAttribute("numPage", numPage);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("view-course");
		return mav;
	}

	@RequestMapping(value = "/saveGuest", method = RequestMethod.POST)

	public ModelAndView saveGuest(@ModelAttribute("guest") Guest guest, BindingResult bindingResult, HttpSession session,Model model) {
		for( FieldError fieldError : bindingResult.getFieldErrors() )
		    System.out.println(fieldError.getField() +" : "+fieldError.getDefaultMessage());
		int idCourse = 0;
		int check = 0;
		ModelAndView mav = new ModelAndView();
		if(session.getAttribute("idCourse")!=null) {
			idCourse = (int) session.getAttribute("idCourse");
		}
		if(session.getAttribute("check")!=null) {
			check = (int) session.getAttribute("check");
		}
		List<Course> list = new ArrayList<>();
		Course course = courseService.findByIdCourse(idCourse);
		list.add(course);
		guest.setCourses(list);
		guestService.insertGuest(guest);
		session.setAttribute("message", "success");
		switch(check) {
		case 1: mav.setViewName("redirect:/detail/pre-bridge");break;
		case 2: mav.setViewName("redirect:/detail/javafullstack");break;
		case 3: mav.setViewName("redirect:/detail/program-net");break;
		case 4: mav.setViewName("redirect:/detail/frontend-stack");break;
		default: mav.setViewName("redirect:/view-course");break;
		}
		return mav;
	}
	
}
