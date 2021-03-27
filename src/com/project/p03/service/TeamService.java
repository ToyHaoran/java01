package com.project.p03.service;

import com.project.p03.domain.Architect;
import com.project.p03.domain.Designer;
import com.project.p03.domain.Employee;
import com.project.p03.domain.Programmer;

public class TeamService {

    private static int counter = 1; // 用来给新加的成员赋予TID

    public final int MAX_MEMBER = 6; // 表示团队的最大成员数
    private Programmer[] team = new Programmer[MAX_MEMBER]; // 最核心的数组存储
    private int realCount = 0; // 计数器, 也是控制数组最重要

    /**
     * 	方法：向团队中添加成员
     参数：待添加成员的对象
     异常：添加失败， TeamException中包含了失败原因
     */
    public void addMember(Employee e) throws TeamException {
        if (realCount == team.length) { //if (数组已满) {
            throw new TeamException("团队已满, 无法添加");
        }
        if (!(e instanceof Programmer)) {
            throw new TeamException("该成员不是开发人员，无法添加");
        }
        Programmer programmer = (Programmer)e;
        if (programmer.getMemberId() != 0) {
            throw new TeamException("该员已是团队成员");
        }
        if (programmer.getStatus().equals(Status.VOCATION)) {
            throw new TeamException("该员正在休假，无法添加");
        }
        int architect = 0;
        int designer = 0;
        int programmers = 0;
        for (int i = 0; i < realCount; i++) {
            if (team[i] instanceof Architect) {
                architect++;
            } else if (team[i] instanceof Designer) {
                designer++;
            } else {
                programmers++;
            }
        }
        if (programmer instanceof Architect) {
            if (architect == 1) {
                throw new TeamException("团队中只能有一名架构师");
            }
        } else if (programmer instanceof Designer) {
            if (designer == 2) {
                throw new TeamException("团队中只能有两名设计师");
            }
        } else {
            if (programmers == 3) {
                throw new TeamException("团队中只能有三名程序员");
            }
        }

        // 给新成员赋予TID, 并改状态
        programmer.setMemberId(counter++);
        programmer.setStatus(Status.BUSY);
        // 把参数中的对象保存在数组中, 下标由计数器控制 // 调整计数器
        this.team[realCount++] = programmer; // 先用后加
    }

    /**
     * 	方法：返回当前团队的所有有效对象
     返回：包含所有成员对象的数组，数组大小与成员人数一致
     */
    public Programmer[] getTeam() {
        // 1) 创建新数组, 容量是计数器
        Programmer[] newArr = new Programmer[realCount];
        // 2) 依次把内部数组中所有有效对象保存在新数组中
        for (int i = 0; i < realCount; i++) {
            newArr[i] = this.team[i];
        }
        // 3) 返回新数组
        return newArr;
    }

    /**
     * 	方法：从团队中删除成员
     参数：待删除成员的memberId
     异常：删除失败， TeamException中包含了失败原因
     */
    public void removeMember(int memberId) throws TeamException {
        // 根据memberId找到下标
        int index = -1; // 先赋值一个无效下标
        for (int i = 0; i < realCount; i++) {
            if (team[i].getMemberId() == memberId) {
                index = i;
                break;
            }
        }
        if (index == -1) { // 如果index没有被刷新过, 说明没有找到目标
            throw new TeamException("没有指定TID[" + memberId + "]的成员");
        }

        // 删除前, 把要删除的目标对象的TID, 状态 修改
        team[index].setMemberId(0);
        team[index].setStatus(Status.FREE);

        // 1) 把要删除的下标位置处置为空洞
        team[index] = null;
        // 2) 从要删除的下标位置开始, 依次把右侧相邻的元素复制到左边
        for (int i = index; i < realCount - 1; i++) {
            team[i] = team[i + 1];
        }
        // 3) 把之前的最有有效元素位置处置为空洞   4) 调整计数器
        team[--realCount] = null; // 先减后用
    }

}
