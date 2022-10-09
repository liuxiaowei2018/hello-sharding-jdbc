package com.open.sharding.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author liuxiaowei
 * @date 2022年10月09日 15:08
 * @Description
 */
@Data
@TableName(value = "orders")
public class OrderDO {

    /**
     * 订单编号
     */
    private Long id;

    /**
     * 用户编号
     */
    private Integer userId;

}

