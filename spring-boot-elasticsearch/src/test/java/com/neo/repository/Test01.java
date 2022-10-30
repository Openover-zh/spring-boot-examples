package com.neo.repository;

import com.neo.pojo.HashSetDemo;
import com.neo.pojo.Student;
import com.neo.pojo.User;
import org.junit.Test;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.BitSet;
import java.util.HashSet;
import java.util.List;
import java.util.Vector;

public class Test01 {
    @Test
    public void test01(){
        HashSetDemo<String> setDemo = new HashSetDemo<>();
        setDemo.addAll(List.of("1","2","3"));
        Vector<String> strings = new Vector<>();
    }
}
