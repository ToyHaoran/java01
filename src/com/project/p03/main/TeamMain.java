package com.project.p03.main;

import com.project.p03.domain.*;
import com.project.p03.service.CompanyServcie;
import com.project.p03.service.Status;
import com.project.p03.service.TeamException;
import com.project.p03.view.TeamView;

public class TeamMain {

    public static void main(String[] args) {
        new TeamView().enterMainMenu();
    }

    public static void main3(String[] args) {
        CompanyServcie companyServcie = new CompanyServcie();
        Employee[] employees = companyServcie.getAllEmployees();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        System.out.println("*************************");
        Employee employee;
        try {
            employee = companyServcie.getEmployee(50);
            System.out.println(employee);
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main2(String[] args) {
        //public Employee(int id, String name, int age, double salary) {
        Employee emp1 = new Employee(1, "张三", 30, 3000);
        System.out.println(emp1);
		/*
		public Programmer(int id,
						  String name,
						  int age,
						  double salary,
						  int memberId,
						  Status status,
						  Equipment equipment) {*/
        Equipment equipment1 = new NoteBook("MBP", 12000);
        Employee emp2 = new Programmer(2, "李四", 40, 4000, 0, Status.FREE, equipment1);
        System.out.println(emp2);

		/*
		 * public Designer( int id,
							String name,
							int age,
							double salary,
							int memberId,
							Status status,
							Equipment equipment,
							double bonus) {
		 * */
        Equipment equipment2 = new PC("DellX10", "Dell24寸");
        Employee emp3 = new Designer(3, "王五", 50, 5000, 0, Status.VOCATION, equipment2, 50000);
        System.out.println(emp3);

		/*
		 * public Architect(int id,
							 String name,
							 int age,
							 double salary,
							 int memberId,
							 Status status,
							 Equipment equipment,
							 double bonus,
							 int stock) {
		 * */
        Equipment equipment3 = new Printer("激光", "HP2000");
        Employee emp4 = new Architect(4, "赵六", 60, 6000, 0, Status.FREE, equipment3, 60000, 7000);
        System.out.println(emp4);
    }
}
