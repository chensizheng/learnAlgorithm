/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */
package 设计模式.状态模式;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/5/13
 */

//传统实现
public class CandyMachine {
    final static int SoldOutState = 0;
    final static int OnReadyState = 1;
    final static int HasCoin = 2;
    final static int SoldState = 3;

    //现在的状态
    private int state = SoldOutState;
    //糖果数量
    private int count = 0;

    public CandyMachine(int count) {
        this.count = count;
        if (count>0){
            state = OnReadyState;
        }
    }

    public void insertCoin() {
        switch (state){
            case SoldOutState:
                System.out.println("无法投币，已售罄！");
                break;
            case OnReadyState:
                state = HasCoin;
                System.out.println("投币成功，请转动转盘！");
                break;
            case HasCoin:
                System.out.println("已投币，请勿重复投币！");
                break;
            case SoldState:
                System.out.println("请等待，正在为您准备糖果，期间请勿投入硬币！");
                break;
        }
    }

    public void returnCoin() {
        switch (state){
            case SoldOutState:
                System.out.println("勿瞎操作！");
                break;
            case OnReadyState:
                System.out.println("勿瞎操作！");
                break;
            case HasCoin:
                System.out.println("已退币！");
                state = OnReadyState;
                break;
            case SoldState:
                System.out.println("勿瞎操作,正在出糖果！");
                break;
        }
    }

    public void turnCrank() {
        switch (state){
            case SoldOutState:
                System.out.println("卖光了！");
                break;
            case OnReadyState:
                System.out.println("未投入硬币！");
                break;
            case HasCoin:
                System.out.println("正在转动！");
                state = SoldState;
                dispense();
                break;
            case SoldState:
                System.out.println("正在出糖果！");
                break;
        }
    }


    public void dispense() {
        System.out.println("请取走糖果");
        if(count -- >0){
            state = OnReadyState;
        }else {
            state =SoldOutState;
        }


    }

    public void printStat() {
        switch (state){
            case SoldOutState:
                System.out.println("SoldOutState！");
                break;
            case OnReadyState:
                System.out.println("OnReadyState！");
                break;
            case HasCoin:
                System.out.println("HasCoin！");
                break;
            case SoldState:
                System.out.println("SoldState！");
                break;
        }
    }
}