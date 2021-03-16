package com.javabean;

public class Student{
    //成员变量|属性：系统会自动帮你初始化null,0,false；
    private String name; //放在常量池，引用变量
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //成员方法：方法只有值传递，方法内的局部变量必须初始化才能使用,如int a=10;
    public void getInfo(){
        System.out.println(name + age + "岁\n");
    }
}