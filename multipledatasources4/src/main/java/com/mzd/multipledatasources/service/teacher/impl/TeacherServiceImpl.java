package com.mzd.multipledatasources.service.teacher.impl;

import com.mzd.multipledatasources.service.teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mzd.multipledatasources.bean.Teacher;
import com.mzd.multipledatasources.dao.TeacherDao;

@Service
public class TeacherServiceImpl implements TeacherService {
	@Autowired
	private TeacherDao teacherDao;

	@Transactional
	public void save(Teacher t) {
		teacherDao.save(t);
	}

}
