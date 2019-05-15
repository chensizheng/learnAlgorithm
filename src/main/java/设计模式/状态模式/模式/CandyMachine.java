/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */
package 设计模式.状态模式.模式;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/5/13
 */

//传统实现
public class CandyMachine implements State{
    State mSoldOutState;
    State mOnReadyState;
    State mHasCoin;
    State MsoldState;
    State mWinnerState;
    private State state;
    private int count =0;

    @Override
    public void insertCoin() {
        state.insertCoin();
    }

    @Override
    public void returnCoin() {
        state.returnCoin();
    }

    @Override
    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    @Override
    public void dispense() {

    }

    @Override
    public void printState() {

    }
}