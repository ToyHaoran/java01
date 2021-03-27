package com.project.p03.view;

import com.project.p03.domain.Employee;
import com.project.p03.domain.Programmer;
import com.project.p03.service.CompanyServcie;
import com.project.p03.service.TeamException;
import com.project.p03.service.TeamService;

public class TeamView {

    // 关联员工管理器和团队管理器
    private CompanyServcie companyServcie = new CompanyServcie();
    private TeamService teamService = new TeamService();

    public void enterMainMenu() {// 不轻易返回
        boolean loopFlag = true;
        while (loopFlag) {
            listAllEmployees();
            System.out.print("1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4)  : ");
            char selection = TSUtility.readMenuSelection();
            switch (selection) {
                case '1': listTeam(); break;
                case '2': addMember(); break;
                case '3': deleteMember(); break;
                case '4': loopFlag = false; break;
            }
        }
    }

    // 列出所有员工
    private void listAllEmployees() {
        System.out.println("-------------------------------------开发团队调度软件--------------------------------------");
        System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备");
        Employee[] allEmployees = companyServcie.getAllEmployees();
        for (Employee employee : allEmployees) {
            System.out.println(employee);
        }
        System.out.println("---------------------------------------------------------------------------------------------------");
    }

    // 添加团队成员
    private void addMember() {
        System.out.println("---------------------添加成员---------------------");
        System.out.print("请输入要添加的员工ID : ");
        int id = TSUtility.readInt();
        try {
            // 获取到员工对象
            Employee employee = companyServcie.getEmployee(id);
            // 再把员工对象添加到团队中
            teamService.addMember(employee);
            System.out.println("添加成功");
        } catch (TeamException e) {
            System.out.println("添加失败, 原因 : " + e.getMessage());
        }
        //按回车键继续...
        TSUtility.readReturn();
    }

    // 删除团队成员
    private void deleteMember() {
        System.out.println("---------------------删除成员---------------------");
        System.out.print("请输入要删除员工的TID : ");
        int tid = TSUtility.readInt();
        System.out.print("确认是否删除(Y/N) : ");
        char confirm = TSUtility.readConfirmSelection();
        if (confirm == 'Y') {
            try {
                teamService.removeMember(tid);
                System.out.println("删除成功");
            } catch (TeamException e) {
                System.out.println("删除失败, 原因 : " + e.getMessage());
            }
            TSUtility.readReturn();
        }
    }

    // 列出团队
    private void listTeam() {
        System.out.println("--------------------团队成员列表---------------------");
        System.out.println();
        System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票");
        // 获取团队
        Programmer[] team = teamService.getTeam();
        for (Programmer programmer : team) {
            System.out.println(programmer.toString2());
        }
        System.out.println("-----------------------------------------------------");
    }

}
