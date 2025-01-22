package com.learnandroid.foodorderingapp.Models;

public class OrderModel {

    int ordered_food_image;
    String ordered_food_name, ordered_food_price,ordered_number;

    public OrderModel(int ordered_food_image, String ordered_food_name, String ordered_food_price, String ordered_number) {
        this.ordered_food_image = ordered_food_image;
        this.ordered_food_name = ordered_food_name;
        this.ordered_food_price = ordered_food_price;
        this.ordered_number = ordered_number;
    }

    public int getOrdered_food_image() {
        return ordered_food_image;
    }

    public void setOrdered_food_image(int ordered_food_image) {
        this.ordered_food_image = ordered_food_image;
    }

    public String getOrdered_food_name() {
        return ordered_food_name;
    }

    public void setOrdered_food_name(String ordered_food_name) {
        this.ordered_food_name = ordered_food_name;
    }

    public String getOrdered_food_price() {
        return ordered_food_price;
    }

    public void setOrdered_food_price(String ordered_food_price) {
        this.ordered_food_price = ordered_food_price;
    }

    public String getOrdered_number() {
        return ordered_number;
    }

    public void setOrdered_number(String ordered_number) {
        this.ordered_number = ordered_number;
    }
}
