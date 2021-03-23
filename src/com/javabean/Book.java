package com.javabean;

public class Book implements Comparable<Book>{
    private String title;
    private double price;

    //构造方法
    public Book() {  //最重要，JavaBean规范 子类会默认用到它，便于反射
    }

    public Book(String title) {
        this(title, 99.9);
        //1 this(...)必须放在首行，防止落下父类构造器；this调用属性和方法时;先从本类查找,没有就会去查找父类. 2 必须有一个不含this(...)语句，防止无限递归
    }

    //构造器重载，参数列表必须不同
    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    //可设置价格上下限，起到保护作用
    public void setPrice(double price) {
        if (price < 0 || price > 9999) {
            return;
        }
        this.price = price;
    }

    //取得对象完整信息的方法
    public String getInfo() {
        return "书名：" + this.title + "，价格：" + this.price;
    }

    //表示当前对象
    public void print() {
        System.out.println("this = " + this);// this指向调用当前方法的对象
    }

    //对象的比较(重写equals)
    public boolean compare(Book book) {
        if (book == null) {
            return false;
        }
        if (this == book) {
            return true; //地址相同
        }
        if (this.title.equals(book.title) && this.price == book.price) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(Book o) {
        int res = Double.compare(this.price,o.price);
        if(res==0){
            return this.title.compareTo(o.title); //比较字符串
        }else{
            return res;
        }
    }
}
