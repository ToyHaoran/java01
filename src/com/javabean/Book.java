package com.javabean;

public class Book{
    private String title;
    private double price;

    public Book() {}  //最重要，JavaBean规范 子类会默认用到它，便于反射

    public Book(String title) {
        this(title, 99.9);
        //1 this(...)必须放在首行，防止落下父类构造器；this调用属性和方法时;先从本类查找,没有就会去查找父类.
        //2 必须有一个不含this(...)语句，防止无限递归
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
    @Override
    public String toString() {
        return "书名：" + this.title + "，价格：" + this.price;
    }

    //对象的比较，比较对象的内容 (Obj中默认是==)
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }else if (this == obj) {
            return true; //地址相同
        }else if(obj instanceof Book){
            Book book = (Book) obj;
            return this.title.equals(book.title) && this.price == book.price;
        }else{
            return false;
        }
    }

    //哈希码 特征码：根据对象内容计算出的数字 (Obj中根据物理地址计算，是不同的)
    @Override
    public int hashCode(){
        char[] str = (this.title+this.price).toCharArray();
        int sum = 0;
        for(char c:str){
            sum += c+2;
        }
        return sum;
    }
}
