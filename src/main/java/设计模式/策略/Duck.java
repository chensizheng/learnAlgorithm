/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */
package 设计模式.策略;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/3/21
 */

public abstract class Duck {
    FlyBehavior flyBehavior;
    SwimBehavior swimBehavior;
    public void fly() {
        flyBehavior.fly();
    }

    public void swim() {
        swimBehavior.swim();
    }

    public abstract void display();

    public Duck() {
    }

    /***
     * 策略模式的定义：分别封装行为接口，实现算法族，超类里放行为接口对象，在自类里具体设定行为对象；
     * 原则：分离变化部分，封装接口，基于接口编程各种功能，此模式让行为算法的变化独立于算法的使用者。
     */
}