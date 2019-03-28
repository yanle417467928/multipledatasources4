package com.mzd.multipledatasources.service.teacher;

import com.mzd.multipledatasources.bean.Teacher;
import com.mzd.multipledatasources.dao.TeacherDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface TeacherService {

    public void save(Teacher t);

}
