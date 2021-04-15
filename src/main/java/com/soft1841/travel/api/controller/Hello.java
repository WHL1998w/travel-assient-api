package com.soft1841.travel.api.controller;

/**
 * @ClassName
 * @Description TODO
 * @Author wanghuanle
 * @Date
 **/
public class Hello {
    public static void main(String[] args) {
        String a = "10";
        System.out.println("字符串转换为整数的结果为：" + Integer.parseInt(a));
        int c = Integer.parseInt(a);
        String b = "3";
        System.out.println("字符串转换为整数的结果为：" + Integer.parseInt(b));
        int d = Integer.parseInt(b);
        if (c >= d){
            System.out.println("不对");
        }
    }
}
