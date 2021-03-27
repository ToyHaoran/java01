package com.project.p03.domain;

import com.project.p03.service.Status;

public class Architect extends Designer {

    private int stock;

    public Architect() {
        super();
    }

    public Architect(int id,
                     String name,
                     int age,
                     double salary,
                     int memberId,
                     Status status,
                     Equipment equipment,
                     double bonus,
                     int stock) {
        super(id, name, age, salary, memberId, status, equipment, bonus);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return super.say() + "\t架构师\t" + getStatus() + "\t" + getBonus() + "\t" + stock + "\t" + getEquipment();
    }

    //TID/ID	姓名	 年龄	工资 	职位 	奖金 	股票
    public String toString2() {
        return getMemberId() + "/" + say() + "\t架构师\t" + getBonus() + "\t" + stock;
    }

}