/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */
package 设计模式.观察者模式.观察者模式;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/3/22
 */

public class ForcastConditions implements Observer{
    private float mTemperature;
    private float mPressure;
    private float mHumidity;

    @Override
    public void update(float mTemperature,float mPressure,float mHumidity){
        this.mTemperature = mTemperature;
        this.mPressure = mPressure;
        this.mHumidity = mHumidity;
        display();
    }
    public void display(){
        System.out.println("ForcastConditions today:"+mTemperature+","+mPressure+","+mHumidity);
    }

}