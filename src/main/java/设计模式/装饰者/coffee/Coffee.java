/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */
package 设计模式.装饰者.coffee;

import 设计模式.装饰者.Drink;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/3/21
 */

public class Coffee extends Drink {

    @Override
    public float cost() {
        return super.getPrice();
    }

    @Override
    public String getDesc() {
        return super.getDesc() +"-"+ super.getPrice();
    }
}