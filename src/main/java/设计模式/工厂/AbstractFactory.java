package 设计模式.工厂;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/3/22
 */

public interface AbstractFactory {
    public Pizza CreatePizza(String type);
}
