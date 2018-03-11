package com.prs.student.model;

public class studentdto {
	
	long id;
	String student_name;
	String student_address;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getStudent_address() {
		return student_address;
	}
	public void setStudent_address(String student_address) {
		this.student_address = student_address;
	}
	
	public studentdto() {
		super();
	}
	public studentdto(long id, String student_name, String student_address) {
		super();
		this.id = id;
		this.student_name = student_name;
		this.student_address = student_address;
	}
	
	

}
