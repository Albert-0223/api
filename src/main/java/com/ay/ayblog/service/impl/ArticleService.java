package com.ay.ayblog.service.impl;

import com.ay.ayblog.dao.ArticleMapper;
import com.ay.ayblog.pojo.Article;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional(rollbackFor = Exception.class)
public class ArticleService {
    @Resource
    private ArticleMapper articleDao;

    public void insert(Article article){
        articleDao.insert(article);
    }





}
