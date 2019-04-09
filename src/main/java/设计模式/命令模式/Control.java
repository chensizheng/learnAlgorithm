package 设计模式.命令模式;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/4/9
 */

public interface Control {
    void onButton(int slot);
    void offButton(int slot);
}
