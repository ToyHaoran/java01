package com.project.p03.domain;

public class PC implements Equipment {

    private String model; // : String // 型号
    private String display; // : String // 显示器

    public PC() {
    }

    public PC(String model, String display) {
        super();
        this.model = model;
        this.display = display;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    @Override
    public String toString() {
        return model + "(" + display + ")";
    }

    @Override
    public String getDescription() {
        return toString();
    }

}
