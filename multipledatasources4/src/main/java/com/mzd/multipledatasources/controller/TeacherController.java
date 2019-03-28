package com.mzd.multipledatasources.controller;

import com.mzd.multipledatasources.bean.Teacher;
import com.mzd.multipledatasources.service.teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/save")
    public String save() {
        Teacher teacher = new Teacher();
        teacher.setTeacherName("张秀容");
        teacher.setClassId(1L);
        teacherService.save(teacher);
        return "success";
    }


}
