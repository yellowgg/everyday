package com.yellowgg.everyday.mapper;

import com.yellowgg.everyday.entity.LinuxCommand;

/**
 * @Description:
 * @Author: yellowgg
 * @Date: Created in 2020/6/17 21:52
 */
public interface LinuxCommandMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LinuxCommand record);

    int insertSelective(LinuxCommand record);

    LinuxCommand selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LinuxCommand record);

    int updateByPrimaryKey(LinuxCommand record);

    LinuxCommand selectRandOne();
}