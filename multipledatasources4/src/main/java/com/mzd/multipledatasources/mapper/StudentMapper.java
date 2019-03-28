package com.mzd.multipledatasources.mapper;

import com.mzd.multipledatasources.bean.Student;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentMapper {

    void save(Student student);

}
