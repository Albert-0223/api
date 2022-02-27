package com.ay.ayblog.dao;

import com.ay.ayblog.pojo.Category;

public interface CategoryMapper {
    /**
     *
     * @param categoryId
     * @return
     */
    int deleteByPrimaryKey(Integer categoryId);

    /**
     *
     * @param record
     * @return
     */
    int insert(Category record);

    /**
     *
     * @param record
     * @return
     */
    int insertSelective(Category record);

    /**
     *
     * @param categoryId
     * @return
     */
    Category selectByPrimaryKey(Integer categoryId);

    /**
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Category record);

    /**
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(Category record);
}