package com.mzd.multipledatasources.dao;

import com.mzd.multipledatasources.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mzd.multipledatasources.mapper.StudentMapper;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {

    @Autowired
    private StudentMapper studentMapper;

    public void save(Student t) {
        studentMapper.save(t);
    }

}
