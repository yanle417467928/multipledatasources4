package com.mzd.multipledatasources.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Configuration
@MapperScan(basePackages = "com.mzd.multipledatasources.mapper", sqlSessionFactoryRef = "SqlSessionFactory")
public class DataSourceConfig {

    @Value("${spring.datasource.student.url}")
    private String studentUrl;

    @Value("${spring.datasource.student.username}")
    private String studentUser;

    @Value("${spring.datasource.student.password}")
    private String studentPassword;

    @Value("${spring.datasource.student.driverClassName}")
    private String studentDriverClass;


    @Value("${spring.datasource.teacher.url}")
    private String teacherUrl;

    @Value("${spring.datasource.teacher.username}")
    private String teacherUser;

    @Value("${spring.datasource.teacher.password}")
    private String teacherPassword;

    @Value("${spring.datasource.teacher.driverClassName}")
    private String teacherDriverClass;

    @Value("${spring.datasource.class.url}")
    private String classUrl;

    @Value("${spring.datasource.class.username}")
    private String classUser;

    @Value("${spring.datasource.class.password}")
    private String classPassword;

    @Value("${spring.datasource.class.driverClassName}")
    private String classDriverClass;


    /** druid配置 **/

    @Value("${spring.datasource.druid.initial-size}")
    private int initialSize;

    @Value("${spring.datasource.druid.max-active}")
    private int maxActive;

    @Value("${spring.datasource.druid.min-idle}")
    private int minIdle;

    @Value("${spring.datasource.druid.max-wait}")
    private int maxWait;

    @Value("${spring.datasource.druid.filters}")
    private String filters;


    @Primary
    @Bean(name = "studentDataSource",initMethod = "init",destroyMethod = "close")
    public DruidDataSource getDateSourceStudent() throws SQLException {
        DruidDataSource dataSourceStudent = new DruidDataSource();
        dataSourceStudent.setDriverClassName(studentDriverClass);
        dataSourceStudent.setUrl(studentUrl);
        dataSourceStudent.setUsername(studentUser);
        dataSourceStudent.setPassword(studentPassword);
        dataSourceStudent.setInitialSize(initialSize);
        dataSourceStudent.setMaxActive(maxActive);
        dataSourceStudent.setMinIdle(minIdle);
        dataSourceStudent.setMaxWait(maxWait);
        dataSourceStudent.setFilters(filters);
        return dataSourceStudent;
    }

    @Bean(name = "teacherDataSource",initMethod = "init",destroyMethod = "close")
    public DruidDataSource getDateSourceTeacher() throws SQLException {
        DruidDataSource dataSourceTeacher= new DruidDataSource();
        dataSourceTeacher.setDriverClassName(teacherDriverClass);
        dataSourceTeacher.setUrl(teacherUrl);
        dataSourceTeacher.setUsername(teacherUser);
        dataSourceTeacher.setPassword(teacherPassword);
        dataSourceTeacher.setInitialSize(initialSize);
        dataSourceTeacher.setMaxActive(maxActive);
        dataSourceTeacher.setMinIdle(minIdle);
        dataSourceTeacher.setMaxWait(maxWait);
        dataSourceTeacher.setFilters(filters);
        return dataSourceTeacher;
    }

    @Bean(name = "classDataSource",initMethod = "init",destroyMethod = "close")
    public DruidDataSource getDateSourceClass() throws SQLException {
        DruidDataSource dataSourceClass= new DruidDataSource();
        dataSourceClass.setDriverClassName(classDriverClass);
        dataSourceClass.setUrl(classUrl);
        dataSourceClass.setUsername(classUser);
        dataSourceClass.setPassword(classPassword);
        dataSourceClass.setInitialSize(initialSize);
        dataSourceClass.setMaxActive(maxActive);
        dataSourceClass.setMinIdle(minIdle);
        dataSourceClass.setMaxWait(maxWait);
        dataSourceClass.setFilters(filters);
        return dataSourceClass;
    }

    @Bean(name = "dynamicDataSource")
    public DynamicDataSource dynamicDataSource(@Qualifier("studentDataSource") DruidDataSource studentDataSource,
                                        @Qualifier("teacherDataSource") DruidDataSource teacherDataSource,
                                        @Qualifier("classDataSource") DruidDataSource classDataSource) {
        Map<Object, Object> targetDataSource = new HashMap<>();
        targetDataSource.put(DataSourceType.DataBaseType.STUDENT, studentDataSource);
        targetDataSource.put(DataSourceType.DataBaseType.TEACHER, teacherDataSource);
        targetDataSource.put(DataSourceType.DataBaseType.CLASS, classDataSource);
        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setTargetDataSources(targetDataSource);
        dataSource.setDefaultTargetDataSource(studentDataSource);
        return dataSource;
    }

    @Bean(name = "SqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dynamicDataSource") DynamicDataSource dynamicDataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dynamicDataSource);
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath*:mapping/*.xml"));
        return bean.getObject();
    }

}
