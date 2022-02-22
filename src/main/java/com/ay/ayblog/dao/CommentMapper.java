package com.ay.ayblog.dao;

import com.ay.ayblog.pojo.Comment;

public interface CommentMapper {
    /**
     *
     * @param commentId
     * @return
     */
    int deleteByPrimaryKey(Integer commentId);

    /**
     *
     * @param record
     * @return
     */
    int insert(Comment record);

    /**
     *
     * @param record
     * @return
     */
    int insertSelective(Comment record);

    /**
     *
     * @param commentId
     * @return
     */
    Comment selectByPrimaryKey(Integer commentId);

    /**
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Comment record);

    /**
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(Comment record);
}