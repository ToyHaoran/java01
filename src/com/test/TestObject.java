package com.test;

import com.javabean.Book;

public class TestObject {
    public static void main(String args[]) {
        Book a = new Book("Java开发", 79.9);
        Book b = new Book("Java开发", 79.9);
        System.out.println(a.equals(b)); // true,若不覆写,比较的是对象地址,false
        System.out.println(b.hashCode()==a.hashCode()); //true; 若不覆写，false
        System.out.println(a); //等价 a.toString()
    }
}