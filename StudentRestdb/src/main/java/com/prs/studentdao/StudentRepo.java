package com.prs.studentdao;

import java.util.List;

import com.prs.student.model.studentdto;

public interface StudentRepo {
	public boolean AddStudent(studentdto newStudent);
	public boolean DeleteStudent(studentdto newStudent);
	public boolean Modify(studentdto newStudent);
	public studentdto Find(long studentid);
	public List<studentdto> FindAll();
}
