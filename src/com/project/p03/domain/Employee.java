package com.project.p03.domain;

public class Employee {

    private int id; // : //
    private String name; // 姓名
    private int age; // : int // 年龄
    private double salary; // : // 工资

    public Employee() {
    }

    public Employee(int id, String name, int age, double salary) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return say();
    }

    public String say() {
        return id + "\t" + name + "\t" + age + "\t" + salary;
    }

}