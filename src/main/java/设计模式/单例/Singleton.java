/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */
package 设计模式.单例;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/3/22
 */

// 经典单例，多线程有问题
public class Singleton {
    public static Singleton instance = null;

    private Singleton(){}
    public static Singleton getInstance(){
        if (instance == null){
            return new Singleton();
        }
        return instance;
    }

}