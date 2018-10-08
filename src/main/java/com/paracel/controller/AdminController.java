package com.paracel.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.paracel.dao.PageableGuestRepository;
import com.paracel.dao.PageableUserRepository;
import com.paracel.entity.Course;
import com.paracel.entity.Role;
import com.paracel.entity.User;
import com.paracel.entity.UserCourse;
import com.paracel.entity.UserRole;
import com.paracel.service.AdminService;
import com.paracel.service.CourseService;
import com.paracel.service.UserService;


@Controller
@RequestMapping(value = "/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PageableUserRepository pageableUserRepository;
	
	@Autowired
	private PageableGuestRepository pageableGuestRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;


	@RequestMapping(value = "/admin-page", method = RequestMethod.GET)
    public String showAdmin(ModelMap model,
    		@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
		    @RequestParam(name = "size", required = false, defaultValue = "10") Integer size,
		    @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof User) {
            User user = (User) (principal);
            model.addAttribute("name", user.getUserName());
        }
        if(page>0) page = page-1;
        Sort sortable = null;
        if(sort.equals("ASC")) {
        	sortable = Sort.by("id").ascending();
        }
        else if(sort.equals("DESC")) {
        	sortable = Sort.by("id").descending();
        }
        Pageable pageable = PageRequest.of(page, size, sortable);
        int numPage = (int)Math.ceil((float)pageableGuestRepository.countGuest()/size);
        model.addAttribute("list", pageableGuestRepository.findPageGuest(pageable));
        model.addAttribute("numPage", numPage);
        model.addAttribute("page", page+1);
        model.addAttribute("message", "This is page Teacher!");
        return "admin";
    }

	
	@RequestMapping(value="create-user")
	public String viewRegister(Model model) {
		List<Course> list = courseService.getAllCourse();
		model.addAttribute("list", list);
		return "create-user";
	}
	
	// Giao dien khoa tai khoan
	@RequestMapping(value="/lockup",method=RequestMethod.GET)
	public ModelAndView lockup(Model model,
			@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
		    @RequestParam(name = "size", required = false, defaultValue = "10") Integer size,
		    @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort) {
		if(page>0) page = page-1;
		Sort sortable = null;
	    if (sort.equals("ASC")) {
	      sortable = Sort.by("User_Id").ascending();
	    }
	    if (sort.equals("DESC")) {
	      sortable = Sort.by("User_Id").descending();
	    }
	    Pageable pageable = PageRequest.of(page, size, sortable);
	    int numPage = (int)Math.ceil((float)pageableUserRepository.countUsers()/size);
		model.addAttribute("list", pageableUserRepository.findUsers(pageable));
		model.addAttribute("numPage", numPage);
		model.addAttribute("page", page+1);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("lockup");
		return mav;
	}
	
	// Action 
	@RequestMapping(value="/editEnabled",method=RequestMethod.GET)
	@ResponseBody
	public boolean getEnabled(HttpServletRequest request) {
		long id= Integer.parseInt(request.getParameter("id"));
		boolean enabled = Boolean.parseBoolean(request.getParameter("enabled"));
		adminService.updateEnabled(enabled, id);
		return enabled;
	}
	
	// Action create Account
	@RequestMapping(value="/createUser",method=RequestMethod.POST)
	@ResponseBody
	public boolean createUser(@ModelAttribute User user,Errors errors,HttpServletRequest request,
			@RequestParam(value="sel",required=false)int sel) {
		if(userService.findByUserName(user.getUserName())!=null) {
			return false;
		}
		user.setEncrytedPassword(passwordEncoder.encode(user.getEncrytedPassword()));
		long maxUser = (long)adminService.getMaxIdUser();
		user.setUserId(++maxUser);   // Lay id max trong User
		Role role = adminService.findByNameRole("ROLE_USER");
		UserRole userRole = new UserRole();
		long maxUserRole = (long)adminService.getMaxUserRole();//Lay id max trong UserRole
		
		//Gan gia tri cho bang UserRole
		userRole.setId(++maxUserRole);  
		userRole.setRole(role);
		userRole.setUser(user);
		List<UserRole> userRoles = new ArrayList<>();
		userRoles.add(userRole);
		
		Course course = adminService.findByIdCourse(sel);
		UserCourse userCourse = new UserCourse();
		//Gan gia tri cho bang UserCourse
		userCourse.setNameCourse(course.getNameCourse());
		userCourse.setDescription(course.getDescription());
		userCourse.setPrice(course.getPrice());
		userCourse.setStartDate(new java.util.Date());
		userCourse.setEndDate(new java.util.Date());
		
		userCourse.setC(course);
		userCourse.setU(user);
		List<UserCourse> userCourses = new ArrayList<>();
		userCourses.add(userCourse);
		
		user.setUserCourses(userCourses);
		user.setUro(userRoles);
		userService.saveUser(user);
		
		return true;
	}
	
	@RequestMapping(value="/editStatistical",method=RequestMethod.GET,produces = "application/json")
	public @ResponseBody String getStatus(HttpServletRequest request) {
		int id= Integer.parseInt(request.getParameter("id"));
		int status = Integer.parseInt(request.getParameter("status"));
		adminService.updateStatusGuest(id, status);
		return "success";
	}

}
