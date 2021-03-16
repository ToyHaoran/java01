package com.project.p02;

/**
 * 这个类是一个主类,主要用于系统的入口
 */
public class CustomerMain {

    public static void main(String[] args) {
        CustomerView customerView = new CustomerView();
        customerView.enterMainMenu();
    }

    public static void main2(String[] args) {
        Customer cust1 = new Customer("张一", '男', 10, "134234234", "zhang1@qq.com");
        Customer cust2 = new Customer("张二", '女', 20, "134234234", "zhang2@qq.com");
        Customer cust3 = new Customer("张三", '男', 30, "134234234", "zhang3@qq.com");
        Customer cust4 = new Customer("张四", '女', 40, "134234234", "zhang4@qq.com");
        Customer cust5 = new Customer("张五", '男', 50, "134234234", "zhang5@qq.com");
        Customer cust6 = new Customer("张六", '女', 60, "134234234", "zhang6@qq.com");
        Customer cust7 = new Customer("张七", '女', 70, "134234234", "zhang7@qq.com");
        Customer cust8 = new Customer("张八", '男', 80, "134234234", "zhang8@qq.com");

        System.out.println(cust1.say());
        System.out.println(cust2.say());
        System.out.println(cust3.say());
        System.out.println(cust4.say());
        System.out.println(cust5.say());
        System.out.println(cust6.say());
        System.out.println(cust7.say());
        System.out.println(cust8.say());

        System.out.println("*********************************************************************");

        CustomerList customerList = new CustomerList(8); // 内部数组的长度为
        boolean b1 = customerList.addCustomer(cust1); // 把张一添加到数组中
        boolean b2 = customerList.addCustomer(cust2); // 把张二添加到数组中
        boolean b3 = customerList.addCustomer(cust3); // 把张三添加到数组中
        boolean b4 = customerList.addCustomer(cust4); // 把张四添加到数组中
        boolean b5 = customerList.addCustomer(cust5); // 把张五添加到数组中

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
        System.out.println(b4);
        System.out.println(b5);

		/*
		Customer[] arr = customerList.getCustomers();
		//arr[0] = cust1; 添加对象的功能最好让类自已完成
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null) {
				System.out.println(arr[i].say());
			} else {
				System.out.println(arr[i]);
			}
		}
		*/
        Customer[] arr = customerList.getAllCustomers(); // 获取完美数组
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].say());
        }

        System.out.println("*********************************************************************");

        Customer customer = customerList.getCustomer(2); // 获取指定下标位置处的对象
        if (customer != null) { // 返回的对象有可能为空!!!
            System.out.println(customer.say());
        } else {
            System.out.println("下标不对");
        }

        System.out.println("*********************************************************************");
        customerList.deleteCustomer(1);

        Customer[] allCustomers = customerList.getAllCustomers();
        for (int i = 0; i < allCustomers.length; i++) {
            System.out.println(allCustomers[i].say());
        }

        //customerList.setRealCount(1);
    }
}
