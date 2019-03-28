package com.mzd.multipledatasources.service.clazz.impl;

import com.mzd.multipledatasources.bean.Clazz;
import com.mzd.multipledatasources.bean.Student;
import com.mzd.multipledatasources.dao.ClazzDao;
import com.mzd.multipledatasources.dao.StudentDao;
import com.mzd.multipledatasources.service.clazz.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClazzServiceImpl implements ClazzService {
    @Autowired
    private ClazzDao clazzDao;

    @Transactional
    public void save(Clazz t) {
        clazzDao.save(t);
    }

}
