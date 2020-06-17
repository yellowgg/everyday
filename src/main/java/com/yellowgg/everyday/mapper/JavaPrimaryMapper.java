package com.yellowgg.everyday.mapper;

import com.yellowgg.everyday.entity.JavaPrimary;

/**
 * @Description:
 * @Author: yellowgg
 * @Date: Created in 2020/6/17 13:12
 */
public interface JavaPrimaryMapper {

    int deleteByPrimaryKey(Long id);

    int insert(JavaPrimary record);

    int insertSelective(JavaPrimary record);

    JavaPrimary selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(JavaPrimary record);

    int updateByPrimaryKey(JavaPrimary record);
}