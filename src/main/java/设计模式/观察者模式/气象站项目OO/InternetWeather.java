/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */
package 设计模式.观察者模式.气象站项目OO;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/3/22
 */

public class InternetWeather {
    public static void main(String[] args) {
        CurrentConditions currentConditions = new CurrentConditions();
        WeatherData weatherData = new WeatherData(currentConditions);

        weatherData.setData(1,2,3);
        weatherData.setData(2,3,4);

    }

}