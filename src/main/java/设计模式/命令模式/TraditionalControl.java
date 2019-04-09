/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */
package 设计模式.命令模式;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/4/9
 */
//传统模式
public class TraditionalControl implements Control {
    private Light light;
    private Stereo stereo;

    public TraditionalControl(Light light,Stereo stereo){
        this.light = light;
        this.stereo = stereo;
    }

    @Override
    public void onButton(int slot) {
        switch (slot){
            case 0:
                light.On();
            case 1:
                stereo.On();
            case 2:
                int vol= stereo.getVol();
                if(vol<20) {  //假设最高音量20
                    stereo.setVol(++vol);
                }
                break;
        }
    }

    @Override
    public void offButton(int slot) {
        switch (slot){
            case 0:
                light.Off();
            case 1:
                stereo.Off();
            case 2:
                int vol= stereo.getVol();
                if(vol>0) {
                    stereo.setVol(--vol);
                }
                break;
        }
    }
}