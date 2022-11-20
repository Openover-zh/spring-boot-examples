package com.zhang.dao;

import com.zhang.pojo.User;
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
public interface UserMapper {
    @Insert("insert into users(id,name,age,sex) values (#{id},#{name},#{age},#{sex})")
    public void insert(User user);
    @Select("select * from users where id = #{id}")
    public User getInfo(Integer id);


    public List<User> selectByIds(@Param("ids") List<Integer> ids);
}
