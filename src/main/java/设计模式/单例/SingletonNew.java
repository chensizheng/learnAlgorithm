/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */
package 设计模式.单例;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/3/22
 */

public class SingletonNew {
    public volatile static SingletonNew instance = null;

    private SingletonNew(){}
    public static SingletonNew getInstance(){
        if (instance == null){
            synchronized (SingletonNew.class){
                if (instance == null){
                    return new SingletonNew();
                }
            }
        }
        return instance;
    }
}