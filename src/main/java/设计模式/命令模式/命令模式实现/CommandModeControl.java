/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */
package 设计模式.命令模式.命令模式实现;

import 设计模式.命令模式.Control;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/4/9
 */

public class CommandModeControl implements Control {
    //两种按钮
    private Command[] onCommands;
    private Command[] offCommands;

    //定义有2列5行按钮
    public CommandModeControl(){
        onCommands = new Command[5];
        offCommands = new Command[5];
        NoCommand noCommand = new NoCommand();
        for (int i = 0; i <onCommands.length ; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }

    public void setCommand(int slot,Command onCommand,Command offCommand){
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }


    @Override
    public void onButton(int slot) {
        onCommands[slot].execute();
    }

    @Override
    public void offButton(int slot) {
        offCommands[slot].execute();
    }
}