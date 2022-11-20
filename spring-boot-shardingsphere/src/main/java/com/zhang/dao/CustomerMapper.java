package com.zhang.dao;

import com.zhang.pojo.Customer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author zhangJiaHao
 * @date 2022/11/13 17:07
 */
@Mapper
public interface CustomerMapper {
    @Insert("insert into customer(id,name,type) values(#{id},#{name},#{type})")
    void insert(Customer customer);

    @Select("select * from customer where id = #{id}")
    Customer selectById(Integer id);
}
