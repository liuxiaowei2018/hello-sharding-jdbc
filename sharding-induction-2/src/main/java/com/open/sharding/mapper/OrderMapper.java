package com.open.sharding.mapper;

import com.open.sharding.pojo.OrderDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liuxiaowei
 * @date 2022年10月09日 15:39
 * @Description
 */
@Repository
public interface OrderMapper {

    OrderDO selectById(@Param("id") Integer id);

    List<OrderDO> selectListByUserId(@Param("userId") Integer userId);

    void insert(OrderDO order);

}
