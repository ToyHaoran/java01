package com.test;

class Animal {
    //成员变量:编译和运行时都看左边 Fu f=new Zi();为3,若不定义num,错误.
    int num=3;
    //成员|虚拟方法，唯一作用是骗过编译器，编译看左边,运行看右边(依赖对象) Fu f=new Cat()
    public void voice() {
        System.out.println("动物");
    }
    //静态方法(不涉及多态)都看左边:不依赖对象,直接fu.method().
    static void method(){
        System.out.println("fu");
    }
}

class Cat extends Animal {
    int num=4;// Zi z=new Zi(),为4,若不定义,为3
    public void voice() {//若不定义,则去寻找父类方法.
        System.out.println("喵喵");
    }
    static void method(){
        System.out.println("zi");
    }
}

class Dog extends Animal {
    public void voice() {
        System.out.println("汪汪汪");
    }
    public void seeDoor() {// 子类扩充父类方法
        System.out.println("看门");
    }
}

public class TestPolymorphism {
    /*
     * 好处:提高了代码的复用性,前期定义的代码可以使用后期的内容.
     * 弊端:前期定义的内容不能使用后期子类的特有内容(要向下转型).
     * 前提:必须要有关系,继承,实现.要有覆盖.
     */
    public static void TestVoice(Animal c) {
        c.voice();
        if (c instanceof Dog) {//判断c(引用)的具体类型
            ((Dog) c).seeDoor();//向下强转,调用子类特有方法
            //Cat a = (Cat)c;//ClassCastException(本质是狗和动物不能转成猫).
        }//否则输出错误
    }

    public static void main(String[] args) {
        Animal a = new Dog();//自动类型提升(限制了对特有功能的访问)
        Animal c = new Cat();
        a.voice();//虚拟方法调用 汪汪汪
        TestVoice(a);//汪汪汪    看门    本类方法
        TestVoice(c);//喵喵
        Animal.method();//=c.method(); 为fu
    }
}