package com.yellowgg.everyday.service;

import com.yellowgg.everyday.entity.JavaPrimary;
import com.yellowgg.everyday.mapper.JavaPrimaryMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/**
 * @Description:  
 * @Author: yellowgg
 * @Date: Created in 2020/6/17 13:12
 */
@Service
public class JavaPrimaryService{

    @Resource
    private JavaPrimaryMapper javaPrimaryMapper;

    
    public int deleteByPrimaryKey(Long id) {
        return javaPrimaryMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(JavaPrimary record) {
        return javaPrimaryMapper.insert(record);
    }

    
    public int insertSelective(JavaPrimary record) {
        return javaPrimaryMapper.insertSelective(record);
    }

    
    public JavaPrimary selectByPrimaryKey(Long id) {
        return javaPrimaryMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(JavaPrimary record) {
        return javaPrimaryMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(JavaPrimary record) {
        return javaPrimaryMapper.updateByPrimaryKey(record);
    }

}
