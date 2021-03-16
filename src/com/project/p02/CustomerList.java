package com.project.p02;

/**
 * 这个类用于Customer对象的管理,
 * 内部使用一个Customer对象类型的数组作为属性
 * 并使用这个数组作为Customer对象的存储
 * 它是对象的管理模块,并且提供多个方法,供CustomerView
 * 调用,也可以说它是一个服务模块,提供底层的数据支持服务
 */
public class CustomerList {

    private Customer[] customers;	// 用来保存客户对象的数组, 结构良好的数组
    private int realCount = 0;		// 记录已保存客户对象的数量

    /**
     * 	用途：构造器，用来初始化customers数组
     * 	参数：totalCount：指定customers数组的最大空间
     */
    public CustomerList(int totalCount) {
        this.customers = new Customer[totalCount]; // 数组的长度由参数控制, 可以更加灵活.
    }

    /**
     * 	用途：将参数customer添加组中最后一个客户对象记录之后
     * 	参数：customer指定要添加的客户对象
     * 	返回：添加成功返回true；false表示数组已满，无法添加
     */
    public boolean addCustomer(Customer customer) {
        if (realCount == customers.length) { //if (数组已满) {
            grow();
            //return false;
        }
        // 把参数中的对象保存在数组中, 下标由计数器控制 // 调整计数器
        this.customers[realCount++] = customer; // 先用后加
        // 返回true
        return true;
    }

    private void grow() {
        System.out.println("要扩容了....");
        // 1) 创建新数组, 容量比原来大
        int newLen = customers.length * 3 / 2;
        if (newLen <= 1) {
            newLen = 2;
        }
        Customer[] newArr = new Customer[newLen];
        // 2) 依次把老数组中的所有元素复制到新数组中
        for (int i = 0; i < customers.length; i++) {
            newArr[i] = customers[i];
        }
        // 3) 老引用指向新数组
        customers = newArr;
    }

    /**
     * 	用途：返回数组中记录的所有客户对象
     * 	返回： Customer[] 数组中包含了当前所有客户对象，该数组长度与对象个数相同。
     * 	返回一个完美数组
     */
    public Customer[] getAllCustomers() {
        // 1) 创建新数组, 容量是计数器
        Customer[] newArr = new Customer[realCount];
        // 2) 依次把内部数组中所有有效对象保存在新数组中
        for (int i = 0; i < realCount; i++) {
            newArr[i] = this.customers[i];
        }
        // 3) 返回新数组
        return newArr;
    }

    /**
     * 	用途：返回参数index指定索引位置的客户对象记录
     * 	参数： index指定所要获取的客户对象在数组中的索引位置
     * 	返回：封装了客户信息的Customer对象
     */
    public Customer getCustomer(int index) {
        if (index < 0 || index >= realCount) { // if (下标不合法) {
            return null;
        }
        return this.customers[index];
    }

    /**
     * 	用途：从数组中删除参数index指定索引位置的客户对象记录
     * 	参数： index指定所删除对象在数组中的索引位置
     * 	返回：删除成功返回true；false表示索引无效，无法删除
     */
    public boolean deleteCustomer(int index) {
        if (index < 0 || index >= realCount) { // if (下标不合法) {
            return false;
        }
        // 1) 把要删除的下标位置处置为空洞
        customers[index] = null;
        // 2) 从要删除的下标位置开始, 依次把右侧相邻的元素复制到左边
        for (int i = index; i < realCount - 1; i++) {
            customers[i] = customers[i + 1];
        }
        // 3) 把之前的最有有效元素位置处置为空洞   4) 调整计数器
        customers[--realCount] = null; // 先减后用
        return true;
    }

}

