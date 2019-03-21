/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */
package 设计模式.策略;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/3/21
 */

public class LongFly implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("fly a long ...");
    }
}