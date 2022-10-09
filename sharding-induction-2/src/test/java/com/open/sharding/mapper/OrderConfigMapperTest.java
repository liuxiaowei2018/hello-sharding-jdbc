package com.open.sharding.mapper;

import com.open.sharding.HelloShardingJdbcApplication;
import com.open.sharding.pojo.OrderConfigDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author liuxiaowei
 * @date 2022年10月09日 15:46
 * @Description
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HelloShardingJdbcApplication.class)
public class OrderConfigMapperTest {

    @Autowired
    private OrderConfigMapper orderConfigMapper;

    @Test
    public void testSelectById() {
        OrderConfigDO orderConfig = orderConfigMapper.selectById(1);
        System.out.println(orderConfig);
    }

}