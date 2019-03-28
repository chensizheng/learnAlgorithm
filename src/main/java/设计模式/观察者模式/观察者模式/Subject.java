/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */
package 设计模式.观察者模式.观察者模式;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/3/28
 */

public interface Subject {
    void regiterObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObserver();

}