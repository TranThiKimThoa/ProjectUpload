package com.paracel.controller;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.paracel.entity.Course;
import com.paracel.entity.Exercise;
import com.paracel.entity.TeacherExercise;
import com.paracel.entity.User;
import com.paracel.entity.UserCourse;
import com.paracel.service.CourseService;
import com.paracel.service.ExerciseService;
import com.paracel.service.TeacherExerciseService;
import com.paracel.service.UserCourseService;
import com.paracel.service.UserService;
import com.paracel.utils.WebUtils;

@Controller
@RequestMapping(value = "/teacher")
public class TeacherController {
	
	@Autowired
	private UserCourseService userCourseService;
	
	@Autowired
	private ExerciseService exerciseService;
	
	@Autowired 
	private UserService userService;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private TeacherExerciseService teacherExerciseService;
	
	String user;
	
	@RequestMapping(value = "/teacher-page", method = RequestMethod.GET)
    public String showAdmin(ModelMap model, Principal principal) {
		org.springframework.security.core.userdetails.User loginedUser = (org.springframework.security.core.userdetails.User) ((Authentication) principal)
				.getPrincipal();

		user = loginedUser.getUsername();
		HashMap< Integer, List<Integer>>  hmNumberExercise= new HashMap<>();
		HashMap< Integer, List<String>>  dateExercise= new HashMap<>();
		List<Course> listCou = courseService.findIdCourse(user);
		List<UserCourse> list = new ArrayList<>();
		model.addAttribute("nameCourse", listCou);
		for(int j = 0; j < listCou.size(); j++) {
			
			int id = listCou.get(j).getId();
			
			List<UserCourse> listU = userCourseService.findAllByIdCourse(id);

			for(int i = 0; i < listU.size(); i++) {
				
				list.add(listU.get(i));
				long k = listU.get(i).getU().getUserId();
				int idusercourse = listU.get(i).getId();
				
				List<Integer> b = exerciseService.numberExercise(id, k);
				hmNumberExercise.put(idusercourse, b);
				
				List<String> ex = exerciseService.maxDate(id, k);
				dateExercise.put(idusercourse, ex);
				
				
			}
		}
		model.addAttribute("nameUser", list);	
		
		String userInfo = WebUtils.toString(loginedUser);
		model.addAttribute("name", userInfo);
		model.addAttribute("hmNumberExercise",hmNumberExercise);
		model.addAttribute("dateExercise",dateExercise);
        return "teacher";
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
	
	@RequestMapping(value = "/download/{id}", method = RequestMethod.GET)
	  public void download1(@PathVariable(value = "id") int id, HttpServletResponse response) throws IOException {
	    try {
	      Exercise ex = exerciseService.findByNameFile(id);
	      String a = ex.getFilepath()+"/"+ex.getNamefile();
	      File file = ResourceUtils.getFile(a);
	      byte[] data = FileUtils.readFileToByteArray(file);
	      
	      response.setContentType("application/octet-stream");
	      response.setHeader("Content-disposition", "attachment; filename=" + file.getName());
	      response.setContentLength(data.length);
	      InputStream inputStream = new BufferedInputStream(new ByteArrayInputStream(data));
	      FileCopyUtils.copy(inputStream, response.getOutputStream());
	    } catch (Exception ex) {
	      ex.printStackTrace();
	    }
	  }
	
	@RequestMapping(value = "/displays")
	public String displayExercise(ModelMap model, @RequestParam(value = "iduser") Long iduser, @RequestParam(value = "id") int idcourse,
			Principal principal) {
		
		List<TeacherExercise> lists = teacherExerciseService.getListTeacherExerciseByIDCourse(idcourse);
		model.addAttribute("lists",lists);
		
		UserCourse usco = userCourseService.findInUserCourseById(idcourse, iduser);
		
		List<Exercise> listEx = exerciseService.listAllExerciseDisplay(idcourse, usco.getId(), iduser);
		model.addAttribute("listEx", listEx);
		
		org.springframework.security.core.userdetails.User loginedUser = (org.springframework.security.core.userdetails.User) ((Authentication) principal)
				.getPrincipal();

		user = loginedUser.getUsername();
		
		List<Course> listCou = courseService.findIdCourse(user);
		List<UserCourse> list1 = new ArrayList<>();
		model.addAttribute("nameCourse", listCou);
		for(int j = 0; j < listCou.size(); j++) {
			int id1 = listCou.get(j).getId();
			List<UserCourse> listU = userCourseService.findAllByIdCourse(id1);

			for(int i = 0; i < listU.size(); i++) {
				list1.add(listU.get(i));
			}
		}
		model.addAttribute("nameUser", list1);	
		
		String userInfo = WebUtils.toString(loginedUser);
		model.addAttribute("name", userInfo);
		return "display";
	}
	
	
	
	@RequestMapping(value = "/addExercise")
	public String formAddExercise(ModelMap model, @ModelAttribute(value = "teacherexercise") TeacherExercise teacherexercise, Principal principal) {
		
		org.springframework.security.core.userdetails.User loginedUser = (org.springframework.security.core.userdetails.User) ((Authentication) principal)
				.getPrincipal();

		user = loginedUser.getUsername();
		
		List<Course> listCou = courseService.findIdCourse(user);
		List<UserCourse> list = new ArrayList<>();
		model.addAttribute("nameCourse", listCou);
		
		User user2 = userService.findPassword(user);
		
		List<Course> listCourse = courseService.listAllCourse(user2.getUserId());
		model.addAttribute("listCourse", listCourse);
		
		for(int j = 0; j < listCou.size(); j++) {
			int id = listCou.get(j).getId();
			List<UserCourse> listU = userCourseService.findAllByIdCourse(id);

			for(int i = 0; i < listU.size(); i++) {
				list.add(listU.get(i));
			}
		}
		model.addAttribute("nameUser", list);	
		
		String userInfo = WebUtils.toString(loginedUser);
		model.addAttribute("name", userInfo);
		
		return "add-exercise";
	}
	
	@RequestMapping(value = "/saveExercise")
	public String saveExerciseInDB(ModelMap model, @ModelAttribute(value = "teacherexercise") TeacherExercise teacherexercise) {
		TeacherExercise te = teacherExerciseService.saveExercise(teacherexercise);
		if(te.getId() > 0) {
			model.addAttribute("message", "Add Success");
			return "redirect:/teacher/teacher-page";
		} else {
			model.addAttribute("message", "Add Fail");
			return "add-exercise";
		}
	}
}
