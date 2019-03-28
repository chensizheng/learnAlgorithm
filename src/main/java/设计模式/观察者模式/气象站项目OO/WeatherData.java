/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */
package 设计模式.观察者模式.气象站项目OO;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/3/22
 */

public class WeatherData {
    private float mTemperature;
    private float mPressure;
    private float mHumidity;

    private CurrentConditions currentConditions;

    public WeatherData(CurrentConditions currentConditions){
        this.currentConditions = currentConditions;
    }

    public float getmTemperature() {
        return mTemperature;
    }

    public float getmPressure() {
        return mPressure;
    }

    public float getmHumidity() {
        return mHumidity;
    }
    public void dataChange(){
        currentConditions.update(getmTemperature(),getmPressure(),getmHumidity());
    }

    public void setData(float mTemperature,float mPressure,float mHumidity){
        this.mTemperature = mTemperature;
        this.mPressure = mPressure;
        this.mHumidity = mHumidity;
        dataChange();
    }
}