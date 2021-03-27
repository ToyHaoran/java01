package com.project.p03.service;

import com.project.p03.domain.*;

public class CompanyServcie {

    // 多态数组, 保存所有员工(包括程序员, 设计师, 架构师)
    private Employee[] employees;

    public CompanyServcie() {
        // 自动导入数据, 数据在Data类中
        // 处理设备对象
        Equipment[] eqs = new Equipment[Data.EQUIPMENTS.length];
        for (int i = 0; i < Data.EQUIPMENTS.length; i++) {
            String[] child = Data.EQUIPMENTS[i];
            if (child.length == 0) {
                continue;
            }
            // 取识别码, 就是子数组下标为0的元素
            int code = Integer.parseInt(child[0]);
            switch (code) {
                case Data.PC: //PC      :21, model, display
                    //{"21", "宏碁 ", "AT7-N52"},
                    eqs[i] = new PC(child[1], child[2]);
                    break;
                case Data.NOTEBOOK : //NoteBook:22, model, price
                    //{"22", "联想Y5", "6000"},
                    eqs[i] = new NoteBook(child[1], Integer.parseInt(child[2]));
                    break;
                case Data.PRINTER : //Printer :23, type, name
                    //{"23", "激光", "佳能 2900"},
                    eqs[i] = new Printer(child[1], child[2]);
                    break;
            }
        }
		/* 在Service中不要打印
		for (Equipment equipment : eqs) {
			System.out.println(equipment);
		}
		*/
        this.employees = new Employee[Data.EMPLOYEES.length];
        for (int i = 0; i < Data.EMPLOYEES.length; i++) {
            String[] child = Data.EMPLOYEES[i];
            // 取识别码
            int code = Integer.parseInt(child[0]);
            int id = Integer.parseInt(child[1]);
            String name = child[2];
            int age = Integer.parseInt(child[3]);
            double salary = Integer.parseInt(child[4]);
            int memberId = 0;
            Status status = Status.FREE;
            if ((int)(Math.random() * 10) % 7 == 6) {
                status = Status.VOCATION;
            }
            Equipment equipment = eqs[i];
            // 穷举识别码
            switch (code) {// 不同的识别码创建不同的对象 // 所有对象保存在employees[]中.
                case Data.EMPLOYEE://Employee  :  10, id, name, age, salary : {"10", "1", "段誉", "22", "3000"},
                    this.employees[i] = new Employee(id, name, age, salary);
                    break;
                case Data.PROGRAMMER://Programmer:  11, id, name, age, salary : {"11", "3", "任我行", "23", "7000"},
                    this.employees[i] = new Programmer(id, name, age, salary, memberId, status, equipment);
                    break;
                case Data.DESIGNER://Designer  :  12, id, name, age, salary, bonus :{"12", "5", "周芷若", "28", "10000", "5000"},
                    double bonus = Integer.parseInt(child[5]);
                    this.employees[i] = new Designer(id, name, age, salary, memberId, status, equipment, bonus);
                    break;
                case Data.ARCHITECT://Architect :  13, id, name, age, salary, bonus, stock:{"13", "2", "令狐冲", "32", "18000", "15000", "2000"},
                    bonus = Integer.parseInt(child[5]);
                    int stock = Integer.parseInt(child[6]);
                    this.employees[i] = new Architect(id, name, age, salary, memberId, status, equipment, bonus, stock);
                    break;
            }
        }
		/*
		for (Employee employee : employees) {
			System.out.println(employee);
		}
		*/
    }

    public Employee[] getAllEmployees() {
        return employees;
    }

    /**
     * 	方法：获取指定ID的员工对象。
     * 	参数：指定员工的ID
     返回：指定员工对象
     异常：找不到指定的员工
     */
    public Employee getEmployee(int id) throws TeamException {
        // 遍历员工数组
        for (Employee employee : employees) {
            // 如果某员工的id和参数id相等
            if (employee.getId() == id) {
                // 返回某员工
                return employee;
            }
        }
        // 循环结束后 直接抛出异常
        throw new TeamException("未找到指定ID[" + id + "]的员工");
    }


}