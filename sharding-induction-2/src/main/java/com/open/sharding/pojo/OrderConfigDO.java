package com.open.sharding.pojo;

import lombok.Data;

/**
 * @author liuxiaowei
 * @date 2022年10月09日 15:37
 * @Description
 */
@Data
public class OrderConfigDO {

    /**
     * 编号
     */
    private Integer id;

    /**
     * 支付超时时间
     * 单位：分钟
     */
    private Integer payTimeout;
}
