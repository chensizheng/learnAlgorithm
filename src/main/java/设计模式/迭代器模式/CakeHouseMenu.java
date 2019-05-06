/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */
package 设计模式.迭代器模式;

import java.awt.*;
import java.util.ArrayList;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/5/5
 */

public class CakeHouseMenu {
    private ArrayList<MenuItem> menuItems;

    public CakeHouseMenu() {
        menuItems = new ArrayList<>();
        addItem("KFC","eggs",false,2.34f);
        addItem("MDL","strawberry",true,2.34f);
    }

    public void addItem(String name,String desc,boolean vegetable, float price){
        MenuItem menuItem = new MenuItem(name, desc, vegetable, price);
        menuItems.add(menuItem);
    }

    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }
}