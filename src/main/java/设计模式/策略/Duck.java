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
     * 策略模式的定义：分别封装行为接口，实现算法族，超类里放行为接口对象，在子类里具体设定行为对象；
     * 原则：分离变化部分，封装接口，基于接口编程各种功能，此模式让行为算法的变化独立于算法的使用者。
     *
     * 项目重构：
     * 1、分析项目中变化部分与不变化部分
     * 2、多用组合少用继承，用行为类组合，而不是行为的继承，更有弹性
     * 3、设计模式有没有相应的库直接使用？没有，设计模式是经验总结，方法论；有些库或者框架本身就用某种设计模式设计的
     */

}