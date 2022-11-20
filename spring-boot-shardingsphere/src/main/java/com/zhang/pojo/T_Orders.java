package com.zhang.pojo;

/**
 * @author zhangJiaHao
 * @date 2022/11/13 17:04
 */
public class T_Orders {
    private Integer id;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "T_Orders{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
