package com.yellowgg.everyday.entity.base;

import com.yellowgg.everyday.constant.UtilConstants;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;


/**
 * @Description: 实体类父类
 * @Author:yellowgg
 * @Date: Created in 2020/6/17 13:03
 */
@Data
@AllArgsConstructor
public class BaseEntity {
    private Long id;
    private LocalDateTime gmtCreate;
    /**
     * 软删除 （0：未删除 1：已删除）
     */
    private Integer deleted;

    public BaseEntity() {
        /**
         * 去掉后面的毫秒值
         */
        setGmtCreate(LocalDateTime.now().withNano(UtilConstants.Number.ZERO));
        setDeleted(UtilConstants.Number.ZERO);
    }
}
