package com.mzd.multipledatasources.controller;

import com.mzd.multipledatasources.bean.Student;
import com.mzd.multipledatasources.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @RequestMapping("/save")
    public String save() {
        Student student = new Student();
        student.setClassId(1L);
        student.setStudentName("闫乐");
        student.setScore(100);
        studentService.save(student);
        return "success";
    }


}
