/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */
package 设计模式.装饰者.coffee;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/3/21
 */

public class Espresso extends Coffee {

    public Espresso() {
        super.setDesc("Espresso");
        super.setPrice(4.0f);
    }
}