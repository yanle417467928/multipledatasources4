package com.mzd.multipledatasources.datasource;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.mzd.multipledatasources.datasource.DataSourceType.DataBaseType;

@Aspect
@Component
public class DataSourceAop {
    @Before("execution(* com.mzd.multipledatasources.service.student..*.*(..))")
    public void setDataSource2Student() {
        System.err.println("student业务");
        DataSourceType.setDataBaseType(DataBaseType.STUDENT);
    }

    @Before("execution(* com.mzd.multipledatasources.service.teacher..*.*(..))")
    public void setDataSource2Teacher() {
        System.err.println("teacher业务");
        DataSourceType.setDataBaseType(DataBaseType.TEACHER);
    }

    @Before("execution(* com.mzd.multipledatasources.service.clazz..*.*(..))")
    public void setDataSource2Class() {
        System.err.println("class业务");
        DataSourceType.setDataBaseType(DataBaseType.CLASS);
    }
}
