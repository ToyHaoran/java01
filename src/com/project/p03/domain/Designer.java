package com.project.p03.domain;

import com.project.p03.service.Status;

public class Designer extends Programmer {

    private double bonus;

    public Designer() {
        super();
    }

    public Designer(int id,
                    String name,
                    int age,
                    double salary,
                    int memberId,
                    Status status,
                    Equipment equipment,
                    double bonus) {
        super(id, name, age, salary, memberId, status, equipment);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return say() + "\t设计师\t" + getStatus() + "\t" + bonus + "\t\t" + getEquipment();
    }

    //TID/ID	姓名	 年龄	工资 	职位 	奖金 	股票
    public String toString2() {
        return getMemberId() + "/" + say() + "\t设计师\t" + bonus;
    }

}
