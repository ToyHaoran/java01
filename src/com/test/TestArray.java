package com.test;

import com.javabean.Book;

import java.util.Arrays;

public class TestArray {
    public static void main(String[] args) {
        //1 数组属于引用类型，数组也是对象，数组元素相当于对象的成员变量，所有元素是同一类型；
        //静态初始化：在定义数组的同时就为数组元素分配空间并赋值。
        int[] arr1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        //动态初始化：数组声明且为数组元素分配空间与赋值的操作分开进行
        int[] arr2 = new int[9]; //2 数组长度不可修改
        for (int i = 0; i < 9; i++) {
            arr2[i] = (int)(Math.random()*100)+1; //赋值 [1,100]的随机整数
        }
        System.out.println("是否相等："+Arrays.equals(arr1, arr2));
        System.out.println("求平均值："+avg(arr1)); //可变参数

        //对象数组(动态初始化) (也可静态初始化)
        Book[] books = new Book[3];  //开辟了一个三个长度的对象数组，内容为null
        books[0] = new Book("Java", 79.8);
        books[1] = new Book("JSP", 69.8);
        books[2] = new Book("Android", 89.8);
        for (Book book : books) { //只读访问，安全
            System.out.println(book.toString());
        }

        //数组的复制：效率System.arraycopy > clone > Arrays.copyOf > for循环
        System.arraycopy(arr1, 0, arr2, 0, 9);
        arr1.clone(); //对象的clone需要implements Cloneable
        arr2 = Arrays.copyOf(arr1, 20); //扩容
        arr2 = Arrays.copyOf(arr1,4); //缩减
        arr2 = Arrays.copyOfRange(arr1,2,5); //求子数组

        //数组排序 从小到大 (字符串,按照字典顺序)
        Arrays.sort(arr1); //插入排序 47 快排 286 归并排序(连续性好)|快排
        System.out.println(Arrays.toString(arr1));
        //对象数组排序 implements Comparable<Book>  还可用Collections.sort(); 具体见集合
        Arrays.sort(books); //升序排列

        //二维数组：数组中装的是数组
        int[][] arr5 = new int[3][]; //三个数组 或直接int[3][4]
        arr5[0] = new int[3]; arr5[1] = new int[]{1,2,3,4}; arr5[2] = new int[6];
        int[][] arr6 = new int[][]{{3,8,2},{2,7},{9,0,1,6}};
        System.out.println(arr5[1][2]+arr6[1][1]);

    }

    //编译器直接avg(new int[]{5,9}) 可变参数只允许有一个，且必须放在末尾
    public static int avg(int... values){
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum/ values.length;
    }
}
