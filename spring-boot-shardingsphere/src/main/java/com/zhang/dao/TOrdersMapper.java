package com.zhang.dao;

import com.zhang.pojo.T_Orders;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zhangJiaHao
 * @date 2022/11/13 17:08
 */
@Mapper
public interface TOrdersMapper {
    @Insert("insert into t_order(id,name) values (#{id},#{name})")
    void insert(T_Orders t_orders);

    @Select("select * from t_orders where id = #{id}")
    T_Orders selectById(Integer id);


}
