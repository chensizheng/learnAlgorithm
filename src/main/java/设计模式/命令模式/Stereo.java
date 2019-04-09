/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */
package 设计模式.命令模式;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/4/9
 */
//音响
public class Stereo {
    static int volume = 0;


    public void On(){
        System.out.println("Stereo On !");
    }

    public void Off(){
        System.out.println("Stereo Off !");
    }

    public void setCd(){
        System.out.println("Stereo setCd !");
    }

    public void setVol(int vol){
        volume = vol;
        System.out.println("Stereo volume =" + volume);
    }

    public int getVol() {
        return volume;
    }
}