/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */
package 设计模式.模板;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/3/21
 */

public class Coofee extends HotDrink {

    @Override
    public void brew() {
        System.out.println("冲泡咖啡粉");
    }

    @Override
    public void addComm() {
        System.out.println("加糖和牛奶");
    }
}