package com.project.p03.domain;

public class NoteBook implements Equipment {

    private String model; // : String // 型号
    private double price; // : double // 价格

    public NoteBook() {
    }

    public NoteBook(String model, double price) {
        super();
        this.model = model;
        this.price = price;
    }

    @Override
    public String toString() {
        return model + "(" + price + ")";
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String getDescription() {
        return toString();
    }

}
