package com.prs.studentdao;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.prs.student.model.studentdto;

@Repository
public class StudentRepoImpl implements StudentRepo  {
	private static final Logger log=LoggerFactory.getLogger(StudentRepoImpl.class);
	
	@Autowired
	JdbcTemplate jdbctemp;
	
	@Override
	public boolean AddStudent(studentdto newStudent) {
		// TODO Auto-generated method stub
		String sqlQuery="Insert into studentdto (id,student_name,student_address) values (?,?,?)";
		int queryResult=0;
		try
		{
			queryResult=jdbctemp.update(sqlQuery, newStudent.getId(),newStudent.getStudent_name(),newStudent.getStudent_address());
			if (queryResult>0)
			{
				return true;
			}
			else
				return false;
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage());// TODO: handle exception
			return false;
		}
		
	}

	@Override
	public boolean DeleteStudent(studentdto newStudent) {
		String sqlQuery="Delete from studentdto where id=?";
		int queryResult=0;
		try {
			queryResult=jdbctemp.update(sqlQuery,newStudent.getId());
			
			if (queryResult>0)
			{
				return true;
			}
			else
				return false;
		} catch (Exception e) {
			log.error(e.getMessage());// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean Modify(studentdto newStudent) {
		String sqlQuery="update studentdto set student_name=?,student_address=? where id=?";
		int queryResult=0;
		try {
			queryResult=jdbctemp.update(sqlQuery,newStudent.getStudent_name(),newStudent.getStudent_address(),newStudent.getId());
			if (queryResult>0)
			{
				return true;
			}
			else
				return false;
			
		} catch (Exception e) {
			log.error(e.getMessage());// TODO: handle exception
			return false;
		}
	}

	@Override
	public studentdto Find(long studentid) {
		// TODO Auto-generated method stub
		
		
		String sqlQuery="Select id,student_name,student_address from studentdto where id=?";
		try
		{
			studentdto std=(studentdto) jdbctemp.queryForObject(sqlQuery,
					new Object[] {studentid},new StudentRowMapper());
			return std;
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage());
			return null;
		}
	}

	@Override
	public List<studentdto> FindAll() {
		String sqlQuery="Select id,student_name,student_address from studentdto order by id";
		try {
			List<studentdto> std=jdbctemp.query(sqlQuery,
					new StudentRowMapper());
			return std;
					
		} catch (Exception e) {
			log.error(e.getMessage());
			return null;
		}
	}

}
