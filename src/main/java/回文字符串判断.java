/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2018/12/27
 */

public class 回文字符串判断 {

    //判断是否是字母或数字
    private boolean isAlphanumeric(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')
                || (c >= '0' && c <= '9');
    }
    //判断两个字符忽略大小写是否相等
    private boolean isEqualIgnoreCase(char a, char b) {
        if (a >= 'A' && a <= 'Z') a += 32;
        if (b >= 'A' && b <= 'Z') b += 32;
        return a == b;
    }

    public boolean isParlindrome(String s){
        if(s == null || s.length() == 0) return true;
        int i=0,j=s.length()-1;
        for(;i<j;++i,--j){
            //如果i指向的字符不是数字或字母 i后移
            while (i < j && !isAlphanumeric(s.charAt(i))) ++i;
            //如果j指向的字符不是数字或字母 j前移
            while (i < j && !isAlphanumeric(s.charAt(j))) --j;
            if (i < j && !isEqualIgnoreCase(s.charAt(i), s.charAt(j))) return false;
        }
        return true;
    }

}