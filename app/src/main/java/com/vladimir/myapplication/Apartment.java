package com.vladimir.myapplication;

public class Apartment {
    int state;
    String city;
    int price_from, price_to;
    int rooms;
    int area_from, area_to;
    int kitchen_from, kitchen_to;
    int floor_from, floor_to;

    public Apartment(int state, String city, int price_from, int price_to, int rooms, int area_from, int area_to, int kitchen_from, int kitchen_to, int floor_from, int floor_to) {
        this.state = state;
        this.city = city;
        this.price_from = price_from;
        this.price_to = price_to;
        this.rooms = rooms;
        this.area_from = area_from;
        this.area_to = area_to;
        this.kitchen_from = kitchen_from;
        this.kitchen_to = kitchen_to;
        this.floor_from = floor_from;
        this.floor_to = floor_to;
    }

    public int getPrice_from() {
        return price_from;
    }

    public void setPrice_from(int price_from) {
        this.price_from = price_from;
    }

    public int getPrice_to() {
        return price_to;
    }

    public void setPrice_to(int price_to) {
        this.price_to = price_to;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getArea_from() {
        return area_from;
    }

    public void setArea_from(int area_from) {
        this.area_from = area_from;
    }

    public int getArea_to() {
        return area_to;
    }

    public void setArea_to(int area_to) {
        this.area_to = area_to;
    }

    public int getKitchen_from() {
        return kitchen_from;
    }

    public void setKitchen_from(int kitchen_from) {
        this.kitchen_from = kitchen_from;
    }

    public int getKitchen_to() {
        return kitchen_to;
    }

    public void setKitchen_to(int kitchen_to) {
        this.kitchen_to = kitchen_to;
    }

    public int getFloor_from() {
        return floor_from;
    }

    public void setFloor_from(int floor_from) {
        this.floor_from = floor_from;
    }

    public int getFloor_to() {
        return floor_to;
    }

    public void setFloor_to(int floor_to) {
        this.floor_to = floor_to;
    }
}
