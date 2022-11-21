package com.example.service.Impl;

import org.springframework.stereotype.Service;

/**
 * @author zhangJiaHao
 * @date 2022/11/20 17:53
 */
@Service("logServiceImpl")
public class LogServiceImpl {

    public String getLogInfo(String name){
//        int i  = 1/0;
        System.out.println("getLogInfo name is: "+name);
        return name;
    }

}
