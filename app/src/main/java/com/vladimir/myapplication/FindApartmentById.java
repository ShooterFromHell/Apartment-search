package com.vladimir.myapplication;

import com.google.gson.annotations.SerializedName;

public class FindApartmentById {
    @SerializedName("beautiful_url")
    private String beautiful_url;

    @SerializedName("description")
    private String description;

    @SerializedName("description_uk")
    private String description_uk;

    public FindApartmentById(String beautiful_url, String description, String description_uk) {
        this.beautiful_url = beautiful_url;
        this.description = description;
        this.description_uk =description_uk;
    }

    public String getBeautiful_url() {
        return beautiful_url;
    }

    public void setBeautiful_url(String beautiful_url) {
        this.beautiful_url = beautiful_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription_uk() {
        return description_uk;
    }

    public void setDescription_uk(String description_uk) {
        this.description_uk = description_uk;
    }
}
