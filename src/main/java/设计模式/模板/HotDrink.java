/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */
package 设计模式.模板;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/3/21
 */

public abstract class HotDrink {
    public final void prepareRecipe(){
        boilWatter();
        brew();
        pourInCup();
        addComm();
    }
    private final void boilWatter(){
        System.out.println("烧水");
    }
    public abstract void brew();
    private final void pourInCup(){
        System.out.println("倒进杯子");
    }
    public abstract void addComm();


    // final的意思是，父类里的基础操作（烧水、倒进杯子、步骤）是固定的，不能被子类覆盖和修改了
}