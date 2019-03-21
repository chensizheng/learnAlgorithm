/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */
package 设计模式.装饰者.decorator;

import 设计模式.装饰者.Drink;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/3/21
 */

public class Chocolate  extends Decorator {
    public Chocolate(Drink obj) {
        super(obj);
        super.setDesc("Chocolate");
        super.setPrice(2.0f);
    }

}