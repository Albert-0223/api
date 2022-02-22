package com.ay.ayblog.dao;

import com.ay.ayblog.pojo.Label;

public interface LabelMapper {
    /**
     *
     * @param labelId
     * @return
     */
    int deleteByPrimaryKey(Integer labelId);

    /**
     *
     * @param record
     * @return
     */
    int insert(Label record);

    /**
     *
     * @param record
     * @return
     */
    int insertSelective(Label record);

    /**
     *
     * @param labelId
     * @return
     */
    Label selectByPrimaryKey(Integer labelId);

    /**
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Label record);

    /**
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(Label record);
}