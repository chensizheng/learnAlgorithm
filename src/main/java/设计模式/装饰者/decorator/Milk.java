/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */
package 设计模式.装饰者.decorator;

import 设计模式.装饰者.Drink;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/3/21
 */

public class Milk extends Decorator {
    public Milk(Drink obj) {
        super(obj);
        super.setDesc("Milk");
        super.setPrice(1.0f);
    }
}