package com.ay.ayblog.service.impl;

import com.ay.ayblog.dao.CategoryMapper;
import com.ay.ayblog.pojo.Category;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional(rollbackFor = Exception.class)
public class CategoryService {
    @Resource
    private CategoryMapper categoryDao;

    public void insert(Category category){
        categoryDao.insert(category);
    }
}
