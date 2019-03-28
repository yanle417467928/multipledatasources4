package com.mzd.multipledatasources.service.student.impl;

import com.mzd.multipledatasources.bean.Student;
import com.mzd.multipledatasources.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mzd.multipledatasources.dao.StudentDao;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Transactional
    public void save(Student t) {
        studentDao.save(t);
    }

}
