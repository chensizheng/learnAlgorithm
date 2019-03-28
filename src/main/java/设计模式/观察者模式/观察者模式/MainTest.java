/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */
package 设计模式.观察者模式.观察者模式;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/3/28
 */

public class MainTest {
    public static void main(String[] args) {
        CurrentConditions currentConditions = new CurrentConditions();
        ForcastConditions forcastConditions = new ForcastConditions();
        WeatherData weatherData = new WeatherData();
        weatherData.regiterObserver(currentConditions);
        weatherData.regiterObserver(forcastConditions);
        weatherData.setData(1,2,3);
        weatherData.removeObserver(currentConditions);
        weatherData.setData(1,2,3);

    }
}