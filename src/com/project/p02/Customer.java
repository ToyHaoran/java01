package com.project.p02;

public class Customer {

    private String name ;//客户姓名
    private char gender ;//性别
    private int age     ;//年龄
    private String phone;//电话号码
    private String email;//电子邮箱

    public Customer() {

    }

    public Customer(String name,
                    char gender,
                    int age,
                    String phone,
                    String email) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public char getGender() {
        return gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String say() {
        return name + "\t" + gender + "\t" + age + "\t" + phone + "\t" + email;
    }
}