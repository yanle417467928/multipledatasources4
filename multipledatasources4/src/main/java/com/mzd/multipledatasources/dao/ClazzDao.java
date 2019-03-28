package com.mzd.multipledatasources.dao;

import com.mzd.multipledatasources.bean.Clazz;
import com.mzd.multipledatasources.bean.Student;
import com.mzd.multipledatasources.mapper.ClazzMapper;
import com.mzd.multipledatasources.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class ClazzDao {

    @Autowired
    private ClazzMapper clazzMapper;

    public void save(Clazz t) {
        clazzMapper.save(t);
    }

}
