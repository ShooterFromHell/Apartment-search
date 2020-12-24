package com.vladimir.myapplication.Model;

import com.google.gson.annotations.SerializedName;

public class ID {

    @SerializedName("items")
    private Integer[] items;

    @SerializedName("count")
    private Integer count;

    public ID(Integer[] items, Integer count) {
        this.items = items;
        this.count = count;
    }

    public Integer[] getItems() {
        return items;
    }

    public void setItems(Integer[] items) {
        this.items = items;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
