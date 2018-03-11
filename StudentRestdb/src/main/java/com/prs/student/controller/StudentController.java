package com.prs.student.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prs.student.model.studentdto;
import com.prs.studentdao.StudentRepo;
import com.prs.studentdao.StudentRepoImpl;

@RestController
@RequestMapping(value="/student")
public class StudentController{
	
	private static final Logger log=LoggerFactory.getLogger(StudentController.class);

	@Autowired
	StudentRepoImpl stdrep;
	
	
	@RequestMapping(value="/get/{studentid}" ,method=RequestMethod.GET)
	@ResponseBody
	public studentdto GetStudent(@PathVariable("studentid") long studentid){
		try
		{
			log.info("Executing AddStudent for Studentid={1}" + studentid);
		return stdrep.Find(studentid);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage());
			return null;
		}
		
	}
	@RequestMapping(value="/add" ,method=RequestMethod.PUT)
	public boolean Addstudent(@RequestBody studentdto student){
		try
		{
			log.info("Executing AddStudent for Studentid={1}"+ student.getId());
		return stdrep.AddStudent(student);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage());
			return false;
		}
	}

	@RequestMapping(value="/del",method=RequestMethod.DELETE)
	public boolean Deletestudent(@RequestBody studentdto student){
		try
		{
		log.info("Executing DeleteStudent for Studentid=" + student.getId());
		return stdrep.DeleteStudent(student);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage());
			return false;
		}
	}
	
	@RequestMapping(value="/update" ,method=RequestMethod.PUT)
	public boolean updatestudent(@RequestBody studentdto student){
		try
		{
		log.info("Executing DeleteStudent for Studentid="+ student.getId());
		return stdrep.Modify(student);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage());
			return false;
		}
	}
	
	@RequestMapping(value="/GetAll" ,method=RequestMethod.GET)
	@ResponseBody
	public List<studentdto> GetAllStudents(){
		try
		{
		log.info("Executing GetAllStudents..");
		return stdrep.FindAll();
	
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage());
			return null;
		}
		
	}
}
