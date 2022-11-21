package com.example;

import com.example.service.Impl.LogServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhangJiaHao
 * @date 2022/11/20 17:54
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AopApplication.class)
public class Test01 {

    @Autowired
    private LogServiceImpl logServiceImpl;

    @Test
    public void test(){
        logServiceImpl.getLogInfo("zhang");
    }
}
