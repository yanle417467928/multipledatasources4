package com.mzd.multipledatasources.mapper;

import org.springframework.stereotype.Repository;

import com.mzd.multipledatasources.bean.Teacher;

@Repository
public interface TeacherMapper {

	void save(Teacher t);

}
