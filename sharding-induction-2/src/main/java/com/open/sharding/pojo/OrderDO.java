package com.open.sharding.pojo;

import lombok.Data;

/**
 * @author liuxiaowei
 * @date 2022年10月09日 15:38
 * @Description
 */
@Data
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
