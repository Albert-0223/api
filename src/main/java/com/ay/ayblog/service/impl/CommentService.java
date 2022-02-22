package com.ay.ayblog.service.impl;

import com.ay.ayblog.dao.CommentMapper;
import com.ay.ayblog.pojo.Comment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional(rollbackFor = Exception.class)
public class CommentService {
    @Resource
    private CommentMapper commentDao;

    public void insert(Comment comment){
        commentDao.insert(comment);
    }
}
