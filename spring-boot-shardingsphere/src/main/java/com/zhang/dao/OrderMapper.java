package com.zhang.dao;

import com.zhang.pojo.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhangJiaHao
 * @date 2022/11/12 11:14
 */
@Mapper
@Repository
public interface OrderMapper {
    @Insert("insert into orders(id,name,order_id) values (#{id},#{name},#{orderId})")
    public void insert(Order order);
    @Select("select * from orders where id = #{id} and order_id = #{orderId}")
    public Order getInfo(@Param("id") Integer id,@Param("orderId") Integer orderId);

    @Insert("insert into order_dic(id,name,type) values (#{id},#{name},#{type})")
    void insertOrderDic(OrderDic orderDic);

    @Insert("insert into t_order_item(id,name,order_id) values (#{id},#{name},#{orderId})")
    void insertOrderItem(OrderItem orderItem);

    @Select("select o1.* from t_order o1 left join t_order_item o2 on o1.id = o2.order_id where o1.id = #{orderId}")
    T_Orders selectOrderAndItem(Integer orderId);
}
