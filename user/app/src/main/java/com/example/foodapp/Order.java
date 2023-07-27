package com.example.foodapp;

import java.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;

enum Status {
    ACTIVE, COMPLETED, USER_REQUESTED_CANCEL, USER_CANCELLED, RESTAURANT_CANCELLED
}

public class Order {
    private int id;
    private int restaurantId;
    private int userId;
    private int userAddressId;
    private String restaurantName;
    private String time;
    private double price;
    private Status status;
    private ArrayList<Food> foods;

    public Order() {
    }

    public Order(int id, int restaurantId, int userId, String restaurantName, String time, double price, Status status, ArrayList<Food> foods) {
        this.id = id;
        this.restaurantId = restaurantId;
        this.userId = userId;
        this.restaurantName = restaurantName;
        this.time = time;
        this.price = price;
        this.status = status;
        this.foods = foods;
    }

    public Order(int restaurantId, int userId, String restaurantName, double price, ArrayList<Food> foods) {
        this.restaurantId = restaurantId;
        this.userId = userId;
        this.restaurantName = restaurantName;
        this.time = time;
        this.price = price;
        this.foods = foods;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRestaurantId() {
        return this.restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserAddressId() { return this.userAddressId; }

    public void setUserAddressId (int userAddressId) { this.userAddressId = userAddressId; }

    public String getRestaurantName() {
        return this.restaurantName;
    }

    public void setRestaurantName( String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Status getStatus() {
        return this.status;
    }

    public String getStatusString() {
        if (status == Status.ACTIVE) {
            return "Your order is being prepared \uD83D\uDD52";
        }
        else if (status == Status.COMPLETED) {
            return "Order has been delivered ✅";
        }
        else if (status == Status.USER_REQUESTED_CANCEL) {
            return "Waiting for restaurant to confirm cancellation ⏳";
        }
        else if (status == Status.USER_CANCELLED) {
            return "Order has been cancelled at your request \uD83D\uDED1";
        }
        else if (status == Status.RESTAURANT_CANCELLED) {
            return "Restaurant has cancelled the order ❌";
        }
        return "";
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public ArrayList<Food> getFoods() {
        return this.foods;
    }

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Order)) {
            return false;
        }
        Order order = (Order) o;
        return id == order.id && restaurantId == order.restaurantId && userId == order.userId && Objects.equals(time, order.time) && price == order.price && Objects.equals(status, order.status) && Objects.equals(foods, order.foods);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", restaurantId='" + getRestaurantId() + "'" +
                ", userId='" + getUserId() + "'" +
                ", time='" + getTime() + "'" +
                ", price='" + getPrice() + "'" +
                ", status='" + getStatus() + "'" +
                ", foods='" + getFoods() + "'" +
                "}";
    }
}


