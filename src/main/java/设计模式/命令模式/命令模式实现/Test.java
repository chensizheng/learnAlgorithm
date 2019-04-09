/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */
package 设计模式.命令模式.命令模式实现;

import 设计模式.命令模式.Light;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/4/9
 */

public class Test {
    public static void main(String[] args) {
        CommandModeControl control = new CommandModeControl();
        Light l1 = new Light("客厅灯");
        control.setCommand(0,new LightOnCommand(l1),new LightOffCommand(l1));

        Light l2 = new Light("卧室灯");
        control.setCommand(1,new LightOnCommand(l2),new LightOffCommand(l2));

        control.onButton(0);
        control.onButton(1);
        control.offButton(1);
        control.offButton(0);

    }
}