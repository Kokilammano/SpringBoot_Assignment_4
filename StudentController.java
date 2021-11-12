//Student Controller Class

package com.abc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.abc.model.Student;
import com.abc.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService service;
	
	//View Student Details
	@RequestMapping("/")
	public String viewhomePage(Model model) {
		List<Student> listStudents=service.listAll();
		model.addAttribute("listStudents", listStudents);
		return "index";
	}
	
	//Add New Student 
	@RequestMapping("/new")
	public String showNewStudent(Model model) {
		Student student=new Student();
		model.addAttribute("student", student);
		return "new_student";
	}
	
	
	//Save Operation
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveStudent(@Valid @ModelAttribute("student") Student student,BindingResult result) {
		if(result.hasErrors()) {
			return "new_student";
		}
		service.save(student);
		return "redirect:/";
	}
	
	//Update Operation
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String UpdateStudent(@Valid @ModelAttribute("student") Student student,BindingResult result) {
		if(result.hasErrors()) {
			return "edit_student";
		}
		service.save(student);
		return "redirect:/";
	}
	
	//Edit Student Details
	@RequestMapping("/edit/{roll_no}")
	public ModelAndView showEditStudentPage(@PathVariable(name="roll_no") int roll_no) {
		ModelAndView mav=new ModelAndView("edit_student");
		Student student=service.get(roll_no);
		mav.addObject("student", student);
		return mav;
	}
	
	
	//Delete Student Details
	@RequestMapping("/delete/{roll_no}")
	public String deleteStudent(@PathVariable(name="roll_no")int roll_no) {
		service.delete(roll_no);
		return "redirect:/";
	}
	
}
