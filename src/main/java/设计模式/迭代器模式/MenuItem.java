/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */
package 设计模式.迭代器模式;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/4/30
 */

public class MenuItem {
    private String name,desc;
    private boolean vegetable;
    private float price;

    public MenuItem(String name, String desc, boolean vegetable, float price) {
        this.name = name;
        this.desc = desc;
        this.vegetable = vegetable;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isVegetable() {
        return vegetable;
    }

    public void setVegetable(boolean vegetable) {
        this.vegetable = vegetable;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}