package 设计模式.状态模式.模式;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/5/13
 */

public interface State {
    void insertCoin();
    void returnCoin();
    void turnCrank();
    void dispense();
    void printState();
}
