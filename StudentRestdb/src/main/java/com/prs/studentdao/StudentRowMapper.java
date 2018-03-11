package com.prs.studentdao;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;

import com.prs.student.model.studentdto;

public class StudentRowMapper implements RowMapper<studentdto> {

	@Override
	public studentdto mapRow(ResultSet row, int rownum) throws SQLException {
		if(rownum>=0) 
		{
			studentdto std = new studentdto(row.getLong(1),row.getString(2),row.getString(3));
			return std;}
		else
		{
			return null;
		}
	}

}
