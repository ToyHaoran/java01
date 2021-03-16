package com.project.p02;

/**
 * 这个类用于向用户显示菜单及从用户获取信息
 * 是典型的UI(user interface)
 */
public class CustomerView {

    // 关联核心的管理器
    private CustomerList customerList = new CustomerList(10);

    // 是项目真正的入口
    public void enterMainMenu() {
        // 不能轻易返回
        // 声明布尔, 控制循环
        boolean loopFlag = true;
        // 写一个循环
        while (loopFlag) {
            // 打印主菜单
            System.out.println("-----------------客户信息管理软件-----------------");
            System.out.println();
            System.out.println("	        1 添 加 客 户");
            System.out.println("	        2 修 改 客 户");
            System.out.println("	        3 删 除 客 户");
            System.out.println("	        4 客 户 列 表");
            System.out.println("	        5 退 出");
            System.out.println();
            System.out.print("	       请选择(1-5) : ");
            // 通过工具类获取用户的键盘输入
            char choice = CMUtility.readMenuSelection();
            // 对用户的输入分支
            switch (choice) {
                // 如果是'1'  调用方法 addNewCustomer()
                case '1' : addNewCustomer(); break;
                // 如果是'2'  调用方法 modifyCustomer()
                case '2' : modifyCustomer(); break;
                // 如果是'3' 调用方法 deleteCustomer();
                case '3' : deleteCustomer(); break;
                // 如果是'4' 调用方法 listAllCustomers()
                case '4' : listAllCustomers(); break;
                // 如果是'5' 修改控制循环的布尔为false
                case '5' :
                    System.out.print("确认退出? (Y/N) : ");
                    char confirm = CMUtility.readConfirmSelection();
                    if (confirm == 'Y') {
                        loopFlag = false;
                    }
                    break;
            }
        }
    }

    private void addNewCustomer() { // 添加新客户
        System.out.println("---------------------添加客户---------------------");
        //姓名：张三
        //打印提醒信息 姓名 :
        System.out.print("姓名 : ");
        //通过调用工具类的方法来获取用户从键盘输入的姓名数据
        String name = CMUtility.readString(10);
        //性别：男
        //打印提醒 信息 性别 :
        System.out.print("性别 : ");
        //通过调用工具类的方法来获取用户从键盘输入的性别数据
        char gender = CMUtility.readChar();
        //年龄：30
        System.out.print("年龄 : ");
        int age = CMUtility.readInt();
        //电话：010-56253825
        System.out.print("电话 : ");
        String phone = CMUtility.readString(15);
        //邮箱：zhang@abc.com
        System.out.print("邮箱 : ");
        String email = CMUtility.readString(50);
        // 创建成一个实体对象
        Customer customer = new Customer(name, gender, age, phone, email);
        // 再把此对象添加到管理器中, 通过调用它的方法完成
        boolean flag = customerList.addCustomer(customer);
        if (flag) {
            System.out.println("---------------------添加完成---------------------");
        } else {
            System.out.println("---------------------添加失败, 原因 : 容量已满---------------------");
        }
        listAllCustomers();
    }

    private void modifyCustomer() { // 修改客户
        System.out.println("---------------------修改客户---------------------");
        System.out.print("请选择待修改客户编号(-1退出) : ");
        int no = CMUtility.readInt();
        //如果是-1, 就不删除, 提前return
        if (no == -1) {
            return;
        }
        //根据编号从管理器中获取到要修改的目标对象
        Customer target = customerList.getCustomer(no - 1);
        //如果目标对象为空, 打印输出编号错误
        if (target == null) {
            System.out.println("编号错误, 未找到目标客户信息");
            return;
        }
        //如果目标对象不空, 才真的修改
        System.out.println("<直接回车表示不修改>");

        System.out.print("姓名(" + target.getName() + ") : ");
        String name = CMUtility.readString(10, target.getName());
        //无条件修改目标对象的name属性
        target.setName(name);

        System.out.print("性别(" + target.getGender() + ") : ");
        char gender = CMUtility.readChar(target.getGender());
        //无条件修改目标对象的gender属性
        target.setGender(gender);

        System.out.print("年龄(" + target.getAge() + ") : ");
        int age = CMUtility.readInt(target.getAge());
        //无条件修改目标对象的age属性
        target.setAge(age);

        System.out.print("电话(" + target.getPhone() + ") : ");
        //获取电话数据
        String phone = CMUtility.readString(15, target.getPhone());
        //无条件设置
        target.setPhone(phone);

        System.out.print("邮箱(" + target.getEmail() + ") : ");
        //获取邮箱数据
        String email = CMUtility.readString(50, target.getEmail());
        //无条件设置
        target.setEmail(email);
        System.out.println("---------------------修改完成---------------------");

        listAllCustomers();
    }

    private void deleteCustomer() { // 删除客户
        System.out.println("---------------------删除客户---------------------");
        listAllCustomers();
        System.out.print("请选择待删除客户编号(-1退出) : ");
        //获取用户从键盘输入的编号
        int no = CMUtility.readInt();
        //如果是-1, 就不删除, 提前return
        if (no == -1) {
            return;
        }
        System.out.print("确认是否删除(Y/N) : ");
        char confirm = CMUtility.readConfirmSelection();
        if (confirm == 'Y') {
            //调用管理器的方法完成删除
            boolean flag = customerList.deleteCustomer(no - 1);
            if (flag) {
                System.out.println("---------------------删除完成---------------------");
            } else {
                System.out.println("---------------------删除失败, 原因 : 编号错误---------------------");
            }
        }
        listAllCustomers();
    }

    private void listAllCustomers() { // 客户列表
        System.out.println("---------------------------客户列表---------------------------");
        System.out.println("编号\t姓名\t性别\t年龄\t电话\t邮箱");
        // 从管理器中获取所有有效对象的数组, 遍历数组, 打印输出
        Customer[] allCustomers = customerList.getAllCustomers();
        for (int i = 0; i < allCustomers.length; i++) {
            System.out.println((i + 1) + "\t" + allCustomers[i].say());
        }
        System.out.println("-------------------------客户列表完成-------------------------");
    }
}
