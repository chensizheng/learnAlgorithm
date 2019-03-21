/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */
package 设计模式.策略;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/3/21
 */

public class GreenHeadDuck extends Duck implements MyBehavior {

    @Override
    public void display() {
        System.out.println("i am green duck");
    }

    public GreenHeadDuck() {
//        flyBehavior = new ShortFly();
//        swimBehavior = new SlowSwim();
    }

    @Override
    public void my() {
        System.out.println("to be no.1");
    }
}