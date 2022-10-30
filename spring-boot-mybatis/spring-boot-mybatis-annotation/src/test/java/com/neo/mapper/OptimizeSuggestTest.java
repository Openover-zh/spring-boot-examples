package com.neo.mapper;

import com.neo.MybatisAnnotationApplication;
import com.neo.model.OptimizeSuggest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author zhangJiaHao
 * @date 2022/8/12 17:12
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class OptimizeSuggestTest {
    @Autowired
    private OptimizeSuggestMapper optimizeSuggestMapper;

    @Test
    public void test(){
        List<OptimizeSuggest> optimizeSuggest = optimizeSuggestMapper.getById(1);
        if (optimizeSuggest==null){
            System.out.println("--------");
        }
        System.out.println(optimizeSuggest);

    }
}
