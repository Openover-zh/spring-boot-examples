package com.zhang;

import com.zhang.dao.CustomerMapper;
import com.zhang.dao.OrderMapper;
import com.zhang.dao.TOrdersMapper;
import com.zhang.pojo.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhangJiaHao
 * @date 2022/11/12 16:29
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShardingSphereApplication.class)
public class OrdersDemo {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private TOrdersMapper tOrdersMapper;

    @Test
    public void insert(){
        for (int i = 0; i < 10 ; i++) {
            Order order = new Order();
            order.setId(i);
            order.setOrderId(i+1);
            order.setName("zhang"+i);
            orderMapper.insert(order);
        }
    }

    @Test
    public void getInfo(){
        System.out.println(orderMapper.getInfo(1, 2));
    }

    @Test
    public void insertCustomer(){
        for (int i = 1; i <= 10 ; i++) {
//            Customer customer = new Customer();
//            customer.setId(i);
//            customer.setName("zhang"+i);
//            customer.setType(""+i);
//            customerMapper.insert(customer);
            T_Orders t_orders = new T_Orders();
            t_orders.setId(i);
            t_orders.setName("zhang"+i);
            tOrdersMapper.insert(t_orders);
        }
    }

    @Test
    public void select(){
        System.out.println(tOrdersMapper.selectById(1));
        System.out.println(customerMapper.selectById(1));
    }

    @Test
    public void insertOrderDic(){
        for (int i = 1; i <= 10 ; i++) {
            OrderDic orderDic = new OrderDic();
            orderDic.setId(i);
            orderDic.setName("zhang"+i);
            orderDic.setType(""+i);
            orderMapper.insertOrderDic(orderDic);
        }
    }

    @Test
    public void insertOrderItem(){
        for (int i = 1; i <=10 ; i++) {
            T_Orders t_orders = new T_Orders();
            t_orders.setId(i);
            t_orders.setName("zhang"+i);
            tOrdersMapper.insert(t_orders);
            OrderItem orderItem = new OrderItem();
            orderItem.setId(i);
            orderItem.setOrderId(i);
            orderItem.setName("zhang"+i);
            orderMapper.insertOrderItem(orderItem);

        }
    }

    @Test
    public void selectByOrderId(){
        System.out.println(orderMapper.selectOrderAndItem(1));
    }
}
