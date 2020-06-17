package com.yellowgg.everyday.entity;

import com.yellowgg.everyday.entity.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Description:linux命令
 * @Author: yellowgg
 * @Date: Created in 2020/6/17 21:52
 */
@Getter
@Setter
@ToString
public class LinuxCommand extends BaseEntity {
    private String name;

    private String url;
}