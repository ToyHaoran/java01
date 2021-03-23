package com.test;

import java.util.Random; //也是随机数工具 Random rand = new Random();  rand.nextInt(30);

public class TestMath {
    public static void main(String[] args) {
        // Math就是一个专门进行数学计算的操作类，里面提供了一系列的数学计算方法（例如：对数、绝对值、幂运算等）。
        // 在Math类里面提供的一切方法都是static型的方法，所以可以直接由类名称进行调用。
        for (int i = 0; i < 100; i++) {
            double rand1 = Math.random(); // [0,1)的随机浮点数
            int rand2 = (int)(Math.random()*81)+20; // [20,100]之间的随机整数
            System.out.println(rand2);
        }
        System.out.println(Math.round(15.5)); // 16 返回四舍五入的整数
        System.out.println(Math.round(-15.5)); // -15
        System.out.println(Math.round(-15.51)); // -16


    }
}