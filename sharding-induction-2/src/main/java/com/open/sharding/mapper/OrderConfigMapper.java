package com.open.sharding.mapper;

import com.open.sharding.pojo.OrderConfigDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author liuxiaowei
 * @date 2022年10月09日 15:39
 * @Description
 */
@Repository
public interface OrderConfigMapper {

    OrderConfigDO selectById(@Param("id") Integer id);

}
