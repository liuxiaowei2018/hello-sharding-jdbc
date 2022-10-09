package com.open.sharding.mapper;

import com.open.sharding.HelloShardingJdbcApplication;
import com.open.sharding.pojo.OrderDO;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.hint.HintManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author liuxiaowei
 * @date 2022年10月09日 15:11
 * @Description
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HelloShardingJdbcApplication.class)
public class OrderMapperTest {

    @Autowired
    private OrderMapper orderMapper;

    /**
     * 测试从库的负载均衡
     * 1.默认情况下，Sharding-JDBC 使用 读写分离 功能时，读取从库。
     * 2.支持从库的负载均衡，默认采用轮询的算法
     * @date 2022/10/9 15:14
     */
    @Test
    public void testSelectById() {
        for (int i = 0; i < 2; i++) {
            OrderDO order = orderMapper.selectById(1);
            System.out.println(order);
        }
    }

    /**
     * 测试强制访问主库
     * 1.使用 HintManager 强制访问主库
     * 2.在使用完后，需要去清理下 HintManager （HintManager 是基于线程变量，透传给 Sharding-JDBC 的内部实现），避免污染下次请求，一直强制访问主库
     * 3.HintManager 实现了 AutoCloseable 接口，可以通过 Try-with-resources 机制，自动关闭
     * @date 2022/10/9 15:15
     */
    @Test
    public void testSelectById02() { //
        try (HintManager hintManager = HintManager.getInstance()) {
            // 设置强制访问主库
            hintManager.setMasterRouteOnly();
            // 执行查询
            OrderDO order = orderMapper.selectById(1);
            System.out.println(order);
        }
    }

    @Test
    public void testInsert() {
        OrderDO order = new OrderDO();
        order.setUserId(10);
        // 写入操作时，直接访问主库 ds-master 数据源
        orderMapper.insert(order);
    }


}