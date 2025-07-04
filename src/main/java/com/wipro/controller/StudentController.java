package com.wipro.controller;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
 
import com.wipro.model.Student;
 

 
@Controller
public class StudentController {
 
	
	@PostMapping("/saveStudent") 
	public ModelAndView getStudent(@RequestParam("studentId") int stid,@RequestParam("studentName") String stname	)
	{
		ModelAndView mv = new ModelAndView();
		Student student = new Student();
		student.setStid(stid);
		student.setStname(stname);
		mv.addObject("xyz",student);

		mv.setViewName("display");
		return mv;
	}
}
