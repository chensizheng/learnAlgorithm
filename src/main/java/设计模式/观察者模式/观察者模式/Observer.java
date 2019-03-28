package 设计模式.观察者模式.观察者模式;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/3/28
 */

public interface Observer {
    void update(float mTemperature,float mPressure,float mHumidity);
}
