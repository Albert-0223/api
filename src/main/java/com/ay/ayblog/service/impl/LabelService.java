package com.ay.ayblog.service.impl;

import com.ay.ayblog.dao.LabelMapper;
import com.ay.ayblog.pojo.Label;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional(rollbackFor = Exception.class)
public class LabelService {
    @Resource
    private LabelMapper labelDao;

    public void insert(Label label){
        labelDao.insert(label);
    }
}
