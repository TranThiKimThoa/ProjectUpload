package com.paracel.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.paracel.entity.Exercise;
import com.paracel.entity.TeacherExercise;
import com.paracel.entity.User;
import com.paracel.entity.UserCourse;
import com.paracel.service.ExerciseService;
import com.paracel.service.TeacherExerciseService;
import com.paracel.service.UserCourseService;
import com.paracel.service.UserService;
import com.paracel.utils.EncrytedPasswordUtils;
import com.paracel.utils.WebUtils;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private Environment environment;

	@Autowired
	private UserService userService;

	@Autowired
	private UserCourseService userCourseService;

	@Autowired
	private ExerciseService exerciseService;
	
	@Autowired
	private TeacherExerciseService teacherExerciseService;
	
//	@ModelAttribute("listExercise")
//	private List<TeacherExercise> list() {
//		return teacherExerciseService.findAllNames();
//	}

	String user;
	String user1;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String userPage(ModelMap model, Principal principal, HttpSession session) {
		org.springframework.security.core.userdetails.User loginedUser = (org.springframework.security.core.userdetails.User) ((Authentication) principal)
				.getPrincipal();

		user = loginedUser.getUsername();

		List<UserCourse> list = userCourseService.findNameCourse(user);

		model.addAttribute("course", list);
		String userInfo = WebUtils.toString(loginedUser);
		session.setAttribute("t", userInfo);
		model.addAttribute("name", userInfo);

		return "user";
	}

	@RequestMapping(value = "/exercise/{id}")
	public String exercise(ModelMap model, @PathVariable(value = "id") int id, HttpSession session) {
		List<Exercise> list = exerciseService.findExercises(id);
		session.setAttribute("id", id);
		String user = (String) session.getAttribute("t");
		model.addAttribute("name", user);
		model.addAttribute("list", list);
		return "detaisexam";
	}
	
	@RequestMapping(value = "/getImages/{id}")
	@ResponseBody
	public byte[]  getImage(@PathVariable(value = "id") int id) throws IOException {
		Exercise ex = exerciseService.findByNameFile(id);
		Path path = null;
		if (ex == null) {
			path = Paths.get(ex.getFilepath() + "/noimage.jpg");
		} else {
			path = Paths.get(ex.getFilepath() + "/" + ex.getNamefile());
		}
		
		return Files.readAllBytes(path); 
		
	}

	@RequestMapping(value = "/upload")
	public String upload(ModelMap model, HttpSession session, @ModelAttribute(value = "ex") Exercise ex, Principal principal) {
		String user = (String) session.getAttribute("t");
		model.addAttribute("name", user);

		
		org.springframework.security.core.userdetails.User loginedUser = (org.springframework.security.core.userdetails.User) ((Authentication) principal)
				.getPrincipal();

		user = loginedUser.getUsername();
		User u = userService.findPassword(user);
		
		int idUserCourse = (int) session.getAttribute("id");
		UserCourse usc = userCourseService.getFindIdCourse(idUserCourse);
		
		List<TeacherExercise> list = teacherExerciseService.findAllNames(u.getUserId(), usc.getC().getId());
		model.addAttribute("listExercise", list);
		return "upload";
	}

	@RequestMapping(value = "/saveupload")
	public String saveUpload(@RequestParam("file") MultipartFile file, ModelMap model,
			RedirectAttributes redirectAttributes, @ModelAttribute(value = "ex") Exercise ex, HttpSession session,
			Principal principal) {
		if (file.isEmpty()) {
			model.addAttribute("message", "Please select a file and try again");
			return "status";
		}
		try {

			String pathFolder = environment.getRequiredProperty("file_path");
			byte[] bytes = file.getBytes();
			Path path = Paths.get(pathFolder + file.getOriginalFilename());
			Files.write(path, bytes);

			String name = file.getOriginalFilename();

			String contentType = file.getContentType();
			
			Date date = new Date();
			int id = (int) session.getAttribute("id");
			UserCourse us = new UserCourse();
			us.setId(id);
			ex.setUsc(us);
			ex.setNamefile(name);
			ex.setDatefilling(date);
			ex.setFilepath(pathFolder);
			ex.setTailpath(contentType);
			
			exerciseService.saveExercise(ex);

		} catch (IOException e) {
			e.printStackTrace();
		}
		String user = (String) session.getAttribute("t");
		model.addAttribute("name", user);

		model.addAttribute("message", "File Uploaded sucessfully");
		org.springframework.security.core.userdetails.User loginedUser = (org.springframework.security.core.userdetails.User) ((Authentication) principal)
				.getPrincipal();

		user1 = loginedUser.getUsername();
		List<UserCourse> list = userCourseService.findNameCourse(user1);

		model.addAttribute("course", list);

		return "user";
	}
	
	@RequestMapping(value = "/download/{id}", method = RequestMethod.GET)
	  public void download1(@PathVariable(value = "id") int id, HttpServletResponse response) throws IOException {
	    try {
	      Exercise ex = exerciseService.findByNameFile(id);
	      String a = ex.getFilepath()+"/"+ex.getNamefile();
	      File file = ResourceUtils.getFile(a);
	      byte[] data = FileUtils.readFileToByteArray(file);
	      // Thiết lập thông tin trả về
	      response.setContentType("application/octet-stream");
	      response.setHeader("Content-disposition", "attachment; filename=" + file.getName());
	      response.setContentLength(data.length);
	      InputStream inputStream = new BufferedInputStream(new ByteArrayInputStream(data));
	      FileCopyUtils.copy(inputStream, response.getOutputStream());
	    } catch (Exception ex) {
	      ex.printStackTrace();
	    }
	  }


	@RequestMapping(value = "/changepassword")
	public String formChangePassword(ModelMap model, HttpSession session, Principal principal) {

		String user1 = (String) session.getAttribute("t");
		model.addAttribute("name", user1);

		org.springframework.security.core.userdetails.User loginedUser = (org.springframework.security.core.userdetails.User) ((Authentication) principal)
				.getPrincipal();

		user = loginedUser.getUsername();

		User u = userService.findPassword(user);
		model.addAttribute("user", u);
		return "formchange";
	}

	@RequestMapping(value = "/editPassword",method = RequestMethod.POST)
	public String actionEditRoom(ModelMap model, @ModelAttribute(value = "user") User user) {
		User us = new User();
		us.setUserId(user.getUserId());
		us.setEncrytedPassword(EncrytedPasswordUtils.encrytePassword(user.getEncrytedPassword()));
		us.setUserName(user.getUserName());
		us.setEmail(user.getEmail());
		us.setDateRegister(user.getDateRegister());
		us.setPhone(user.getPhone());
		us.setFull_Name(user.getFull_Name());
		us.setEnabled(true);

		User u = userService.saveUser(us);

		if (u.getUserId() > 0) {
			return "redirect:/login";
		} else {
			model.addAttribute("message", "Change password fail");
			return "formchange";
		}
	}

	@RequestMapping(value = "/delete")
	public String deleteExercise(ModelMap model, @ModelAttribute(value = "id") int id) {

		boolean isExits = exerciseService.delete(id);
		if (isExits) {
			model.addAttribute("message", "delete fail");
		} else {
			model.addAttribute("message", "delete success");
		}

		return "redirect:/user/";
	}
	
	
}
