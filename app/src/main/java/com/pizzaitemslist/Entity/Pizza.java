package com.pizzaitemslist.Entity;

import java.util.Objects;

public class Pizza {
    private String name;
    private int diameter;
    private String imgURL;
    private String description;
    private int wight;
    private float price;

    public Pizza() {}

    public Pizza(String name, int diameter, String imgURL, String description,int weight, float oldPrice) {
        this.name = name;
        this.diameter = diameter;
        this.imgURL = imgURL;
        this.description = description;
        this.wight = weight;
        this.price = oldPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getWight() {
        return wight;
    }

    public void setWight(int wight) {
        this.wight = wight;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizza pizza = (Pizza) o;
        return diameter == pizza.diameter && wight == pizza.wight && Float.compare(pizza.price, price) == 0 && Objects.equals(name, pizza.name) && Objects.equals(imgURL, pizza.imgURL) && Objects.equals(description, pizza.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, diameter, imgURL, description, wight, price);
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", diameter=" + diameter +
                ", imgURL='" + imgURL + '\'' +
                ", description='" + description + '\'' +
                ", wight=" + wight +
                ", price=" + price +
                '}';
    }
}
