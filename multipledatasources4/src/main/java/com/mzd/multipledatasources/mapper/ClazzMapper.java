package com.mzd.multipledatasources.mapper;

import com.mzd.multipledatasources.bean.Clazz;
import com.mzd.multipledatasources.bean.Student;
import org.springframework.stereotype.Repository;


@Repository
public interface ClazzMapper {

    void save(Clazz clazz);

}
