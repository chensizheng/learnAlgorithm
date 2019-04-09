/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */
package 设计模式.命令模式;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/4/9
 */
//灯
public class Light {
    String loc;
    public Light(String loc){
        this.loc = loc;
    }

    public void On(){
        System.out.println(loc + " On !");
    }

    public void Off(){
        System.out.println(loc + " Off !");
    }
}