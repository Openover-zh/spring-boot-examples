package com.zhang;

import com.google.common.collect.Lists;
import com.zhang.dao.UserMapper;
import com.zhang.pojo.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

/**
 * @author zhangJiaHao
 * @date 2022/11/12 12:55
 */
@SpringBootTest(classes = ShardingSphereApplication.class)
@RunWith(SpringRunner.class)
public class User01 {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void test(){
        for (int i = 0; i <10 ; i++) {
            User user = new User();
            user.setId(i);
            user.setAge(12+i);
            user.setName("zhangsan"+i);
            user.setSex(i%2==0?"男":"女");
            userMapper.insert(user);
        }
    }

    @Test
    public void getInfo(){
        System.out.println(userMapper.getInfo(1));
    }

    @Test
    public void selectByIds(){
        ArrayList<Integer> ids = Lists.newArrayList(1,2,3,4,5,6);
        System.out.println(userMapper.selectByIds(ids));
    }
}
