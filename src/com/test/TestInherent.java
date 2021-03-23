package com.test;

public class TestInherent {
    public static void main(String[] args) {
        Zi zi = new Zi();
    }
}

class Fu {
    static {
        //1.1 静态代码块优先执行(随着类的加载而加载)
        System.out.println("静态代码块Fu");
    }

    int num = 7;
    {
        //2.3 构造代码块初始化
        num = 8;
        System.out.println("构造代码块Fu");
    }

    //2 入口
    public Fu() {
        //2.1 调用super()
        //2.2 显示初始化
        //2.3 构造代码块初始化
        //2.4 执行父类构造方法
        System.out.println("构造方法Fu");
    }
}

class Zi extends Fu {
    static {
        //1.2 静态代码块优先执行
        System.out.println("静态代码块Zi");
    }

    //3 显示初始化
    int num = 9;
    {
        //4 构造代码块初始化
        num = 10;
        System.out.println("构造代码块Zi");
    }

    //2 入口
    public Zi() {
        //2 调用super();
        //3 显示初始化 num = 9;
        //4 构造代码块初始化 num = 10;
        //5 执行子类构造方法
        System.out.println("构造方法Zi:"+num);
    }
}
