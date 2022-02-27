package com.ay.ayblog.dao;

import com.ay.ayblog.pojo.Article;

public interface ArticleMapper {

    /**
     *
     * @param articleId
     * @return
     */
    int deleteByPrimaryKey(Integer articleId);

    /**
     *
     * @param record
     * @return
     */
    int insert(Article record);

    /**
     *
     * @param record
     * @return
     */
    int insertSelective(Article record);

    /**
     *
     * @param articleId
     * @return
     */
    Article selectByPrimaryKey(Integer articleId);

    /**
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Article record);

    /**
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(Article record);
}