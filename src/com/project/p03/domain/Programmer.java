package com.project.p03.domain;

import com.project.p03.service.Status;

public class Programmer extends Employee {

    private int memberId;// : int // TID
    private Status status;// : Status // 状态
    private Equipment equipment; // : // 领用的设备

    public Programmer() {
        super();
    }

    public Programmer(int id,
                      String name,
                      int age,
                      double salary,
                      int memberId,
                      Status status,
                      Equipment equipment) {
        super(id, name, age, salary);
        this.memberId = memberId;
        this.status = status;
        this.equipment = equipment;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return super.toString() + "\t程序员\t" + status + "\t\t\t" + equipment;
    }

    //TID/ID	姓名	 年龄	工资 	职位 	奖金 	股票
    public String toString2() {
        return memberId + "/" + say() + "\t程序员";
    }
}

