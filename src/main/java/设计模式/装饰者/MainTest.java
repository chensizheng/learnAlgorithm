/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */
package 设计模式.装饰者;

import 设计模式.装饰者.coffee.Espresso;
import 设计模式.装饰者.decorator.Chocolate;
import 设计模式.装饰者.decorator.Milk;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/3/21
 */

public class MainTest {

    public static void main(String[] args) {
        Espresso espresso = new Espresso();
        Milk espressoWithmilk = new Milk(espresso);
        Milk espressoWithmilkWithmilk = new Milk(espressoWithmilk);
        Chocolate espressoWithmilkWithmilkWithchocolate = new Chocolate(espressoWithmilkWithmilk);
        System.out.println(espressoWithmilkWithmilkWithchocolate.getDesc());
        System.out.println(espressoWithmilkWithmilkWithchocolate.cost());

    }

}