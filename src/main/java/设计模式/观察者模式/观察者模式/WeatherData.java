/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */
package 设计模式.观察者模式.观察者模式;

import 设计模式.观察者模式.气象站项目OO.CurrentConditions;

import java.util.ArrayList;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/3/22
 */

public class WeatherData implements Subject{
    private float mTemperature;
    private float mPressure;
    private float mHumidity;

    private ArrayList<Observer> observers;

    public WeatherData(){
        this.observers = new ArrayList<>();
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
        notifyObserver();
    }

    public void setData(float mTemperature,float mPressure,float mHumidity){
        this.mTemperature = mTemperature;
        this.mPressure = mPressure;
        this.mHumidity = mHumidity;
        dataChange();
    }

    @Override
    public void regiterObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObserver() {
        observers.forEach(o ->
            o.update(getmTemperature(),getmPressure(),getmHumidity())
        );
    }
}