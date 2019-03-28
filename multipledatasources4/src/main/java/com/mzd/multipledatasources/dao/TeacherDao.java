package com.mzd.multipledatasources.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mzd.multipledatasources.bean.Teacher;
import com.mzd.multipledatasources.mapper.TeacherMapper;
import org.springframework.stereotype.Repository;

@Repository
public class TeacherDao {
	@Autowired
	private TeacherMapper teacherMapper;

	public void save(Teacher t) {
		teacherMapper.save(t);
	}

}
