package com.yellowgg.everyday.service;

import com.yellowgg.everyday.entity.LinuxCommand;
import com.yellowgg.everyday.mapper.LinuxCommandMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: yellowgg
 * @Date: Created in 2020/6/17 21:52
 */
@Service
public class LinuxCommandService {

    @Resource
    private LinuxCommandMapper linuxCommandMapper;


    public int deleteByPrimaryKey(Long id) {
        return linuxCommandMapper.deleteByPrimaryKey(id);
    }


    public int insert(LinuxCommand record) {
        return linuxCommandMapper.insert(record);
    }


    public int insertSelective(LinuxCommand record) {
        return linuxCommandMapper.insertSelective(record);
    }


    public LinuxCommand selectByPrimaryKey(Long id) {
        return linuxCommandMapper.selectByPrimaryKey(id);
    }


    public int updateByPrimaryKeySelective(LinuxCommand record) {
        return linuxCommandMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(LinuxCommand record) {
        return linuxCommandMapper.updateByPrimaryKey(record);
    }

    public LinuxCommand selectRandOne() {
        return linuxCommandMapper.selectRandOne();
    }
}
