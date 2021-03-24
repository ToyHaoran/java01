package com.test;

class Animal {
    //成员变量:编译和运行时都看左边 Fu f=new Zi();
    int num=2;
    //同理，静态方法和静态属性都只看左边，不依赖对象,直接fu.xxxx
    static void method(){
        System.out.println("fu");
    }
    //成员|虚拟方法，唯一作用是骗过编译器，编译看左边,运行看右边(依赖对象) Fu f=new Cat()
    public void voice() {
        System.out.println("动物"+num);
    }
}

class Cat extends Animal {
    int num=3;// 属性无多态性，无覆盖操作，只能共存；
    public void voice() {//若不定义,则去寻找父类方法.
        System.out.println("喵喵喵"+num);
    }
    static void method(){
        System.out.println("zi");
    }
    public void function(){
        System.out.println("卖萌");
    }
}

class Dog extends Animal {
    int num=4;
    public void voice() {
        System.out.println("汪汪汪汪"+num);
    }
    public void function(){
        System.out.println("看门");
    }
}

public class TestPolymorphism {
    //优点：方法可接收任意Animal及子类对象，兼容性提高了; 前提:必须要有关系、继承、覆盖。
    public static void testVoice(Animal c) {
        if (c instanceof Dog) {
            ((Dog) c).function(); //需要先判断，后造型，调用子类特有方法  (类似 基本类型向下强转)
            //Cat a = (Cat)c;//ClassCastException(本质是狗和动物不能转成猫).
        }
    }

    public static void main(String[] args) {
        //自动类型提升(限制了对特有功能的访问)
        Animal dog = new Dog();
        Animal cat = new Cat();
        //虚拟方法调用 运行时看右边
        dog.voice();//汪汪汪汪4
        testVoice(dog);//汪汪汪汪4 本类方法
        testVoice(cat);//无

        //静态方法调用，都看左边
        Animal.method(); //=c.method(); fu

        //多态数组，可容纳不同类型的子类对象
        Animal[] arr = new Animal[]{new Animal(), cat, dog};
        for(Animal a : arr){
            System.out.print(a.num+":"); //全部为2，属性无多态
            a.voice();
        }
    }
}