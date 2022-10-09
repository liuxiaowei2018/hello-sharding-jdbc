package com.open.sharding.service;

import com.open.sharding.mapper.OrderMapper;
import com.open.sharding.pojo.OrderDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author liuxiaowei
 * @date 2022年10月09日 15:17
 * @Description
 */
@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Transactional
    public void add(OrderDO order) {
        // <1.1> 读取从库
        OrderDO exists = orderMapper.selectById(1);
        System.out.println(exists);

        // <1.2> 插入订单
        orderMapper.insert(order);

        // <1.3> 读取主库
        exists = orderMapper.selectById(1);
        // Sharding-JDBC 中，读写分离约定：同一线程且同一数据库连接内，如有写入操作，以后的读操作均从主库读取，用于保证数据一致性。
        System.out.println(exists);
    }

    public OrderDO findById(Integer id) {
        return orderMapper.selectById(id);
    }

}
