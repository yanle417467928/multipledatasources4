package com.mzd.multipledatasources.controller;

import com.mzd.multipledatasources.bean.Clazz;
import com.mzd.multipledatasources.bean.Student;
import com.mzd.multipledatasources.service.clazz.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/class")
public class ClazzController {

    @Autowired
    private ClazzService clazzService;


    @RequestMapping("/save")
    public String save() {
        Clazz clazz = new Clazz();
        clazz.setClassName("三年二班");
        clazzService.save(clazz);
        return "success";
    }


}
